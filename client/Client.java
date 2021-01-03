

import java.rmi.*;
import java.rmi.registry.*;
import java.sql.SQLOutput;

public class Client {
    public Client (String[] args) {

        if(args.length != 4)
        {
            System.out.println("Utilisation : java ReverseClient n1 n2 n3 n4");
            System.exit(0);
        }
        try{
            if(System.getSecurityManager() == null)
                System.setSecurityManager(new RMISecurityManager());
            Registry reg = LocateRegistry.getRegistry("localhost",1099);
            FabInterface fabrique = (FabInterface) reg.lookup("Fabrique");

            //instanciation des matrices:
		    Matrix m1 = new Matrix(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		    Matrix m2 = new Matrix(Integer.parseInt(args[2]),Integer.parseInt(args[3]));

	    //generation de matrice
		m1.generateMatrix();
		m2.generateMatrix();
		System.out.println("Matrice 1 : ");
		m1.viewMatrix();
		System.out.println();
		
		System.out.println("Matrice 2 : ");
		m2.viewMatrix();
		System.out.println();

            //decomposition:
		    Matrix tab1[] = Matrix.decomposer(m1);
		    Matrix tab2[] = Matrix.decomposer(m2);




            ObjectInterface obj1;
            obj1= (ObjectInterface)fabrique.newObject();
            Matrix result1 = obj1.matrixBlocResult(tab1[0], tab2[0], tab1[1], tab2[2]);

            ObjectInterface obj2;
            obj2= (ObjectInterface)fabrique.newObject();
            Matrix result2 = obj2.matrixBlocResult(tab1[0], tab2[1], tab1[1], tab2[3]);

            ObjectInterface obj3;
            obj3= (ObjectInterface)fabrique.newObject();
            Matrix result3 = obj3.matrixBlocResult(tab1[2], tab2[0], tab1[3], tab2[2]);

            ObjectInterface obj4;
            obj4= (ObjectInterface)fabrique.newObject();
            Matrix result4 = obj4.matrixBlocResult(tab1[2], tab2[1], tab1[3], tab2[3]);

		
            Matrix finalResult = Matrix.composer(result1, result2, result3, result4);
	    System.out.println("Matrice resultat : ");
            finalResult.viewMatrix();
        }
        catch (Exception e) {
            System.out.println ("Erreur d'acces a l'objet distant.");
            System.out.println (e.toString());
		e.printStackTrace();
        }
    }
}
