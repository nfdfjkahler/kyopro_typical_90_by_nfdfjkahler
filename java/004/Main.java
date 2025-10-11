
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int H = scn.nextInt();
        int W = scn.nextInt();
        int[][] grid = new int[H][W];
        int[] sumOfRow = new int[H];
        int[] sumOfColumn = new int[W];
        for (int a = 0; a < H; a++) {
            for (int b = 0; b < W; b++) {
                grid[a][b] = scn.nextInt();
                sumOfRow[a] += grid[a][b];
                sumOfColumn[b] += grid[a][b];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < H; c++) {
            for (int d = 0; d < W; d++) {
                sb.append(sumOfRow[c] + sumOfColumn[d] - grid[c][d] + " ");
            }
            sb.append("\r");
        }
        System.out.print(sb);
    }
}
