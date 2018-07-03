package com.guotl.set.entity.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @ClassName: User
 * @Description: 用戶管理表
 * @author: Guotl
 * @date:  下午4:49:10
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8933489345367697163L;

	private int id;
	private String username;
    private String password;
	private String account;
	private String remarks;
	private int age;
	private int state;
	private Date datetime = new Date();
	private int sex;
    private String rolelist;
    private String perminsStrlist;
	private List<String> role;
	private List<String> permins;
	private String note1;
	private String note2;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

    public List<String> getPermins() {
        return permins;
    }

    public void setPermins(List<String> permins) {
        this.permins = permins;
    }

    public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}
