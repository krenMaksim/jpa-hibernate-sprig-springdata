package com.kren.jpa.entity.util;

import com.kren.jpa.entity.TestUserEntity;

public class DataUtil {
    private DataUtil() {
	throw new AssertionError();
    }

    public static TestUserEntity getUser() {
	TestUserEntity user = new TestUserEntity();
	user.setUserName("Bob");
	user.setUserPhone("666-66-66");

	return user;
    }
}
