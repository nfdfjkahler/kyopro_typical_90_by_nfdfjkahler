import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        long A = scn.nextLong();
        long B = scn.nextLong();
        long C = scn.nextLong();
        long commonGcd = gcd(A, gcd(B, C));
        System.out.println(A / commonGcd + B / commonGcd + C / commonGcd - 3);
    }

    public static long gcd(long x, long y) {
        long remainder = x % y;
        if (remainder == 0) {
            return y;
        }
        return gcd(y, remainder);
    }
}
