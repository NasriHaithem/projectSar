

import java.rmi.*;
import java.rmi.server.*;
public class Object extends UnicastRemoteObject implements ObjectInterface
{
    public Object() throws RemoteException
    {
        super();
    }
    public Matrix matrixBlocResult(Matrix m1, Matrix m2, Matrix m3, Matrix m4) throws RemoteException
    {
        Matrix mult1 = Matrix.multMatrix(m1,m2);
        Matrix mult2 = Matrix.multMatrix(m3,m4);
        return Matrix.addition(mult1,mult2);
    }
}
