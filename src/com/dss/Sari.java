package com.dss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sari {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		
		//this file is about my first sibling Sari, her husband and children
		//storing names of each individual in Oracle database from the Java application with JDBC concept
		
		//step-1 loading the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Oracle Database Driver Loaded");
		System.out.println("-----------------------------------");

		//Step-2 connecting with the database through Connection interface and DriverManager.getConnection
		Connection cns = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","R@m123");
		System.out.println("Java Application Connected with Oracle Database");
		System.out.println("-----------------------------------");
		
		//Step-3 declaring/writing the queries
		//String q0 = "create table ONERAM.Sara(Name varchar2(40), Relation varchar2(40), SerialNumber number)";
		String q1 = "insert into ONERAM.Sara values('Saraswathi Bejjanki','Herself my sister',111)";
		String q2 = "insert into ONERAM.Sara values('Madhusudhan Sangareddypeta','Her husband',222)";
		String q3 = "insert into ONERAM.Sara values('Mahesh Kumar Sangareddypeta','Her first son',333)";
		String q4 = "insert into ONERAM.Sara values('Dinesh Kumar Sangareddypeta','Her second son',444)";
		String q5 = "insert into ONERAM.Sara values('Rishikesh Sangareddypeta','Her biological third son',555)";
		String q6 = "select * from ONERAM.Sara";
		
		//Step-4 executing the queries through statement object with predefined methods
		Statement st = cns.createStatement();
		
		//int a0 = st.executeUpdate(q0);
		int a1 = st.executeUpdate(q1);
		int a2 = st.executeUpdate(q2);
		int a3 = st.executeUpdate(q3);
		int a4 = st.executeUpdate(q4);
		int a5 = st.executeUpdate(q5);
		
		//executing selection query with executeQuery() to get ResultSet object
		ResultSet a6 = st.executeQuery(q6);
		
		while (a6.next()) {
			System.out.println(a6.getString(1)+" is "+a6.getString(2)+" and "+a6.getInt(3)+" number in talbe ");
		}
		
		cns.close();

	}

}
