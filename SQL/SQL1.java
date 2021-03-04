import java.util.*;
import java.sql.*;
public class abc1
{
	public static void main(String[] args)throws Exception
	{
		int choice;
		int roll;
		String name;


        String driver = "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/cs";
		String username="root";
		String password="pass1234";
               
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,username,password);
		Statement st=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("\n1.Create table\n2.Insert data\n3.View data\n4.Exit");
			System.out.print("enter the choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				st.executeUpdate("create table student(roll int(10),name varchar(30));");
				break;
			case 2:
				System.out.print("enter roll");
				roll=sc.nextInt();
				sc.nextLine();
				System.out.println("enter the name");
				name=sc.nextLine();
				st.executeUpdate("insert into student values("+roll+",'"+name+"');");
				st=conn.createStatement();
				break;
			case 3:
				System.out.println("roll\t\tname");
				ResultSet rs = st.executeQuery("select * from student;");
				while(rs.next())
				{
					roll=rs.getInt("roll");
					name=rs.getString("name");
					System.out.println(roll+"\t\t"+name);
				}
				break;
			case 4:
				st.close();
				conn.close();
				System.exit(0);
			}
		}

}
}
	


			
		
