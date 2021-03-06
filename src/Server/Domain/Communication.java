package Server.Domain;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.sql.Date;
import java.util.concurrent.ExecutorService;

import Functionality.Property;
import Functionality.PropertyFee;
import Functionality.SummaryReport;
import Functionality.User;

public class Communication{
    private ServerSocket serverSocket;
    private Socket aSocket;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;
    private ExecutorService pool;

    public Communication(Socket socket) throws IOException{
        this.aSocket = socket;
        socketOut = new ObjectOutputStream(aSocket.getOutputStream());
        socketIn = new ObjectInputStream(aSocket.getInputStream());
    }

    public void sendString(String s) throws IOException{
        socketOut.reset();
        socketOut.writeObject(s);
        socketOut.flush();
    }

    public String getString() throws ClassNotFoundException, IOException{
        String s = (String) socketIn.readObject();
        return s;
    }
    
    public Date getDate() throws ClassNotFoundException, IOException{
    	Date d = (Date) socketIn.readObject();
    	return d;
    }
    
    public Property getProperty() throws ClassNotFoundException, IOException{
    	Property property = (Property) socketIn.readObject();
    	return property;
    }
    
    public void sendProperty(Property property) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(property);
    	socketOut.flush();
    }
    
    public void sendProperties(ArrayList<Property> properties) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(properties);
    	socketOut.flush();
    }
    
    public PropertyFee getPropertyFee() throws ClassNotFoundException, IOException{
    	PropertyFee fee = (PropertyFee) socketIn.readObject();
    	return fee;
    }
    
    public void sendPropertyFee(PropertyFee fee) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(fee);
    	socketOut.flush();
    }
    
    public User getUser() throws ClassNotFoundException, IOException{
    	User user = (User) socketIn.readObject();
    	return user;
    }
    
    public void sendUser(User user) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(user);
    	socketOut.flush();
    }
    
    public void sendUsers(ArrayList<User> users) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(users);
    	socketOut.flush();
    }
    
    public void sendReport(SummaryReport report) throws IOException{
    	socketOut.reset();
    	socketOut.writeObject(report);
    	socketOut.flush();
    }
    
}