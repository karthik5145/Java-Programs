class One
{
    static int count;
    int a,b;
    static{
        count=0;
    }
    
}
public class Second
{
    public static void main(String[] args)
    {
        One o1=new One();
        o1.a=10;
        o1.b=20;
        One o2=new One();
        o2.a=30;
        o2.b=40;
        System.out.println("Obj 1 initialization");
        System.out.println(o1.a);
        System.out.println(o1.b);

        System.out.println("Obj 2 Initialization");
        System.out.println(o2.a);
        System.out.println(o2.b);
    }
}