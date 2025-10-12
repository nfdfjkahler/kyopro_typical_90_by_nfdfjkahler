import java.util.Arrays;
import java.util.Scanner;

public class Main_BinarySearch {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        int[] classes = new int[N];
        for (int a = 0; a < N; a++) {
            classes[a] = scn.nextInt();
        }
        int Q = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(classes);
        for (int b = 0; b < Q; b++) {
            int B = scn.nextInt();
            int idx = Arrays.binarySearch(classes, B);
            if (idx < 0) {
                idx = ~idx;
            }
            int ceilDissatisfaction = Math.abs((idx == N ? classes[N - 1] : classes[idx]) - B);
            int floorDissatisfaction = Math.abs((idx == 0 ? classes[0] : classes[idx - 1]) - B);
            sb.append(Math.min(floorDissatisfaction, ceilDissatisfaction) + "\n");
        }
        System.out.println(sb);
    }
}
