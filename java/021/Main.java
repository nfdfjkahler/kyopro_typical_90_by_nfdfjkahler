import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    static int ORDER = 0;
    static long COUNT = 0;

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        int M = scn.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> revGraph = new ArrayList<>();
        for (int a = 0; a < N; a++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }
        for (int b = 0; b < M; b++) {
            int A = scn.nextInt() - 1;
            int B = scn.nextInt() - 1;
            graph.get(A).add(B);
            revGraph.get(B).add(A);
        }
        int[][] nodeOrders =
                IntStream.range(0, N).mapToObj(i -> new int[] {i, -1}).toArray(int[][]::new);
        for (int c = 0; c < N; c++) {
            if (nodeOrders[c][1] == -1) {
                orderNodes(c, nodeOrders, graph);
            }
        }
        Arrays.sort(nodeOrders, (a, b) -> b[1] - a[1]);
        long ans = 0;
        boolean[] isChecked = new boolean[N];
        for (int node[] : nodeOrders) {
            if (isChecked[node[0]]) {
                continue;
            }
            COUNT = 0;
            SCC(node[0], nodeOrders, isChecked, revGraph);
            ans += COUNT * (COUNT - 1) / 2;
        }
        System.out.println(ans);
    }

    public static void orderNodes(int now, int[][] nodeOrders, List<List<Integer>> graph) {
        // -1以外のダミー値を入れる
        nodeOrders[now][1] = -2;
        for (int next : graph.get(now)) {
            if (nodeOrders[next][1] != -1) {
                continue;
            }
            orderNodes(next, nodeOrders, graph);
        }
        nodeOrders[now][1] = ++ORDER;
    }

    public static void SCC(int now, int[][] nodeOrders, boolean[] isChecked,
            List<List<Integer>> graph) {
        isChecked[now] = true;
        COUNT++;
        for (int next : graph.get(now)) {
            // if (nodeOrders[next][1] == -1) {
            if (isChecked[next]) {
                continue;
            }
            SCC(next, nodeOrders, isChecked, graph);
        }
    }
}
