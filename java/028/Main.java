import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[][] xyPlane = new int[1001][1001];
        for (int a = 0; a < N; a++) {
            int lx = scn.nextInt();
            int ly = scn.nextInt();
            int rx = scn.nextInt();
            int ry = scn.nextInt();
            for (int b = ly; b <= ry - 1; b++) {
                xyPlane[lx][b]++;
                xyPlane[rx][b]--;
            }
        }
        int[] ans = new int[N + 1];
        for (int c = 0; c < 1001; c++) {
            int coodinate = xyPlane[0][c];
            ans[coodinate]++;
            for (int d = 1; d < 1001; d++) {
                coodinate += xyPlane[d][c];
                ans[coodinate]++;
            }
        }
        var sb = new StringBuilder();
        for (int d = 1; d <= N; d++) {
            sb.append(ans[d] + "\n");
        }
        System.out.println(sb);
    }
}
