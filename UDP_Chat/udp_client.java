import java.io.*;
import java.net.*;
public class udp_client
{
public static void main(String args[])
{
DatagramSocket sock=null;
int port=7777;
String s;
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
try
{
sock=new DatagramSocket();
InetAddress host=InetAddress.getByName("localhost");
while(true)
{
echo("enter msg to send");
s=(String)in.readLine();
byte[] b=s.getBytes();
DatagramPacket dp=new DatagramPacket(b,b.length,host,port);
sock.send(dp);
byte[]buffer=new byte[65536];
DatagramPacket reply=new DatagramPacket(buffer,buffer.length);
sock.receive(reply);
byte[] data=reply.getData();
s=new String(data,reply.getLength());
echo(reply.getAddress().getHostAddress()+":"+reply.getPort()+"-"+s);
}
}
catch(IOException e)
{
System.out.println("IOException"+e);
}
}
public static void main(String msg)
{
System.out.println(msg);
}
}