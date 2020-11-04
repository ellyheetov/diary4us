package org.diary4us.web.user.dao;

public class MemberRoleDaoSqls {
    public static final String SELECT_ALL_BY_EMAIL =
            "SELECT user.id, user_id, name, password, email, phone" +
            " FROM user_role JOIN user ON user_role.user_id = user.id" +
            " WHERE email = :email;";
}
