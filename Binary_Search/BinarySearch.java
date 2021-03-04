import java.util.Scanner;
class Binary
{
	public int  list[]={1,2,3,4,5,9,18,44,60} ;
	public int high , low , mid ;
	/*public void get_data(){

	}*/
	public void divide(int n ,int h , int l ){
		mid=(l+h)/2;
		if(n==list[mid]){
			System.out.println("element at postion "+mid);
			System.exit(0);
		}
		else if(n<list[mid])
			divide(n,l,mid-1);
		else
			divide(n,mid+1,h);
	}
}
public class BinarySearch
{
	public static void main(String[] args){
		int n;
		Binary b=new Binary();
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the element: ");
		n=in.nextInt();
		b.divide(n,0,8);
	}
}