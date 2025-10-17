import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        long N = scn.nextLong();
        long A = scn.nextLong();
        long B = scn.nextLong();
        long C = scn.nextLong();
        long ans = 9999;
        for (int a = 0; a <= 9999; a++) {
            for (int b = 0; b <= 9999 - a; b++) {
                long credit = N - A * a - B * b;
                if (credit < 0) {
                    break;
                }
                if (credit % C == 0) {
                    ans = Math.min(ans, a + b + credit / C);
                }
            }
        }
        System.out.println(ans);
    }
}
