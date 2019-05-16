package com.kitri.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.Product;
import com.kitri.dto.ProductCategory;
import com.sun.media.sound.DirectAudioDeviceProvider;

public class ProductDAO {
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		// 1.jdbc
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracl:thin:@localhost:1521:orcl", "kitri", "kitri");
			String sql = "select cate_no, cate_name, prod_no, prod_name, prod_price, prod_detail\r\n"
					+ "from product p JOIN product_category pc ON p.prod_cate = pc.cate_no \r\n"
					+ "order by cate_no";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(sql);
			while (rs.next()) {
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				String prod_detail = rs.getString("prod_detail");

				String cate_no = rs.getString("cate_no");
				String cate_name = rs.getString("cate_name");

				ProductCategory pc = new ProductCategory(cate_no, cate_name);
				Product p = new Product(prod_no, prod_name, prod_price, prod_detail, pc);
				list.add(p);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	public Product selectByNo(String no) {
		Product p=null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		// 1.jdbc
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracl:thin:@localhost:1521:orcl", "kitri", "kitri");
			String sql = "select cate_no, cate_name, prod_no, prod_name, prod_price, prod_detail\r\n"
					+ "from product p JOIN product_category pc ON p.prod_cate = pc.cate_no where prod_no = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			rs.next();
			String prod_no = rs.getString("prod_no");
			String prod_name = rs.getString("prod_name");
			int prod_price = rs.getInt("prod_price");
			String prod_detail = rs.getString("prod_detail");

			String cate_no = rs.getString("cate_no");
			String cate_name = rs.getString("cate_name");

			ProductCategory pc = new ProductCategory(cate_no, cate_name);
			p = new Product(prod_no, prod_name, prod_price, prod_detail, pc);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
}
