
class Db1

{
    public static void main(String[] args) throws ClassNotFoundException
    {
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("driver loaded");
    }

}