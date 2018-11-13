import java.io.*;
import java.net.*;
import java.util.*;

public class Server {    
    private int port;
    private Set<String> userNames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();
    private String password;
 
    public Server(ServerConfiguration configuration) {
        this.port = configuration.getPort();
    }
 
    public void execute() {
        Console console = System.console();
        password = console.readLine("\nChoose a password: ");
        System.out.println("Chat Server successfully secured!");

        try (ServerSocket serverSocket = new ServerSocket(port)) { 
            System.out.println("Chat Server is listening for clients to connect on port " + port); 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");
 
                UserThread newUser = new UserThread(socket, this);
                userThreads.add(newUser);
                newUser.start(); 
            } 
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    } 
 
    void broadcast(String message, UserThread excludeUser) {
        for (UserThread userThread : userThreads) {
            if (userThread != excludeUser) {
                userThread.sendMessage(message);
            }
        }
    }
 
    void addUserName(String userName) {
        userNames.add(userName);
    }

    void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }
 
    Set<String> getUserNames() {
        return userNames;
    }

    boolean hasUsers() {
        return !userNames.isEmpty();
    }
}