package com.kitri.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.util.MoveUrl;
import com.kitri.util.SiteConstance;

@WebServlet("/user")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		String path = "/index.jsp";

		if ("mvjoin".equals(act)) {
			MoveUrl.redirect(request, response, "/user/member/member.jsp");
		} else if ("mvlogin".equals(act)) {
			MoveUrl.redirect(request, response, "/user/login/login.jsp");
		} else if ("idcheck".equals(act)) {
			String sid = request.getParameter("sid");
			String resultXml = MemberServiceImpl.getMemberService().idCheck(sid);

			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println(resultXml);
			out.print(resultXml);

		} else if ("zipsearch".equals(act)) {
			String doro = request.getParameter("doro");
			String resultXml = MemberServiceImpl.getMemberService().zipSearch(doro);
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(resultXml);

		} else if ("register".equals(act)) {
			path = MemberController.getMemberController().register(request, response);
			MoveUrl.forward(request, response, path);
		} else if ("login".equals(act)) {
			path = MemberController.getMemberController().login(request, response);
			MoveUrl.forward(request, response, path);
		} else if ("logout".equals(act)) {
			path= MemberController.getMemberController().logout(request, response);
			MoveUrl.redirect(request, response, path);
		} else if ("".equals(act)) {

		} else if ("".equals(act)) {

		} else if ("".equals(act)) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.ENCODE);
		doGet(request, response);
	}

}
