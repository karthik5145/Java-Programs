class HousePlam
{
    
    static String city;
    byte kn;
    short pr;
    int br1,br2;
    static
    {
        System.err.println("static block");
        city="vij";
    }

    {
        System.err.printf("instance block");
    }
    HousePlan()
    {
        System.err.println("constructor");
        kn=0;
        pr=0;
        br1=0;
        br2=0;
    }
    void plan()
    {
        System.out.println(" instance method thammudu");
    }
    static void fun()
    {
        System.out.println("static method");
    }
}
   
   public class One
    {
        public static void main(String[] args)
        {
            HousePlan o1=new HousePlan();
            System.out.println(o1.br1);
        }
    }
