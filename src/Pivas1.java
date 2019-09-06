import java.math.*;
class neo{
    int rows;
    int column;
    int [][]matrix;
    neo(int r, int c){
        rows = r;
        column = c;
        matrix = new int[rows][column];
        for(int i= 0; i<rows;i++){
            for(int j=0; j<column;j++){
                matrix[i][j]=1+(int)(Math.random()*10);
            }
        }
        for (int i=0; i<rows; i++) {
            for (int j=0; j<column; j++) {
                System.out.print(matrix[i][j]+"    ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //  int[][] matrix = new int[rows][column];

    void izmenenie (int stoki,int stolbi){
        // int [][]m = new int[rows][column];
        int [][]m1 = new int[rows-1][column-1];
//		for (int i=0; i<rows; i++) {
//			for (int j=0; j<n; j++) {
//				m[i][j] = x.nextDouble();
//			}
//		}
        int deli, delj;
        deli = stoki;
        delj = stolbi;
        for (int i=0, ln=0; ln<rows-1;) {
            if (i!=deli-1) {
                for (int j=0, cn=0; cn<column-1; j++, cn++) {
                    if (j==delj-1) j++;
                    m1[ln][cn]=matrix[i][j];
                }
                i++;
                ln++;
            } else i++;
        }
        matrix=m1;
        for (int i=0; i<rows-1; i++) {
            for (int j=0; j<column-1; j++) {
                System.out.print(matrix[i][j]+"    ");
            }
            System.out.println();
        }
    }
}



public class Pivas1 {


    public static void main(String[] args) {
        neo obj = new neo(5,5);
        obj.izmenenie(2,3);
    }

}
