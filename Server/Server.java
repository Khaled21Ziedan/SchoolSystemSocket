package Server;

import Client.Client;
import model.StudentBean;

import java.io.*;
import java.net.*;

public class Server {
    private ObjectOutputStream outputToFile;
    private ObjectInputStream inputFromClient;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

    }

    public Server(){
        try {
            while (true) {
                ServerSocket serverSocket = new ServerSocket(8000);
                Socket socket = serverSocket.accept();

            System.out.println("im here");
            inputFromClient =
                    new ObjectInputStream(socket.getInputStream());
            Object object = inputFromClient.readObject();
            StudentBean studentBean = (StudentBean) object;
            System.out.println(studentBean.getFirstName());
        }}catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
