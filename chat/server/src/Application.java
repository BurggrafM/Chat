import java.io.*;
import java.net.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        final ServerConfiguration configuration =
            new ServerInitializer().startInitialization();

        Server server = new Server(configuration);
        server.execute();
    }   
}