package com.guotl.set.config.shiro;

import java.util.HashSet;
import java.util.Set;

import com.guotl.set.entity.sys.User;
import com.guotl.set.service.sys.UserService;
import com.guotl.set.util.AppMD5Util;
import com.guotl.set.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



public class AuthRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(AuthorizingRealm.class);
	@Autowired
	private UserService userService;
	/*@Autowired
	StringRedisTemplate stringRedisTemplate;*/

    /**
     * 用来进行权限的分配
     * @param principals
     * @return
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("======用户授权认证======");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> roles = new HashSet<>();
		roles.add("role");
		info.setRoles(roles);
		/*Set<String> permissions = new HashSet<>();
		permissions.add("菜单，按钮");
		info.setStringPermissions(permissions);// 将权限放入shiro中.*/
		return info;
	}

    /**
     * 用来进行身份认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;// 获取用户输入的token
        String username = utoken.getUsername();
        String password = String.valueOf(utoken.getPassword());
        logger.info("======用户登陆认证======" + username);
        User user = userService.loginvalidate(username, password);
        Session currentSession = SecurityUtils.getSubject().getSession();
        try {
            if (user != null) {
                UserUtil.saveUserToSession(currentSession, user);
                return new SimpleAuthenticationInfo(user, password, this.getClass().getName());// 放入shiro.调用CredentialsMatcher检验密码
            } else {
                UserUtil.saveUserToSession(currentSession, null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
	}

}
