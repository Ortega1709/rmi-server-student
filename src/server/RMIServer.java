package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

    public static void main(String[] args) {
        try {
            StudentServer studentObject = new StudentServer();
            LocateRegistry.createRegistry(5099);
            String url = "rmi://localhost:5099/Student";
            Naming.rebind(url, studentObject);
            System.out.println("Server RMI is ready and waiting ...");
        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Error trying to connect to Student management object " + e);
        }
    }

}
