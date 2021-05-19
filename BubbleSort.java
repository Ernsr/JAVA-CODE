import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //Сортировка пузырьком
        int [] array = {19, 26, 96,75,45,69,78,12,35,3,11,6,4,1,46,63,100,2};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }

        }
        System.out.println(Arrays.toString(array));
    }
}