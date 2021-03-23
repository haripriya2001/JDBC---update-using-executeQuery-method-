package com.priyasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp11 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			st=con.createStatement();
			rs=st.executeQuery("update emp1 set ESAL=ESAL+500 where ESAL<10000");
			int rowCount=st.getUpdateCount();
			System.out.println("Row Count:"+rowCount);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
		try{
			rs.close();
			st.close();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}

	}

}
