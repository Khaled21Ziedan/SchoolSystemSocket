package Client;

import Server.Server;
import model.InstructorBean;
import model.StudentBean;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

    }

            DataOutputStream toServer;
            try (Socket socket = new Socket("localhost", 8000)) {

                toServer = new DataOutputStream(socket.getOutputStream());
            }
            System.out.println("Are you a Student or an Instructor");
            String Identity = sc.next();
            if (Objects.equals(Identity, "Student")) {
                System.out.println("Login or Register");
                Action = sc.next();
                if (Action.equals("Register")) {
                    System.out.println("Please enter your (firstname,lastname,username,email,password) student");

                    String firstname = sc.next();
                    String lastname = sc.next();
                    String username = sc.next();
                    String email = sc.next();
                    String password = sc.next();

                    StudentBean studentBean = new StudentBean(firstname, lastname, username, email, password);
                    System.out.println(studentBean.getFirstName());

                    toServer.writeObject(studentBean);

                } else {
                    System.out.println("Please enter your (username,password)");
                    String username = sc.next();
                    String password = sc.next();

                    StudentBean studentBean = new StudentBean(username, password);

                    toServer.writeObject(studentBean);

                }
            } else {
                System.out.println("Login or Register");
                Action = sc.next();
                if (Action.equals("Register")) {
                    System.out.println("Please enter your (username,firstname,lastname,email,password) instructor");

                    String username = sc.next();
                    String firstname = sc.next();
                    String lastname = sc.next();
                    String email = sc.next();
                    String password = sc.next();
                    String subject = sc.next();

                    InstructorBean instructorBean = new InstructorBean(firstname, lastname, username, email, password, subject);

                } else {
                    System.out.println("Please enter your (username,password)");

                    String username = sc.next();
                    String password = sc.next();
                    InstructorBean instructorBean = new InstructorBean(username, password);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
