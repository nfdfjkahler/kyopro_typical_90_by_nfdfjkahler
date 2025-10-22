import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        long a = scn.nextLong();
        int b = scn.nextInt();
        int c = scn.nextInt();
        System.out.println(a < BigInteger.valueOf(c).pow(b).longValue() ? "Yes" : "No");
    }
}
