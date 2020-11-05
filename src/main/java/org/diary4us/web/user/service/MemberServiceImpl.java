package org.diary4us.web.user.service;

import org.diary4us.web.user.dao.MemberDao;
import org.diary4us.web.user.dao.MemberRoleDao;
import org.diary4us.web.user.dto.Member;
import org.diary4us.web.user.dto.MemberRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;
    private final MemberRoleDao memberRoleDao;

    public MemberServiceImpl(MemberDao memberDao, MemberRoleDao memberRoleDao){
        this.memberDao = memberDao;
        this.memberRoleDao = memberRoleDao;
    }

    @Override
    public void addMember(Member member, boolean b) {

    }

    @Override
    public Member getMemberByEmail(String loginUserId) {
        return memberDao.getMemberByEmail(loginUserId);
    }

    @Override
    @Transactional
    public UserEntity getUser(String loginUserId) {
        Member member = memberDao.getMemberByEmail(loginUserId);
        return new UserEntity(member.getEmail(), member.getPassword());
    }

    @Override
    public List<UserRoleEntity> getUserRoles(String loginUserId) {

        List<MemberRole> memberRoles = memberRoleDao.getRolesByEmail(loginUserId);
        List<UserRoleEntity> list = new ArrayList<>();

        for(MemberRole memberRole : memberRoles){
            list.add(new UserRoleEntity(loginUserId, memberRole.getRoleName()));
        }
        return list;
    }
}
