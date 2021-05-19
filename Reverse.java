import java.util.Arrays;

public class Reverse {
//    Как изменить порядок элементов в строке на обратный без использования вспомогательных классов?

//    public static void main(String[] args) {
//        String str = "Java";
//        System.out.println(reverse(str));
//    }
//    public static String reverse(String text) {
//        char [] a = text.toCharArray();
//        char [] b = new char[a.length];
//
//        for (int i = 0; i < a.length; i++) {
//            b[(a.length - 1) - i] = a[i];
//        }
//        return new String(b);
//    }
public static void main(String[] args) {
    int [] array =  {1,2,3,4,5,6,7,8,9,10};
    for (int i = 0; i < array.length / 2; i++) {
        int tmp = array[i];
        array[i] = array[array.length - i - 1];
        array[array.length - i - 1] = tmp;
    }
    System.out.println(Arrays.toString(array));
}
}