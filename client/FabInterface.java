

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FabInterface extends Remote{
    public ObjectInterface newObject() throws RemoteException ;}
