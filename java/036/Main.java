import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        var N = scn.nextInt();
        var Q = scn.nextInt();
        var points = new long[N][2];
        var minX = Long.MAX_VALUE;
        var minY = Long.MAX_VALUE;
        var maxX = Long.MIN_VALUE;
        var maxY = Long.MIN_VALUE;
        for (int a = 0; a < N; a++) {
            int x = scn.nextInt();
            int y = scn.nextInt();
            points[a][0] = x - y;
            points[a][1] = x + y;
            minX = Math.min(points[a][0], minX);
            minY = Math.min(points[a][1], minY);
            maxX = Math.max(points[a][0], maxX);
            maxY = Math.max(points[a][1], maxY);
        }
        var sb = new StringBuilder();
        for (int b = 0; b < Q; b++) {
            var q = scn.nextInt() - 1;
            var distToMinX = Math.abs(minX - points[q][0]);
            var distToMaxX = Math.abs(maxX - points[q][0]);
            var distToMinY = Math.abs(minY - points[q][1]);
            var distToMaxY = Math.abs(maxY - points[q][1]);
            sb.append(Math.max(distToMinX, Math.max(distToMaxX, Math.max(distToMinY, distToMaxY)))
                    + "\n");
        }
        System.out.println(sb);
    }
}
