import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // Сортировке Выбором
        int[] array = {1, 2, 34, 12, 345, 45, 56, 34, 78, 89, 21, 1, 234};
        System.out.println("Массив не отсоритирован! ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        select(array);
        System.out.println("Массив остортирован!");
        for (int n : array) {
            System.out.print(n + " ");
        }
    }
    public static void select(int [] array) {
        int min,tmp;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            tmp = array[min];
            array[min] = array[i];
            array[i] = tmp;
        }
    }
}

