


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjectInterface extends Remote
{
    Matrix matrixBlocResult(Matrix m1, Matrix m2, Matrix m3, Matrix m4) throws RemoteException;
}