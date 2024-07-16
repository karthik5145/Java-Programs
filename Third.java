class Base
{
    int a;
    Base()
    {
 System.out.println("Base const")
}
    }
}
class Child extends Base
{
    int b;
    System.out.println("child const");
}

class Third
{
    public static void main(String[] args)
    {
        Child c1=new Child();
         System.out.println(c1.a);
    }
}
