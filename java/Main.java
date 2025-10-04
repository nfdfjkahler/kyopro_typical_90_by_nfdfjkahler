
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        int L = scn.nextInt();
        int K = scn.nextInt();
        long[] yokans = new long[N + 2];
        for (int a = 1; a <= N; a++) {
            yokans[a] = scn.nextLong();
        }
        yokans[N + 1] = L;
        long minScore = 1;
        long maxScore = L;
        while (maxScore - minScore > 1) {
            long midScore = (minScore + maxScore) / 2;
            int cutCount = 0;
            int cutPoint = 0;
            for (int b = 1; b < N + 2; b++) {
                if (yokans[b] - yokans[cutPoint] >= midScore) {
                    cutCount++;
                    cutPoint = b;
                }
            }
            if (cutCount <= K) {
                maxScore = midScore;
            } else {
                minScore = midScore;
            }
        }
        System.out.println(minScore);
    }
}
