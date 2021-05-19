import java.util.Arrays;
import java.util.Locale;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome("AABB BBBB BBAA"));
        System.out.println(palindrome("VVBB Bbbb BBVV"));
    }
    public static boolean palindrome(String s) {
        String s1 = s.toUpperCase().replaceAll("^A-Za-z","");
        StringBuilder s2 = new StringBuilder(s1).reverse();
        boolean answer = true;
        for (int i = 0;i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                answer = false;
                break;
            }
        }
        return answer;
    }
}
