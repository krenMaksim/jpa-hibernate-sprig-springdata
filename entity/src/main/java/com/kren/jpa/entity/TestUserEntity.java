package com.kren.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_user")
public class TestUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_phone")
    private String userPhone;

    public TestUserEntity() {

    }

    public Integer getUserId() {
	return userId;
    }

    public void setUserId(Integer userId) {
	this.userId = userId;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getUserPhone() {
	return userPhone;
    }

    public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((userId == null) ? 0 : userId.hashCode());
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
	result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	TestUserEntity other = (TestUserEntity) obj;
	if (userId == null) {
	    if (other.userId != null) {
		return false;
	    }
	} else if (!userId.equals(other.userId)) {
	    return false;
	}
	if (userName == null) {
	    if (other.userName != null) {
		return false;
	    }
	} else if (!userName.equals(other.userName)) {
	    return false;
	}
	if (userPhone == null) {
	    if (other.userPhone != null) {
		return false;
	    }
	} else if (!userPhone.equals(other.userPhone)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "TestUserEntity [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + "]";
    }
}
