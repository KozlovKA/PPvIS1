import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pivas1 {


    public static void main(String[] args) throws FileNotFoundException {
        Neo obj = new Neo(5, 5);
        obj.add_stolb();
        Scanner input = new Scanner(System.in);

        boolean k = true;
        while (k) {
            System.out.println("1.Удаление строк и столбцов\n2.Добавление строк и столбцов\n3.Просмотр матрицы\n4.Извлечение подматрицы\n5.Определение типа матрицы\n6.Транспонирование\n7.Выход.");
            int vibor_glavni = input.nextInt();
            switch (vibor_glavni) {
                case 1:
                    System.out.println("1.Удалить столбец \n2.Удалить строку \n3.Удалить строку и столбец");
                    int vibor = input.nextInt();
                    switch (vibor) {
                        case 1:

                            System.out.println("Введите количество удаляемых столбов:");

                            int nomer_stolba = input.nextInt();
                            int[] stolbi = new int[nomer_stolba];
                            System.out.println("Номера удаляемых столбов:");

                            for (int i = 0; i < nomer_stolba; i++) {

                                stolbi[i] = input.nextInt();
                            }
                            for (int i = 0; i < nomer_stolba; i++) {

                                obj.izmenenie_stolba(stolbi[i] - i);
                                obj.column--;
                                System.out.println();
                            }

                            obj.show();


                            break;
                        case 2:
                            System.out.println("Введите количество удаляемых строк:");
                            int nomer_stroki = input.nextInt();

                            int[] stroki = new int[nomer_stroki];
                            System.out.println("Номера удаляемых строк:");
                            for (int i = 0; i < nomer_stroki; i++) {

                                stroki[i] = input.nextInt();
                            }
                            for (int i = 0; i < nomer_stroki; i++) {

                                obj.izmenenie_stroci(stroki[i] - i);
                                obj.rows--;
                                System.out.println();

                            }
                            obj.show();
                            break;
                        case 3:
                            System.out.println("Введите количество удаляемых столбов и строк соответственно:");
                            int nomer_stolb = input.nextInt();
                            int nomer_strok = input.nextInt();
                            System.out.println("Номера удаляемых столбов:");
                            int[] stolb = new int[nomer_stolb];
                            int[] strok = new int[nomer_strok];

                            for (int i = 0; i < nomer_stolb; i++) {

                                stolb[i] = input.nextInt();
                            }
                            for (int i = 0; i < nomer_stolb; i++) {


                                obj.izmenenie_stolba(stolb[i] - i);
                                obj.column--;
                                System.out.println();

                            }

                            System.out.println("Номера удаляемых строк:");
                            for (int i = 0; i < nomer_strok; i++) {

                                strok[i] = input.nextInt();
                            }
                            for (int i = 0; i < nomer_strok; i++) {

                                obj.izmenenie_stroci(strok[i] - i);
                                obj.rows--;
                                System.out.println();

                            }
                            obj.show();
                    }
                    break;
                case 2:
                    System.out.println("1.Добавить столбец\n2.Добавить строку\n3.Добавить строку и столбец\n");
                    int vibor1 = input.nextInt();
                    switch (vibor1) {
                        case 1:
                            System.out.println("Введите количество добавляемых столбов:");
                            int nomer_stolb = input.nextInt();


                            for (int i = 0; i < nomer_stolb; i++) {


                                obj.add_stolb();

                                obj.column++;
                                System.out.println();

                            }
                            obj.show();
                            break;
                        case 2:
                            System.out.println("Введите количество добавляемых строк:");
                            int nomer_str = input.nextInt();
                            ;


                            for (int i = 0; i < nomer_str; i++) {


                                obj.add_str();

                                obj.rows++;
                                System.out.println();

                            }
                            obj.show();
                            break;
                        case 3:
                            System.out.println("Введите количество добавляемых столбов и строк соответственно:");
                            int nomer_stolbov = input.nextInt();
                            int nomer_strok = input.nextInt();


                            for (int i = 0; i < nomer_stolbov; i++) {


                                obj.add_stolb();

                                obj.column++;
                                System.out.println();

                            }
                            for (int i = 0; i < nomer_strok; i++) {


                                obj.add_str();

                                obj.rows++;
                                System.out.println();
                            }
                            obj.show();
                            break;
                    }

                    break;
                case 3:
                    obj.show();
                    break;
            }
        }


    }


}
