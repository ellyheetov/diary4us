package org.diary4us.web.user.dao;

public class MemberDaoSqls {
    public static final String SELECT_ALL_BY_EMAIL = "SELECT id, name, password, email, phone FROM user WHERE email = :email";
}
