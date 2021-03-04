import java.io.*;
import java.net.*;
class tcpserver
{
public static void main(String argv[])throws Exception
{
String clientsent;
String capsent;
ServerSocket welcomesocket=new ServerSocket(6789);
while(true)
{
Socket connectionSocket=welcomesocket.accept();

BufferedReader client=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));


DataOutputStream outtoclient=new DataOutputStream(connectionSocket.getOutputStream());

clientsent=client.readLine();

System.out.println("Received"+clientsent);

capsent=clientsent.toUpperCase()+"\n";

outtoclient.writeBytes(capsent);
}
}
}
