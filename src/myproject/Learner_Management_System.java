package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Learner_Management_System {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/lms2";
		String uname="root";
		String password="Oneplusnord2@";
		
		Connection obj =DriverManager.getConnection(url,uname,password);
		
		Statement st= obj.createStatement();
		
		ResultSet rs= null;
		
		Scanner sc= new Scanner(System.in);
		int ch;
		
		do
		{
		System.out.println("___________________****----****____________________________");
		System.out.println("1. Create Learner table");
		System.out.println("2. Insert Data ");
		System.out.println("3. Display Records ");
		System.out.println("4. Update Records");
		System.out.println("5. Delete Record");
		System.out.println("6. Search the Record ");
		System.out.println("7. Count Records ");
		System.out.println("8. Arrange records ASC/Desc");
		System.out.println("9. like keyword");
		System.out.println("10. exit");
		System.out.println("___________________****----****____________________________");
		
		System.out.println("enter your choice ...!");
		ch=sc.nextInt();
		
		int lid, lage;
		String lname;
		String lcity;
		
		
		String sql;
		
		
		switch(ch)
		{
		case 1: //create table 
			System.out.println("___________________****----****____________________________");
			
			sql = "create table Learner(lid int, lname varchar(20), lcity varchar(20), lage int);";
			st.execute(sql);
			System.out.println("Learner Table Created Successfully !!");
			
			System.out.println("___________________****----****____________________________");
			
			break;
			
		case 2: //insert
			System.out.println("___________________****----****____________________________");
			
			System.out.println("enter the Learner id :");
			lid=sc.nextInt();
			
			System.out.println("enter the Learner name :");
			lname=sc.next();
			
			System.out.println("enter the Learner city :");
			lcity =sc.next();
			
			System.out.println("enter the Learner age :");
			lage=sc.nextInt();
			
			sql="insert into learner values("+lid+",'"+lname+"','"+lcity+"',"+lage+")";
			st.executeUpdate(sql);
			System.out.println("Records inserted Successfully !!");
			
			System.out.println("___________________****----****____________________________");
			
			break;
			
		case 3: //display
			
			System.out.println("___________________****----****____________________________");
			
			sql="select * from learner";
			rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println("__________________________________________________________");
				
				System.out.println("Learner id : "+rs.getInt(1));
				System.out.println("Learner name : "+rs.getString(2));
				System.out.println("Learner city : "+rs.getString(3));
				System.out.println("Learner age : "+rs.getInt(4));
				
				System.out.println("__________________________________________________________");
				
			}
			
			System.out.println("___________________****----****____________________________");
			
			break;
			
		case 4://update 
			System.out.println("___________________****----****____________________________");
			
			System.out.println("Enter the id whose data you wanna update !");
			lid=sc.nextInt();
			
			System.out.println("enter the new name !");
			lname=sc.next();
			
			System.out.println("enter the new city !");
			lcity =sc.next();
			
			System.out.println("enter the new age !");
			lage =sc.nextInt();
			
			sql="update learner set lname='"+lname+"', lcity='"+lcity+"', lage="+lage+" where lid ="+lid+"";
			st.executeUpdate(sql);
			
			System.out.println("Data updated successfully !");
			
			System.out.println("___________________****----****____________________________");
			
			
			break;
		
		case 5: //delete
			
			System.out.println("___________________****----****____________________________");
			
			System.out.println("Enter the Learner id whose data you wanna delete !");
			lid=sc.nextInt();
			
			sql="delete from learner where lid="+lid+"";
			st.executeUpdate(sql);
			
			System.out.println("Learner data deleted successfully !!");
			
			System.out.println("___________________****----****____________________________");
			
			break;
			
		case 6: //search 
			
			System.out.println("___________________****----****____________________________");
			
			System.out.println("enter the Learner id whose data you wanna search !");
			lid=sc.nextInt();
			
			sql="select * from learner where lid="+lid+"";
			rs = st.executeQuery(sql);
			if(rs.next())
			{
				System.out.println("Data is present in the database !");
				
				System.out.println("__________________________________________________________");
				
				System.out.println("Learner id : "+rs.getInt(1));
				System.out.println("Learner name : "+rs.getString(2));
				System.out.println("Learner city : "+rs.getString(3));
				System.out.println("Learner age : "+rs.getInt(4));
				
				System.out.println("__________________________________________________________");
				
			}
			else 
			{
				System.out.println("Data is not present in the database !");
			}
			
			System.out.println("___________________****----****____________________________");
			
			break;
		
			
		case 7: //count 
			
			System.out.println("___________________****----****____________________________");
			
			sql ="select count(*) from learner";
			rs=st.executeQuery(sql);
			rs.next();
			System.out.println("the total records are : "+rs.getInt(1));
			System.out.println("___________________****----****____________________________");
			
			break;
			
		case 8://desc
			
			System.out.println("___________________****----****____________________________");
			
			sql = "select * from learner order by lid desc";
			rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println("__________________________________________________________");
				
				System.out.println("Learner id : "+rs.getInt(1));
				System.out.println("Learner name : "+rs.getString(2));
				System.out.println("Learner city : "+rs.getString(3));
				System.out.println("Learner age : "+rs.getInt(4));
				
				System.out.println("__________________________________________________________");
				
			}
			
			System.out.println("___________________****----****____________________________");
			
			break;
			
		case 9: //like 
			
			System.out.println("___________________****----****____________________________");
			
			sql="select * from learner where lname like 'j%'";
			rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println("__________________________________________________________");
				
				System.out.println("Learner id : "+rs.getInt(1));
				System.out.println("Learner name : "+rs.getString(2));
				System.out.println("Learner city : "+rs.getString(3));
				System.out.println("Learner age : "+rs.getInt(4));
				
				System.out.println("__________________________________________________________");
				
			}
			
			System.out.println("___________________****----****____________________________");
			
			
			break;
			
		case 10:
			
			System.exit(0);
			
			break;
		}
		
		}
		while(ch!=11);
		
		st.close();
		obj.close();
		

	}

}
