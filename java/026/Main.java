import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for (int a = 0; a < N; a++) {
            tree.add(new ArrayList<>());
        }
        for (int b = 0; b < N - 1; b++) {
            int A = scn.nextInt() - 1;
            int B = scn.nextInt() - 1;
            tree.get(A).add(B);
            tree.get(B).add(A);
        }
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(0);
        int[] countArray = new int[N];
        Arrays.fill(countArray, -1);
        bfs(q1, q2, tree, countArray, 0);
        var sb = new StringBuilder();
        int oddCallCountSize =
                (int) IntStream.range(0, N).filter(i -> countArray[i] % 2 == 1).count();
        IntPredicate predicate = oddCallCountSize >= N / 2 ? (i -> countArray[i] % 2 == 1)
                : (i -> countArray[i] % 2 == 0);
        IntStream.range(0, N).filter(predicate).limit(N / 2).forEach(i -> sb.append((i + 1) + " "));
        System.out.println(sb);
    }

    public static void bfs(Queue<Integer> q1, Queue<Integer> q2, List<List<Integer>> tree,
            int[] countArray, int callCount) {
        while (!q1.isEmpty()) {
            int now = q1.poll();
            countArray[now] = callCount;
            for (int next : tree.get(now)) {
                if (countArray[next] != -1) {
                    continue;
                }
                q2.add(next);
            }
        }
        if (!q2.isEmpty()) {
            bfs(q2, q1, tree, countArray, callCount + 1);
        }
    }
}
