import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        int M = scn.nextInt();
        List<List<Path>> tree = new ArrayList<>();
        for (int a = 0; a < N; a++) {
            tree.add(new ArrayList<>());
        }
        for (int b = 0; b < M; b++) {
            int A = scn.nextInt() - 1;
            int B = scn.nextInt() - 1;
            int C = scn.nextInt();
            tree.get(A).add(new Path(B, C));
            tree.get(B).add(new Path(A, C));
        }
        Queue<Path> priorityQueue = new PriorityQueue<>(Comparator.comparing(Path::cost));
        int[] costFromOne = dijkstra(0, priorityQueue, tree);
        int[] costFromN = dijkstra(N - 1, priorityQueue, tree);

        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < N; c++) {
            sb.append(costFromOne[c] + costFromN[c] + "\n");
        }
        System.out.println(sb);
    }

    public static int[] dijkstra(int start, Queue<Path> priorityQueue, List<List<Path>> tree) {
        int[] costArray = new int[tree.size()];
        Arrays.fill(costArray, Integer.MAX_VALUE);

        priorityQueue.addAll(tree.get(start));
        costArray[start] = 0;
        while (!priorityQueue.isEmpty()) {
            var minCostPath = priorityQueue.poll();
            int to = minCostPath.to;
            int cost = minCostPath.cost;
            if (costArray[to] > cost) {
                costArray[to] = cost;
                priorityQueue.addAll(
                        tree.get(to).stream().map(p -> new Path(p.to, p.cost + cost)).toList());
            }
        }
        return costArray;
    }

    public record Path(int to, int cost) {
    }
}
