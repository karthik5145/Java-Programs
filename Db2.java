import java.sql.*;
import java.util.Scanner;
class DAO{
    Connection con;
    DAO()throws ClassNotFoundException,SQLException
    {
       Class.forName("com.mysql.cj.jdbc.Driver");
       System.out.println("Loaded");
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gec", "root","");
    }
    void insert()throws SQLException
    {
        Statement stmt=con.createStatement();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your roll number: ");
        int eno = scanner.nextInt();

        System.out.print("Enter your name: ");
        String ename = scanner.nextLine();



        int r=stmt.executeUpdate("insert into emp values("+eno+",'"+ename+"')");
        if(r==1)
        System.out.println("inserted....");
        else
        System.out.println("insertion fail");
    }
    void updateName(int eno,String ename)throws SQLException
    {
        String cmd="update emp set ename=? where eno=?";
       PreparedStatement pstmt=con.prepareStatement(cmd);
       pstmt.setString(1,ename);
       pstmt.setInt(2,eno);
       int r=pstmt.executeUpdate();
       if(r==1)
        System.out.println("updated....");
        else
        System.out.println("updation fail");
    }
   void viewAll()throws SQLException
    {
        String cmd="select * from emp";
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(cmd);
        while(rs.next())
        {
            System.out.printf("%-5d %-30s\n",rs.getInt("eno"),rs.getString("ename"));
        }
    }
}
public class Db2
{
    public static void main(String[] args) throws ClassNotFoundException,SQLException
    {
        DAO dao=new DAO();
        dao.insert();
        dao.updateName(1,"sakar");
        dao.viewAll();
    }
}