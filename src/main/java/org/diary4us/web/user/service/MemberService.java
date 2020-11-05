package org.diary4us.web.user.service;

import org.diary4us.web.user.dto.Member;

public interface MemberService extends UserDbService{
    void addMember(Member member, boolean b);
    Member getMemberByEmail(String loginUserId);
}

