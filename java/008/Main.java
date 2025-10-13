import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        char[] S = scn.next().toCharArray();
        long constant = (long) 1e9 + 7;
        char[] atcoder = "atcoder".toCharArray();
        long[][] dp = new long[N + 1][8];
        for (int a = 0; a < N; a++) {
            dp[a][0] = 1;
            for (int b = 0; b < 7; b++) {
                if (S[a] == atcoder[b]) {
                    dp[a + 1][b + 1] += dp[a][b] + dp[a][b + 1];
                    dp[a + 1][b + 1] %= constant;
                } else {
                    dp[a + 1][b + 1] = dp[a][b + 1];
                }
            }
        }
        System.out.println(dp[N][7]);
    }
}
