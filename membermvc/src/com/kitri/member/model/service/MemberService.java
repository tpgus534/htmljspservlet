package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipcodeDto;

public interface MemberService {
	
	String idCheck(String id);
	String zipSearch(String doro);
	int registerMember(MemberDetailDto detailDto);
	MemberDto loginMember(String id, String pass);
	
	MemberDetailDto getMember(String id);
	int modifyMember(MemberDetailDto detailDto);
	int deleteMember(String id);
}
