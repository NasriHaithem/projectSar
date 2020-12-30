

import java.rmi.*;
import java.rmi.server.*;
public class FabInterfaceImp extends UnicastRemoteObject implements FabInterface{
    public FabInterfaceImp()throws RemoteException {};
    public ObjectInterface newObject() throws RemoteException {
        return new Object();}
}
