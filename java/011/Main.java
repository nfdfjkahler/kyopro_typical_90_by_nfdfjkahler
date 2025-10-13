import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        long[][] jobs = new long[N][3];
        for (int a = 0; a < N; a++) {
            jobs[a][0] = scn.nextLong();
            jobs[a][1] = scn.nextLong();
            jobs[a][2] = scn.nextLong();
        }
        Arrays.sort(jobs, (a, b) -> (int) a[0] - (int) b[0]);
        long[][] dp = new long[N + 1][5001];
        for (int b = 0; b < N; b++) {
            for (int c = 0; c <= 5000; c++) {
                int deadline = (int) jobs[b][0];
                int duration = (int) jobs[b][1];
                long money = jobs[b][2];
                if (c < duration || deadline < c) {
                    dp[b + 1][c] = dp[b][c];
                } else {
                    dp[b + 1][c] = Math.max(dp[b][c - duration] + money, dp[b][c]);
                }
            }
        }
        System.out.println(Arrays.stream(dp[N]).max().getAsLong());
    }
}
