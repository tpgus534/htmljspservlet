package com.kitri.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipcodeDto;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao;

	static {
		memberDao = new MemberDaoImpl();
	}

	private MemberDaoImpl() {

	}

	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
	public int idCheck(String id) {
		int cnt = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(id);
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(id) \n");
			sql.append("from member \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			cnt = 1;
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		System.out.println(cnt);
		return cnt;
	}

	@Override
	public List<ZipcodeDto> zipSearch(String doro) {
		List<ZipcodeDto> list = new ArrayList<ZipcodeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(doro);
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select    new_post_code zipcode, sido_kor sido, gugun_kor gugun,  \n");
			sql.append("      nvl(upmyon_kor, ' ') upmyon, doro_kor doro,  \n");
			sql.append("      case when building_refer_number != '0' \n");
			sql.append("         then building_origin_number||'-'||building_refer_number  \n");
			sql.append("         else trim(to_char(building_origin_number, '99999')) \n");
			sql.append("      end building_number, sigugun_building_name \n");
			sql.append("from    postcode \n");
			sql.append("where    doro_kor like '%'||?||'%' \n");// "%" + doro + "%"
			sql.append("or sigugun_building_name like '%'||?||'%' \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, doro);
			pstmt.setString(2, doro);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ZipcodeDto zipDto = new ZipcodeDto();
				zipDto.setZipcode(rs.getString("zipcode"));
				zipDto.setDoro(rs.getString("doro"));
				zipDto.setGugun(rs.getString("gugun"));
				zipDto.setSido(rs.getString("sido"));
				zipDto.setSigugunBuildingName(rs.getString("sigugun_building_name"));
				zipDto.setUpmyon(rs.getString("upmyon"));
				zipDto.setBuildingNumber(rs.getString("building_number"));
				list.add(zipDto);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		int cnt=1;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer("");
			sql.append("insert all\n");
			sql.append("	into member (id, name, pass, emailid, emaildomain, joindate)\n");
			sql.append("	values(?,?,?,?,?, sysdate)\n");
			sql.append("	into member_detail (id, zipcode, address, address_detail, tel1, tel2, tel3)\n");
			sql.append("	values(?,?,?,?,?,?,?)\n");
			sql.append("select * from dual\n");

			int idx = 0;
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(++idx, memberDetailDto.getId());
			stmt.setString(++idx, memberDetailDto.getName());
			stmt.setString(++idx, memberDetailDto.getPass());
			stmt.setString(++idx, memberDetailDto.getEmailid());
			stmt.setString(++idx, memberDetailDto.getEmaildomain());
			stmt.setString(++idx, memberDetailDto.getId());
			stmt.setString(++idx, memberDetailDto.getZipcode());
			stmt.setString(++idx, memberDetailDto.getAddress());
			stmt.setString(++idx, memberDetailDto.getAddressDetail());
			stmt.setString(++idx, memberDetailDto.getTel1());
			stmt.setString(++idx, memberDetailDto.getTel2());
			stmt.setString(++idx, memberDetailDto.getTel3());

			cnt = stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				cnt=1;
				e.printStackTrace();
			}
		}
		return cnt;
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		MemberDto memberDto = null;
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select name, id, emailid, emaildomain, joindate \n");
			sql.append("from member \n");
			sql.append("where id = ? and pass = ? \n");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, map.get("id"));
			stmt.setString(2, map.get("userpwd"));
			System.out.println(map.get("id")+" "+ map.get("userpwd"));
			rs = stmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setName(rs.getString("name"));
				memberDto.setId(rs.getString("name"));
				memberDto.setEmailid(rs.getString("name"));
				memberDto.setEmaildomain(rs.getString("name"));
				memberDto.setJoindate(rs.getString("joindate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}

		return memberDto;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
