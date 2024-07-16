abstract class One
{
    abstract void add(int q);
    void sum()
    { 
        int a;
        System.out.println("heloo");
    }
}

class Child extends One
{
 void add(int q)
 {
    System.out.println("hh");
 }


}
public class Abstract
{
public static void main(String[] args)
{
    One c1=new Child();/* dynamic binding*/
    c1.add(11);
    c1.sum(1);/*static binding*/
}

}
