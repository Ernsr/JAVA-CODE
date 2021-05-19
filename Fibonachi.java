import java.util.Scanner;

public class Fibonachi {
//    public static void main(String[] args) {
//        // Число фибоначи
//       int n = 6;
//        System.out.println(function(n));
//    }
//    public static int function(int n) {
//        int first = 0;
//        int second = 1;
//        int result = n;
//        for (int i = 1; i < n; i++) {
//            result = first + second;
//            first = second;
//            second = result;
//        }
//        return result;
//    }

    public static void main(String[] args) {

        int first = 1;
        int second = 1;
        System.out.print(first + " " + second + " ");
        int result= 0;

        for (int i = 2; i < 6; i++) {
            result = first + second;
            first = second;
            second = result;
            System.out.print(result + " ");
        }

    }
}
