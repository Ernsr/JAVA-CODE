public class Harderarephmetic {
    public static void main(String[] args) {
        //Среднее арифметического
        int[] array = {1, 6, 8, 3, 763, 4, 125, 7, 15, 21, 45, 12, 98, 88, 12, 365};
        int result = 0;
        for (int n : array) {
            result += n;
        }
        System.out.println("Harder Arithmetic: " + result / array.length);
    }
}
