import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

class Neo {

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

    int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    Neo(int rows, int columns, int[][] matrix) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
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

    void removeRow(int rowToDelete) {       // delete 1 row and 1 columns

        int[][] newMatrix = new int[rows - 1][columns];
        for (int i = 0, ln = 0; ln < rows - 1; ) {
            if (i != rowToDelete - 1) {
                for (int j = 0, cn = 0; cn < columns; j++, cn++) {
                    newMatrix[ln][cn] = matrix[i][j];
                }
                i++;
                ln++;
            } else i++;
        }
        matrix = newMatrix;
    }

    void removeColumn(int columnToDelete) {
        int[][] newMatrix = new int[rows][columns - 1];
        for (int i = 0, ln = 0; ln < rows; i++) {
            for (int j = 0, cn = 0; cn < columns - 1; j++, cn++) {
                if (j == columnToDelete - 1) {
                    j++;
                }
                newMatrix[ln][cn] = matrix[i][j];
            }
            ln++;
        }
        matrix = newMatrix;
    }

    void addColumn() {
        int[][] newMatrix = new int[rows][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= columns; j++) {
                if (j == columns) {
                    newMatrix[i][j] = 1 + (int) (Math.random() * 10);
                } else {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }
        matrix = newMatrix;
    }

    void addRow() {
        int[][] newMatrix = new int[rows + 1][columns];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == rows) {
                    newMatrix[i][j] = 1 + (int) (Math.random() * 10);
                } else {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }
        matrix = newMatrix;
    }

    void transpone() {
        for (int i = 0; i < columns; i++) {
            for (int j = i + 1; j < rows; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    void extractSubMatrix(int rowStart, int rowEnd, int colStart, int colEnd) {


        int sizeRow = rowEnd - rowStart + 1;
        int sizeCol = colEnd - colStart + 1;

        int[][] result = new int[sizeRow][sizeCol];

        for (int i = rowStart - 1; i < rowEnd; i++) {
            for (int j = colStart - 1; j < colEnd; j++) {
                int x = i - rowStart + 1;
                int y = j - colStart + 1;
                result[x][y] = matrix[i][j];
            }
        }
        matrix = result;
        setRows(sizeRow);
        setColumns(sizeCol);
    }

    void check() {
        boolean flagSim = true;
        boolean flag0 = true;
        boolean flagE = true;
        boolean flagD = true;
        boolean flagLower = true;
        boolean flagHigher = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] != 0)
                    flag0 = false;

                if (columns == rows) {
                    if (i != j) {
                        if (matrix[i][j] != 0) {
                            flagD = false;
                            flagE = false;
                        }
                    } else {
                        if (matrix[i][j] != 1)
                            flagE = false;
                    }

                    if (matrix[i][j] != matrix[j][i]) {
                        flagSim = false;

                    }
                } else {
                    flagD = false;
                    flagE = false;
                    flagSim = false;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < columns; j++) {
                if (matrix[i][j] != 0) {
                    flagHigher = false;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    flagLower = false;
                }
            }
        }
        if (rows == columns) {
            System.out.println("Квадратная\t");
            if (flagHigher) {
                System.out.println("Верхняя треугольная");
            }
            if (flagLower) {
                System.out.println("Нижняя треугольная");
            }
            if (flagSim) {
                System.out.println("Симетрическая");
            }
            if (flagE) {
                System.out.println("Единичная");
            }
            if (flagD) {
                System.out.println("Диагональная");
            }
        }
        if (flag0) {
            System.out.println("Нулевая");
        }
    }

}