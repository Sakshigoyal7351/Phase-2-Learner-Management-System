package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC1 {

	public static void main(String[] args) throws Exception {
		
		
		//load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url ="jdbc:mysql://localhost:3306/myproject1";
		String uname="root";
		String password="Oneplusnord2@";
		
		//create a connection 
		
		Connection obj = DriverManager.getConnection(url,uname,password);
		
		//create statement
		
		Statement st = obj.createStatement();
		
		
		//write the query
		String sql;
		
//		sql="create table student(sid int, sname varchar(20), degree varchar(20))";
//		
//		st.execute(sql);
//		
//		System.out.println("Table created successfully !!");
		
		
		
//		sql ="insert into student values(1,'john','computers')";
//		st.executeUpdate(sql);
//		
//		System.out.println("Data inserted successfully !!");
		
//		
//		Scanner sc =new Scanner(System.in);
//		
//		System.out.println("enter the id");
//		int id = sc.nextInt();
//		
//		
//		System.out.println("enter the name :");
//		String name =sc.next();
//		
//		System.out.println("enter the degree : ");
//		String degree =sc.next();
//		
//		
//		sql ="insert into student values("+id+",'"+name+"','"+degree+"')";
//		
//		st.executeUpdate(sql);
//		
//		System.out.println("data inserted successfully !!");
		
		
		ResultSet rs=null;
		
		sql="select *from student";
		
		rs=st.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println("id :"+rs.getInt(1));
			System.out.println("name :"+rs.getString(2));
			System.out.println("degree is :"+rs.getString(3));
		}
			
		
		
		
		
		//close the connection 
		
		st.close();
		obj.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
