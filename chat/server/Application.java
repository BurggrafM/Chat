import java.io.*;
import java.net.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("To start the Server, type: 'java Application <port-number>'");
            System.exit(0);
        }
 
        int port = Integer.parseInt(args[0]); 
        ChatServer server = new ChatServer(port);
        server.execute();
    }   
}