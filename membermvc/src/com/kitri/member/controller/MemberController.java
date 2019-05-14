package com.kitri.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberServiceImpl;

public class MemberController {

	private static MemberController memberController;

	static {
		memberController = new MemberController();
	}

	private MemberController() {

	}

	public static MemberController getMemberController() {
		return memberController;
	}

	public String register(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		MemberDetailDto memberDetailDto = new MemberDetailDto();
		memberDetailDto.setId(request.getParameter("id"));
		memberDetailDto.setName(request.getParameter("name"));
		memberDetailDto.setPass(request.getParameter("pass"));
		memberDetailDto.setEmailid(request.getParameter("emailid"));
		memberDetailDto.setEmaildomain(request.getParameter("emaildomain"));
		memberDetailDto.setZipcode(request.getParameter("zipcode"));
		memberDetailDto.setAddress(request.getParameter("address"));
		memberDetailDto.setAddressDetail(request.getParameter("address_detail"));
		memberDetailDto.setTel1(request.getParameter("tel1"));
		memberDetailDto.setTel2(request.getParameter("tel2"));
		memberDetailDto.setTel3(request.getParameter("tel3"));
		int cnt = MemberServiceImpl.getMemberService().registerMember(memberDetailDto);

		request.setAttribute("userInfo", memberDetailDto);

		if (cnt == 2) {
			path = "/user/member/registerok.jsp";
		} else {
			path = "/user/member/registerfail.jsp";
		}
		return path;
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		MemberDto memberDto = MemberServiceImpl.getMemberService().loginMember(id, pass);
		if (memberDto != null) {
			//////////////////////// cookie ////////////////////////////
			String idsv = request.getParameter("idsave");
			System.out.println(idsv);
			if ("idsave".equals(idsv)) {
				System.out.println("2" + idsv);
				Cookie cookie = new Cookie("kid_inf", id);
				cookie.setDomain("localhost");
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60 * 60 * 24 * 365 * 50);
				response.addCookie(cookie);
			} else {
				Cookie[] cookie = request.getCookies();
				if (cookie != null) {
					for (Cookie c : cookie) {
						if (c.getName().equals("kid_inf")) {
							c.setDomain("localhost");
							c.setPath(request.getContextPath());
							c.setMaxAge(0);
							response.addCookie(c);
							break;
						}
					}
				}
			}
			//////////////////////// session ///////////////////////////
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", memberDto);
			path = "/user/login/loginok.jsp";
		} else {
			path = "/user/login/loginfail.jsp";
		}

		return path;
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.setAttribute("userInfo", null);
//		session.removeAttribute("userInfo");
		session.invalidate();
		return "/user/login/login.jsp";
	}

}