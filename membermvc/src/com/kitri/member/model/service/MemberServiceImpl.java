package com.kitri.member.model.service;

import java.util.*;


import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipcodeDto;
import com.kitri.member.model.dao.MemberDao;
import com.kitri.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

//	ΩÃ±€≈Ê ∆–≈œ!
	private static MemberService memberService;

	static {
		memberService = new MemberServiceImpl();
	}

	public static MemberService getMemberService() {
		return memberService;
	}

	private MemberServiceImpl() {
	}

// ø©±‚±Ó¬Ó ΩÃ±€≈Ê
	@Override
	public String idCheck(String id) {
		int cnt = MemberDaoImpl.getMemberDao().idCheck(id);
		String result = "";
		result += "<idcount> \n";
		result += "<cnt>" + cnt + "</cnt> \n";
		result += "</idcount>";
		return result;
	}

	@Override
	public String zipSearch(String doro) {
		String result = "";
		List<ZipcodeDto> list = MemberDaoImpl.getMemberDao().zipSearch(doro);
		System.out.println("1 :" + doro);
		result += "<ziplist> \n";

		for (ZipcodeDto zipDto : list) {
			result += "<zip> \n";
			result += "<zipcode>" + zipDto.getZipcode() + "</zipcode> \n";
			result += "<address><![CDATA[" + zipDto.getSido() + zipDto.getGugun() + zipDto.getUpmyon()
					+ zipDto.getDoro() + zipDto.getBuildingNumber() + zipDto.getSigugunBuildingName()
					+ "]]></address> \n";
			result += "</zip> \n";
		}
		result += "</ziplist>";
		System.out.println(result);
		return result;
	}

	@Override
	public int registerMember(MemberDetailDto detailDto) {

		return MemberDaoImpl.getMemberDao().registerMember(detailDto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("userpwd", pass);
		return MemberDaoImpl.getMemberDao().loginMember(map);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto detailDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
