import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        var times = new int[N][N];
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                times[a][b] = scn.nextInt();
            }
        }
        int M = scn.nextInt();
        var rumors = new boolean[N][N];
        for (int c = 0; c < M; c++) {
            int X = scn.nextInt() - 1;
            int Y = scn.nextInt() - 1;
            rumors[X][Y] = true;
            rumors[Y][X] = true;
        }
        var permutations = enumPermutation(N);
        int ans = Integer.MAX_VALUE;
        order: for (var order : permutations) {
            int totalTime = 0;
            for (int d = 0; d < N - 1; d++) {
                int runner1 = order.get(d);
                int runner2 = order.get(d + 1);
                if (rumors[runner1][runner2]) {
                    continue order;
                }
                totalTime += times[runner1][d];
            }
            totalTime += times[order.get((N - 1))][N - 1];
            ans = Math.min(ans, totalTime);

        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }


    public static List<List<Integer>> enumPermutation(int N) {
        List<List<Integer>> permutations = new ArrayList<>();
        var permutation = IntStream.range(0, N).boxed().collect(Collectors.toList());
        nextPermutation(permutations, permutation, 0);
        return permutations;
    }

    public static void nextPermutation(List<List<Integer>> permutations, List<Integer> permutation,
            int nowIdx) {
        if (nowIdx == permutation.size()) {
            permutations.add(new ArrayList<>(permutation));
        }
        for (int i = nowIdx; i < permutation.size(); i++) {
            Collections.swap(permutation, i, nowIdx);
            nextPermutation(permutations, permutation, nowIdx + 1);
            Collections.swap(permutation, i, nowIdx);
        }
    }
}
