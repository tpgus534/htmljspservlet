package com.kitri.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ListModel;

public class SelectTest {

	public SelectTest() {
//		try {
//			Class.forName("jdbc.oracle.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

	public Connection makeConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		return con;
	}

	public List<MemberDto> memberList(String searchName) {
		List<MemberDto> list = new ArrayList<MemberDto>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		con = makeConnection();
		try {
			String sql = "select * from jdbctest\n";
			if (searchName != null) {
				sql += "where name = '" + searchName + "'";
			}
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberDto md = new MemberDto();
				md.setNo(rs.getInt(1));
				md.setName(rs.getString("name"));
				md.setId(rs.getString(3));
				md.setJoindate(rs.getString(4));
				list.add(md);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public void memberSearch(int no) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		con = makeConnection();
		try {
			String sql = "select no, id, name, ";
			sql += "decode(to_char(joindate,'YY.MM.DD'), to_char(sysdate,'YY.MM.DD'), to_char(joindate,'hh24:mi:ss'), to_char(joindate,'YY.MM.DD')) ";
			sql += "from jdbctest\n";
			sql += "where no = '" + no + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			MemberDto md = null;
			if (rs.next()) {
				md = new MemberDto();
				md.setNo(rs.getInt(1));
				md.setName(rs.getString("name"));
				md.setId(rs.getString(3));
				md.setJoindate(rs.getString(4));
			}
			
			if (md == null) {
				System.out.println("회원번호가 " + no + " 인 회원은 존재하지 않습니다.");
			} else {
//				Date date = new Date();
//				Format f1 = new SimpleDateFormat("yy.MM.dd");
//				String da1 = f1.format(date);
//				String a1 = md.getJoindate().substring(0, 8);
//				String a2 = md.getJoindate().substring(9,17);
				String str = "이름 : "+ md.getName()+"\nid : "+ md.getId()+"\n가입일 : "+ md.getJoindate();
//				
//				if (a1.equals(da1)) {
//					str += a2 + "(오늘)";
//				} else {
//					str += a1 + "(오늘x)";
//				}
				System.out.println(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		List<MemberDto> list = st.memberList("홍길동");
		for (MemberDto memberDto:list) {
			System.out.println(memberDto);
		}
		
		int no = 201;
		System.out.println("회원번호가 "+no+"인 회원 검색!!!!");
		st.memberSearch(no);

	}
}
