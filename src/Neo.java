import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

class Neo {
    int rows;
    int column;
    int[][] matrix;

    Neo(int r, int c) throws FileNotFoundException {
        rows = r;
        column = c;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("matrix.txt")).getFile());
        Scanner scanner = new Scanner(new FileInputStream(file));
        matrix = new int[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    void show() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void izmenenie_stroci(int stoka) {       // delete 1 row and 1 column

        int[][] m1 = new int[rows - 1][column];
//
        int deli;
        deli = stoka;
        //delj = stolbi;
        for (int i = 0, ln = 0; ln < rows - 1; ) {
            if (i != deli - 1) {
                for (int j = 0, cn = 0; cn < column; j++, cn++) {
                    //if (j==delj-1) j++;
                    m1[ln][cn] = matrix[i][j];
                }
                i++;
                ln++;
            } else i++;
        }
        matrix = m1;
//		for (int i=0; i<rows-1; i++) {
//			for (int j=0; j<column; j++) {
//				System.out.print(matrix[i][j]+"    ");
//			}
//			System.out.println();
//		}
    }

    void izmenenie_stolba(int stolb) {

        int[][] m1 = new int[rows][column - 1];

        int delj;

        delj = stolb;
        for (int i = 0, ln = 0; ln < rows; i++) {

            for (int j = 0, cn = 0; cn < column - 1; j++, cn++) {
                if (j == delj - 1) j++;
                m1[ln][cn] = matrix[i][j];
            }
            //i++;
            ln++;

        }
        matrix = m1;
//		for (int i=0; i<rows; i++) {
//			for (int j=0; j<column-1; j++) {
//				System.out.print(matrix[i][j]+"    ");
//			}
//			System.out.println();
//		}
    }

    void add_stolb() {
        int[][] m2 = new int[rows][column + 1];
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j <= column; j++) {

                if (j == column) {

                    m2[i][j] = 1 + (int) (Math.random() * 10);

                } else {

                    m2[i][j] = matrix[i][j];
                }

            }

        }
        matrix = m2;
//for (int i = 0; i <= rows-count1; i++) {
//for (int j = 0; j <= column-count; j++) {
//System.out.print(matrix[i][j] + "    ");
//}
//System.out.println();
//}

    }

    void add_str() {
        int[][] m2 = new int[rows + 1][column];
        for (int i = 0; i <= rows; i++) {

            for (int j = 0; j < column; j++) {
                if (i == rows) {

                    m2[i][j] = 1 + (int) (Math.random() * 10);

                } else {

                    m2[i][j] = matrix[i][j];
                }

            }

        }
        matrix = m2;
//for (int i = 0; i <= rows-count1; i++) {
//for (int j = 0; j <= column-count; j++) {
//System.out.print(matrix[i][j] + "    ");
//}
//System.out.println();
//}

    }


}