class Example1
{
	public void fun1( int x ,int y ){
		System.out.println("In class Example1");
	}
}
class Example2 extends Example1
{
	public void fun1( int x , int y ){
		System.out.println("In class Example2");
	}
}
public class Overloading
{
	public static void main(String[] args) {
		Example2  e2=new Example2();
		e2.fun1(2,3);
	}
}