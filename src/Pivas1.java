import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pivas1 {

    private static final String MAIN_MENU = "1.Удаление строк и столбцов\n2.Добавление строк и столбцов\n3.Просмотр матрицы\n4.Извлечение подматрицы\n5.Определение типа матрицы\n6.Транспонирование\n7.Выход.";

    public static void main(String[] args) throws FileNotFoundException {
        Neo neo = new Neo(5, 5);
        Scanner input = new Scanner(System.in);

        boolean isExit = false;
        while (!isExit) {
            System.out.println(MAIN_MENU);
            int mainChoice = input.nextInt();
            switch (mainChoice) {
                case 1:
                    System.out.println("1.Удалить столбец \n2.Удалить строку \n3.Удалить строку и столбец");
                    int subChoice = input.nextInt();
                    switch (subChoice) {
                        case 1:
                            System.out.println("Введите количество удаляемых столбов:");

                            int columnToDelete = input.nextInt();
                            int[] columnsToDelete = new int[columnToDelete];
                            System.out.println("Номера удаляемых столбов:");

                            for (int i = 0; i < columnToDelete; i++) {
                                columnsToDelete[i] = input.nextInt();
                            }
                            for (int i = 0; i < columnToDelete; i++) {
                                neo.removeColumn(columnsToDelete[i] - i);
                                neo.setColumns(neo.getColumns() - 1);
                                System.out.println();
                            }
                            neo.show();

                            break;
                        case 2:
                            System.out.println("Введите количество удаляемых строк:");
                            int rowToDelete = input.nextInt();

                            int[] rowsToDelete = new int[rowToDelete];
                            System.out.println("Номера удаляемых строк:");
                            for (int i = 0; i < rowToDelete; i++) {
                                rowsToDelete[i] = input.nextInt();
                            }
                            for (int i = 0; i < rowToDelete; i++) {
                                neo.removeRow(rowsToDelete[i] - i);
                                neo.setRows(neo.getRows() - 1);
                                System.out.println();
                            }
                            neo.show();
                            break;
                        case 3:
                            System.out.println("Введите количество удаляемых столбов и строк соответственно:");
                            rowToDelete = input.nextInt();
                            columnToDelete = input.nextInt();
                            System.out.println("Номера удаляемых столбов:");
                            rowsToDelete = new int[rowToDelete];
                            columnsToDelete = new int[columnToDelete];

                            for (int i = 0; i < rowToDelete; i++) {
                                rowsToDelete[i] = input.nextInt();
                            }
                            for (int i = 0; i < rowToDelete; i++) {
                                neo.removeColumn(rowsToDelete[i] - i);
                                neo.setColumns(neo.getColumns() - 1);
                                System.out.println();
                            }

                            System.out.println("Номера удаляемых строк:");
                            for (int i = 0; i < columnToDelete; i++) {
                                columnsToDelete[i] = input.nextInt();
                            }
                            for (int i = 0; i < columnToDelete; i++) {
                                neo.removeRow(columnsToDelete[i] - i);
                                neo.setRows(neo.getRows() - 1);
                                System.out.println();
                            }
                            neo.show();
                    }
                    break;
                case 2:
                    System.out.println("1.Добавить столбец\n2.Добавить строку\n3.Добавить строку и столбец\n");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Введите количество добавляемых столбов:");
                            int nomer_stolb = input.nextInt();

                            for (int i = 0; i < nomer_stolb; i++) {
                                neo.addColumn();
                                neo.setColumns(neo.getColumns() + 1);
                                System.out.println();
                            }
                            neo.show();
                            break;
                        case 2:
                            System.out.println("Введите количество добавляемых строк:");
                            int nomer_str = input.nextInt();

                            for (int i = 0; i < nomer_str; i++) {
                                neo.addRow();
                                neo.setRows(neo.getRows() + 1);
                                System.out.println();
                            }
                            neo.show();
                            break;
                        case 3:
                            System.out.println("Введите количество добавляемых столбов и строк соответственно:");
                            int nomer_stolbov = input.nextInt();
                            int nomer_strok = input.nextInt();

                            for (int i = 0; i < nomer_stolbov; i++) {
                                neo.addColumn();
                                neo.setColumns(neo.getColumns() + 1);
                                System.out.println();
                            }
                            for (int i = 0; i < nomer_strok; i++) {
                                neo.addRow();
                                neo.setRows(neo.getRows() + 1);
                                System.out.println();
                            }
                            neo.show();
                            break;
                    }
                    break;

                case 3:
                    neo.show();
                    break;

                case 4:
                    System.out.println("Введите этемент сротки начала извлечения подматрицы :");
                    int rowStart = input.nextInt();
                    System.out.println("Введите этемент сротки окончания извлечения подматрицы :");
                    int rowEnd = input.nextInt();
                    System.out.println("Введите этемент столбца начала извлечения подматрицы :");
                    int colStart = input.nextInt();
                    System.out.println("Введите этемент столбца окончания извлечения подматрицы :");
                    int colEnd = input.nextInt();
                    neo.extractSubMatrix(rowStart, rowEnd, colStart, colEnd);
                    neo.show();
                    break;
                case 5:
                    neo.check();
                    break;

                case 6:
                    neo.transpone();
                    neo.show();
                    break;
                case 7:
                    isExit = true;
                    break;
            }
        }
    }


}
