package org.diary4us.web.user.service;

import java.util.List;

public interface UserDbService {
    public UserEntity getUser(String loginUserId);
    public List<UserRoleEntity> getUserRoles(String loginUserId);
}
