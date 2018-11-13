public class ServerConfiguration {
    private int port;
    private String password;

    public ServerConfiguration(int port, String password) {        
        this.port = port;
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }
}