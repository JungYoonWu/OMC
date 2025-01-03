package kr.ac.kopo.user.vo;

import java.util.Objects;

public class UserVO{

	private String userID;
	private String name;
	private String email;
	private String password;
	private String phone;
	private int roleID;
	private int userNo;
	private String roleName;
	public UserVO(String userID, String name, String email, String password, String phone, int roleID, int userNo,
			String roleName) {
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.roleID = roleID;
		this.userNo = userNo;
		this.roleName = roleName;
	}
	public UserVO() {
	}
	
	public UserVO(String userID, String name, String email, String password, String phone) {
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	public UserVO(String userID, String name, String email, String password, String phone, int roleID, int userNo) {
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.roleID = roleID;
		this.userNo = userNo;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass())return false;
		
		UserVO userVO = (UserVO)o;
		return Objects.equals(userID, userVO.userID);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userID);
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	@Override
	public String toString() {
		return "UserVO [userID=" + userID + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", roleID=" + roleID + ", userNo=" + userNo + ", roleName=" + roleName + "]";
	}
	
	
}
