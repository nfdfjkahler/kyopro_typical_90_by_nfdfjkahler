import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        var nums = new int[N * 2];
        for (int a = 0; a < 2 * N; a++) {
            nums[a] = scn.nextInt();
        }
        long[][] costs = new long[2 * N][2 * N];
        long[][] dp = new long[2 * N][2 * N];
        for (int b = 0; b < 2 * N; b++) {
            for (int c = b + 1; c < 2 * N; c++) {
                costs[b][c] = Math.abs(nums[b] - nums[c]);
            }
        }
        for (int right = 1; right < 2 * N; right += 2) {
            for (int l = 0, r = right; r < 2 * N; l++, r++) {
                long min = Long.MAX_VALUE;
                for (int mid = l + 1; mid < r; mid += 2) {
                    min = Math.min(min, dp[l][mid] + dp[mid + 1][r]);
                }
                dp[l][r] = Math.min(dp[l + 1][r - 1] + costs[l][r], min);
            }
        }
        System.out.println(dp[0][2 * N - 1]);
    }
}
