public class FingTheMin {
    public static void main(String[] args) {
//Поиск минимального элемента в массиве
        int[] array = {18, 16, 18, 13, 17, 14, 11,1 ,77, 15, 21, 45, 12, 98, 88, 3, 3, 2};
        int minValue = array[0];
        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        System.out.println("Min Value: " + minValue);
        System.out.println("Min index: " + minIndex);
    }
}