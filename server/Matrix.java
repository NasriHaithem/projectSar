import java.io.Serializable;
import java.util.Random;

public class Matrix  implements Serializable{
    public int rowLength;
    public int colLength;
    public int[][] data = new int[100][100];

    public Matrix(int row, int col){
        try{
            if (row<101 && col<101 ){
                this.rowLength = row;
                this.colLength = col;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("row or col more than 100");
        }

    }

    public void generateMatrix(){
        int row = this.rowLength;
        int col = this.colLength;
        Random r = new Random();

        for (int i=0; i<row; i++){
            for(int j=0; j<col; j++){

                this.data[i][j] = r.nextInt(10);
            }
        }

    }
    public void viewMatrix(){
        int row = this.rowLength;
        int col = this.colLength;
        for (int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.format(" %d",this.data[i][j]);
            }
            System.out.println();
        }
    }
    static public Matrix multMatrix(Matrix m1, Matrix m2){
        Matrix c = new Matrix(m1.rowLength,m2.colLength);


        for(int i=0;i<m1.rowLength;i++){
            for(int j=0;j<m2.colLength;j++){
                c.data[i][j]=0;
                for(int k=0;k<m1.colLength;k++){
                    c.data[i][j]+=m1.data[i][k]*m2.data[k][j];
                }
            }
        }
        return c;
    }
    static public Matrix addition(Matrix m1, Matrix m2){
        Matrix c = new Matrix(m1.rowLength,m2.colLength);


        for(int i=0;i<m1.rowLength;i++){
            for(int j=0;j<m2.colLength;j++){
                c.data[i][j]=m1.data[i][j]+m2.data[i][j];
            }
        }
        return c;
    }
    static public Matrix[] decomposer(Matrix m) {
        int x=m.rowLength/2;
        int y=m.colLength/2;
        int oddOrEvenRows = m.rowLength%2;
        int oddOrEvenCols = m.colLength%2;
        Matrix m1=new Matrix(x,y);//3 2
        Matrix m2=new Matrix(x,m.colLength-y);//3 3
        Matrix m3=new Matrix(m.rowLength-x,y);//3 2
        Matrix m4=new Matrix(m.rowLength-x,m.colLength-y);//3 3

        for(int i=0;i<m1.rowLength;i++){
            for(int j=0;j<m1.colLength;j++) {
                m1.data[i][j] = m.data[i][j];
            }
        }
        for(int i=0;i<m2.rowLength;i++){
            for(int j=0;j<m.colLength;j++) {

                m2.data[i][j] = m.data[i][j+m2.colLength-oddOrEvenCols];
            }
        }
        for(int i=0;i<m3.rowLength;i++){
            for(int j=0;j<m3.colLength;j++) {
                m3.data[i][j] = m.data[i+m3.rowLength-oddOrEvenRows][j];
            }
        }
        for(int i=0;i<m4.rowLength;i++){
            for(int j=0;j<m4.colLength;j++) {
                m4.data[i][j] = m.data[i+m4.rowLength-oddOrEvenRows][j+m4.colLength-oddOrEvenCols];
            }
        }

        Matrix matTab[] = {m1,m2,m3,m4};
        return matTab;

    }
    static public Matrix composer(Matrix m1,Matrix m2,Matrix m3,Matrix m4) {
        Matrix res =new Matrix(m1.rowLength+m3.rowLength, m1.colLength+m2.colLength);

        res.generateMatrix();
        for(int i=0;i<m1.rowLength;i++) {
            for(int j=0;j<m1.colLength;j++) {
                res.data[i][j] = m1.data[i][j];
            }
        }
        for(int i=0;i<m2.rowLength;i++) {
            for(int j=0;j<m2.colLength;j++) {
                res.data[i][j+m1.colLength] = m2.data[i][j];
            }
        }
        for(int i=0;i<m3.rowLength;i++) {
            for(int j=0;j<m3.colLength;j++) {
                res.data[i+m1.rowLength][j] = m3.data[i][j];
            }
        }
        for(int i=0;i<m4.rowLength;i++) {
            for(int j=0;j<m4.colLength;j++) {
                res.data[i+m1.rowLength][j+m1.colLength] = m4.data[i][j];
            }
        }

        return res;
    }
}

