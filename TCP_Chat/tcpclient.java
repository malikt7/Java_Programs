
import java.io.*;
import java.net.*;
class tcpclient
{
public static void main(String args[])throws Exception
{
String sent;
String modifysent;

BufferedReader infromuser=new BufferedReader(new InputStreamReader(System.in));

Socket clientSocket=new Socket("localhost",6789);

DataOutputStream outtoserver=new DataOutputStream(clientSocket.getOutputStream());

BufferedReader infromserver=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

sent=infromuser.readLine();

outtoserver.writeBytes(sent+"\n");

modifysent=infromserver.readLine();

System.out.println("from server"+modifysent);

clientSocket.close();
}

} 
