import java.io.*;
import java.net.*;
public class udp_server
{
public static void main(String args[])
{
DatagramSocket sock=null;
try
{
sock=new DatagramSocket(7777);
byte[]buffer=new byte[65536];
DatagramPacket incoming=new DatagramPacket(buffer,buffer.length);
echo("Sever socket created waiting for incoming data");
while(true)
{
sock.receive(incoming);
byte[] data=incoming.getData();
String s=new String(data.o.incoming.length());
client port_client message
echo(incoming.getAddress().getHostAddress()+":"+incoming.getPort()+"-"+s);
s="ok"+s;
DatagramPacket dp=new DatagramPacket(s.getBytes(),s.getBytes().length,incoming.getAddress(),incoming.getPort());
sock.send(dp);
}
}
public static void main(String msg)
{
System.out.println(msg)
}
}