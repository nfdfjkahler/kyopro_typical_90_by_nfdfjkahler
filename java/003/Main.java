
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
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
            int from = scn.nextInt() - 1;
            int to = scn.nextInt() - 1;
            tree.get(from).add(to);
            tree.get(to).add(from);
        }
        Queue<Integer> cities = new LinkedList<>();
        cities.add(0);
        int[][] distanceArray = IntStream.range(0, N).mapToObj(i -> new int[] { i, -1 }).toArray(int[][]::new);
        distanceArray[0][1] = 0;
        bfs(cities, tree, distanceArray);
        Arrays.sort(distanceArray, (a, b) -> (b[1] - a[1]));
        int farthestFromZero = distanceArray[0][0];
        cities.add(farthestFromZero);
        Arrays.stream(distanceArray).forEach(distArray -> distArray[1] = -1);
        distanceArray[farthestFromZero][1] = 0;
        bfs(cities, tree, distanceArray);
        Arrays.sort(distanceArray, (a, b) -> (b[1] - a[1]));
        System.out.println(distanceArray[0][1] + 1);
    }

    public static void bfs(Queue<Integer> cities, List<List<Integer>> tree, int[][] distanceArray) {
        while (!cities.isEmpty()) {
            int now = cities.poll();
            for (int next : tree.get(now)) {
                if (distanceArray[next][1] == -1) {
                    distanceArray[next][1] = distanceArray[now][1] + 1;
                    cities.add(next);
                }
            }
        }
    }
}
