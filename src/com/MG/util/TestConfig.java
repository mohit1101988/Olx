package com.MG.util;



public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "lalitmtitesting@gmail.com";
	public static String password = "mediatek";
	public static String[] to ={"mohit1101988@gmail.com","seleniumcoaching@gmail.com"};
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="c:\\Mohit\\Error_screen.jpg";
	public static String attachmentName="Error.jpeg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "password";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/sakila";
	
	
	
	
	
	
	
	
	
}
