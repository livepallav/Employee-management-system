package com.employee.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.employee.bean.Employee;
import com.employee.util.MyConn;

public class DAO {
	public static String insertEmp(Employee emp) {
		String st="";
		Connection conn;
		try {
			conn=MyConn.myConnection();
			String query="INSERT INTO emp VALUES(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getDept());
			ps.setInt(4, emp.getSal());
			int updatedRows=ps.executeUpdate();
			st="Total "+updatedRows+" rows updated";
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return st;
	}
//	public static String showEmp() {
//	
//	}
	public static String deleteEmp(Employee emp) {
		String st="";
		Connection conn;
		try {
			conn=MyConn.myConnection();
			String query="DELETE FROM emp WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, emp.getId());
//			ps.setString(2, emp.getName());
//			ps.setString(3, emp.getDept());
//			ps.setInt(4, emp.getSal());
			int updatedRows=ps.executeUpdate();
			st="Total "+updatedRows+" rows updated";
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return st;
	}
}

