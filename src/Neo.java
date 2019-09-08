import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Neo {

    private int rows;
    private int columns;
    private int[][] matrix;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Neo(int rows, int columns) throws FileNotFoundException {
        setRows(rows);
        setColumns(columns);
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("matrix.txt")).getFile());
        Scanner scanner = new Scanner(new FileInputStream(file));
        matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public void show() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void izmenenie_stroci(int stoka) {       // delete 1 row and 1 columns

        int[][] m1 = new int[rows - 1][columns];
//
        int deli;
        deli = stoka;
        //delj = stolbi;
        for (int i = 0, ln = 0; ln < rows - 1; ) {
            if (i != deli - 1) {
                for (int j = 0, cn = 0; cn < columns; j++, cn++) {
                    //if (j==delj-1) j++;
                    m1[ln][cn] = matrix[i][j];
                }
                i++;
                ln++;
            } else i++;
        }
        matrix = m1;
    }

    public int[][] izmenenie_stolba(int stolb) {

        int[][] m1 = new int[rows][columns - 1];
        int delj;

        delj = stolb;
        for (int i = 0, ln = 0; ln < rows; i++) {
            for (int j = 0, cn = 0; cn < columns - 1; j++, cn++) {
                if (j == delj - 1) {
                    j++;
                }
                m1[ln][cn] = matrix[i][j];
            }
            ln++;
        }
        matrix = m1;
        return matrix;
    }

    void add_stolb() {
        int[][] m2 = new int[rows][columns + 1];
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j <= columns; j++) {

                if (j == columns) {

                    m2[i][j] = 1 + (int) (Math.random() * 10);

                } else {

                    m2[i][j] = matrix[i][j];
                }

            }

        }
        matrix = m2;
    }

    void add_str() {
        int[][] m2 = new int[rows + 1][columns];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == rows) {
                    m2[i][j] = 1 + (int) (Math.random() * 10);
                } else {
                    m2[i][j] = matrix[i][j];
                }
            }
        }
        matrix = m2;
    }

    public void transpone() {
        for (int i = 0; i < columns; i++) {
            for (int j = i + 1; j < rows; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void extractSubMatrix(int rowStart, int rowEnd, int colStart, int colEnd) {
        int sizeRow = rowEnd - rowStart;
        int sizeCol = colEnd - colStart;

        int[][] result = new int[sizeRow][sizeCol];

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                int x = i - rowStart;
                int y = j - colStart;
                result[x][y] = matrix[i][j];
            }
        }
        matrix = result;
        setRows(sizeRow);
        setColumns(sizeCol);
    }


}