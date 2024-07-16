import java.util.*;
import java.io.*;
class Sgpa
{
 public static void main(String args[])
  {
    String sub[]={"a","b","c","d"};
    double credits[]={2,2,3,2,3};
    int gp=0;   
    double sum=0,total=0,sgpa;
    Scanner s=new Scanner(System.in);
    for(int i=0;i<sub.length;i++)
     {
	System.out.println("enter grage");
      char grade=s.next().charAt(0);
	switch(grade)
       {
	   case 'A':gp=10;
		break;
	   case 'B':gp=9;
           break;
  	   default:System.out.println("invallid");
      i--;
 	 }
if(gp==0)
{
  System.out.println("fail");
break;
}
else
{
total=total+credits[i]*gp;
sum=sum+credits[i];

}
sgpa=total/sum;


System.out.println(sgpa);
}
}
}




