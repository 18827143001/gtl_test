package com.guotl.set;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackages = "com.guotl.set") // 扫描组件的包名(basePackages = "com.dl")
// 指定扫描的mapper接口所在的包！
@MapperScan("com.guotl.set.dao")
public class SetApplication {

    public static void main(String[] args) {
        SpringApplication.run(SetApplication.class, args);
    }

    //数据库实体类
    private static final String TYPE_ALIASES_PACKAGE = "com.guotl.set.entity";
    //数据库的实现文件
    private static final String MAPPER_LOCATION = "classpath*:/mybatis/**/*.xml";
    /**
     * 不使用原生自带的数据库，采用自定义数据库配置
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    @Autowired
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource); // mybatis.typeAliasesPackage：指定domain类的基包，即指定其在*Mapper.xml文件中可以使用简名来代替全类名
        sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
        sqlSessionFactoryBean
                .setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        // 自定义数据库配置的时候，需要将pageHelper的bean注入到Plugins中，如果采用系统默认的数据库配置，则只需要定义pageHelper的bean，会自动注入。
        return sqlSessionFactoryBean.getObject();
    }

}
