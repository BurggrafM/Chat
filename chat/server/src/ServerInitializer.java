import java.io.Console;

public class ServerInitializer {
    public ServerConfiguration startInitialization() {
        final int port = requestPort();
        final String password = requestPassword();
        return new ServerConfiguration(port, password);
    }

    private int requestPort() {
        return Integer.parseInt(System.console().readLine("\nChoose a port: "));
    }

    private String requestPassword() {
        return System.console().readLine("\nChoose a password: ");
    }
}