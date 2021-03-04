import java.util.*;
import java.sql.*;
public class abc2
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
			System.out.println("\n1. Update data \n2.Delete\n3.orderBy\n4.Exit\n");
			System.out.print("enter the choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				System.out.println("update data");
				System.out.println("Enter rollno to be updated");
				roll=sc.nextInt();
				System.out.println("name=");
				name=sc.next();
				st.executeUpdate("update student set name='"+name+"'where roll='"+roll+"'");
				break;
			case 2:
				System.out.print("enter rollno to be deleted");
				roll=sc.nextInt();
				st.executeUpdate("delete from student where roll='"+roll+"'");
				break;
			case 3:
				System.out.println("Changing order");
				ResultSet rs = st.executeQuery("select * from student order by name");
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
	


			
		
