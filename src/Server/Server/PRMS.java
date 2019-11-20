package Server.Server;
import Server.Database.Database;
import Server.Domain.Customer;
import Server.Domain.Landlord;
import Server.Domain.Manager;
import Server.Domain.Property;
import Server.Domain.RegisteredRenter;
import Server.Domain.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PRMS{
    ServerSocket serverSocket;

    public PRMS() throws IOException{
        serverSocket = new ServerSocket(9090);
    }

    public void start(){
        ExecutorService es = Executors.newFixedThreadPool(5);
        Database db = new Database();
//        Property p = new Property("House", 4, 3, true, "NW", "Active", 100);
//        db.addProperty(p);
//        Property temp = new Property(802130, "Condo", 3, 3, true, "NW", "Active", 100);
//        db.removeProperty(temp);
//        System.out.println(db.getProperty(451777).getType());
//        User u = new RegisteredRenter("youup99", "Youup", "Kim", "youup99@gmail.com", "990926");
//        User u1 = new Landlord("mulgae", "Minji", "Kim", "test@gmail.com", "123456", db.getProperties());
//        User u2 = new Manager("manager123", "Manager", "One", "manager@gmail.com", "123");
//        db.addUser(u);
//        db.addUser(u1);
//        db.addUser(u2);
//        System.out.println(db.getUser("youup99").getEmail());
//        ArrayList<User> u = db.getUsers();
//        for(User user : u) {
//        	System.out.println(user.getUserName());
//        }
        db.changeState("Rented", 451777);

        try{
            while(true){
                synchronized(db){
                    Socket aSocket = serverSocket.accept();
                    Customer customer = new Customer(aSocket, db);
                    es.execute(customer);
                }
            }
        } catch(IOException e){
            System.err.println("PRMS Crashed");
            e.printStackTrace();
        }
    }
}