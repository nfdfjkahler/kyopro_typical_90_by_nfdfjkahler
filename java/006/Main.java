import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        int K = scn.nextInt();
        String[] S = scn.next().split("");
        var priorityQueue = new PriorityQueue<Pair>(
                Comparator.comparing((Pair p) -> p.word).thenComparingInt(p -> p.index));
        for (int a = 0; a < N - K + 1; a++) {
            priorityQueue.add(new Pair(a, S[a]));
        }
        StringBuilder sb = new StringBuilder();
        int confirmedWordIndex = -1;
        int pushedIndex = N - K + 1;
        while (sb.length() < K) {
            Pair pair = priorityQueue.poll();
            if (confirmedWordIndex < pair.index) {
                sb.append(pair.word);
                confirmedWordIndex = pair.index;
                if (pushedIndex < N) {
                    priorityQueue.add(new Pair(pushedIndex, S[pushedIndex]));
                    pushedIndex++;
                }
            }
        }
        System.out.println(sb);
    }

    public record Pair(int index, String word) {
    }
}
