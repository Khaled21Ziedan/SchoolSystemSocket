import Client.Client;
import Server.Server;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.run();
    }
}
