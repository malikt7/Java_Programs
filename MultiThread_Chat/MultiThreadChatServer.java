import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class MultiThreadChatServer {
  private static ServerSocket serverSocket = null;
  private static Socket clientSocket = null;
  private static final int maxClientsCount = 15;
  private static final clientThread[] threads = new clientThread[maxClientsCount];
  public static void main(String args[]) {
	
    if (args.length < 1) {
      System.out
          .println("\n"
              + "here is server started...");
    } else {
    }
    try {
      serverSocket = new ServerSocket(2222);
    } catch (IOException e) {
      System.out.println(e);
    }
    while (true) {
      try {
        clientSocket = serverSocket.accept();
        int i = 0;
        for (i = 0; i < maxClientsCount; i++) {
          if (threads[i] == null) {
            (threads[i] = new clientThread(clientSocket, threads)).start();
            break;
          }
        }
        if (i == maxClientsCount) {
          PrintStream os = new PrintStream(clientSocket.getOutputStream());
          os.println("Server too busy.. out of 15 clients try later");
          os.close();
          clientSocket.close();
        }
      } catch (IOException e) {
        System.out.println(e);
      }
    }
  }
}
class clientThread extends Thread {
  private DataInputStream is = null;
  private PrintStream os = null;
  private Socket clientSocket = null;
  private final clientThread[] threads;
  private int maxClientsCount;

  public clientThread(Socket clientSocket, clientThread[] threads) {
    this.clientSocket = clientSocket;
    this.threads = threads;
    maxClientsCount = threads.length;
  }
  public void run() {
    int maxClientsCount = this.maxClientsCount;
    clientThread[] threads = this.threads;
    try {
      is = new DataInputStream(clientSocket.getInputStream());
      os = new PrintStream(clientSocket.getOutputStream());
      os.println("your name::");
      String name = is.readLine().trim();
      os.println("hi" + name
          + " welcome to group.\n");
      for (int i = 0; i < maxClientsCount; i++) {
        if (threads[i] != null && threads[i] != this) {

	threads[i].os.println("member added " + name);
	
        }
      }
      while (true) {
        String line = is.readLine();
        if (line.startsWith("bye")) {
          break;
        }
        for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] != null) {
            threads[i].os.println(name +":"+ line);
          }
        }
      }
      for (int i = 0; i < maxClientsCount; i++) {
        if (threads[i] != null && threads[i] != this) {
          threads[i].os.println(" " + name
              + "left the group");
        }
      }
      for (int i = 0; i < maxClientsCount; i++) {
        if (threads[i] == this) {
          threads[i] = null;
        }
      }
      is.close();
      os.close();
      clientSocket.close();
    } catch (IOException e) {
    }
  }
}


