import java.util.*;
import java.sql.*;
import java.util.Scanner;
class Dao
{  
    Scanner scan=new Scanner(System.in);
    Connection con;
    Dao()throws ClassNotFoundException,SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","");
    }
    void insert()throws Exception
    {
        PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?)");
        while(true)
        {
            Scanner scan=new Scanner(System.in);
            System.out.println("Ennter student Roll no:\t");
            int roll_no=scan.nextInt();
            System.out.println("Enter the name of the student:\t");
            String name=scan.next();
            System.out.println("Enter the Age:\t");
            int age=scan.nextInt();
            try{
                pstmt.setInt(1,roll_no);
                pstmt.setString(2, name);
                pstmt.setInt(3,age);
                int r=pstmt.executeUpdate();
                System.out.println("%d row inserted"+r);
                System.out.println("do you want inster again then choose 1 or 0:\t");
                int opt=scan.nextInt();
                if (opt==0)
                  break;
            }
            catch(Exception e)
            {
                throw new Exception("roll no is unqique");
            }  

        }
    }
    void update()throws Exception
    {
     try
     {
            Scanner scan=new Scanner(System.in);
            System.out.println("Enter the new name :");
            String name=scan.next();
            System.out.println("Enter roll number:");
            int roll_no=scan.nextInt();
            String cmd="update student set name=? where roll_no=?";
            PreparedStatement pstmt=con.prepareStatement(cmd);
            pstmt.setString(1,name);
            pstmt.setInt(2,roll_no);
            int r=pstmt.executeUpdate();
            if(r==1)
            {
            System.out.println("updated....");
            }   
            else
            {
            System.out.println("updation failed...");
            } 
    }
    catch(Exception e){
        throw new Exception("Roll number doesn't exist ");
    }

    }
    void view()throws Exception
    {
        String sql="select * from student";
        Statement stmt = con.createStatement();
        ResultSet rst=stmt.executeQuery(sql);
        while(rst.next())
        {
            System.out.println("Roll No:"+rst.getInt("roll_no")+"\tname:"+rst.getString("name")+"\tAge:"+rst.getInt("age"));
        }
        rst.close();

    }
    void delete()throws Exception
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the roll no for delete from db:");
        int roll_no=scan.nextInt();
        String cmd="delete from student where roll_no=?";
        PreparedStatement pstmt=con.prepareStatement(cmd);
        pstmt.setInt(1,roll_no);
        int r=pstmt.executeUpdate();
        if(r==1)
        {
           System.out.println("deleted succefully");
        }   
        else
        {
           System.out.println("deletion fail...");
        }  

    }
}
public class jdbcdoa{
    public static void main(String[] args) throws ClassNotFoundException,SQLException
    {
        Scanner scan=new Scanner(System.in);
        Dao d1=new Dao();
        while (true)
         {
            System.out.println("Enter 1.for insertion 2.for update 3.view data 4.exit");
            int s=scan.nextInt();
            try{
                if (s==1)
                {
                    d1.insert();
                }
                else if(s==2)
                {
                    d1.update();
                }
                else if(s==3)
                {
                    d1.view();
                }
                else if(s==4)
                {
                    d1.delete();
                }
                else
                {
                    System.out.println("Enter correct option from above options");
                } 
            }     
            
            catch(Exception e)   
            {
                System.out.println("Error: " + e.getMessage());
            }
        }    
    }
    
}