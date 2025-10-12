import java.util.NavigableSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class Main_TreeSet {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        NavigableSet<Integer> classes = new TreeSet<>();
        for (int a = 0; a < N; a++) {
            classes.add(scn.nextInt());
        }
        int Q = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        int first = classes.first();
        int last = classes.last();
        for (int b = 0; b < Q; b++) {
            int B = scn.nextInt();
            int floorDissatisfactoion =
                    Math.abs(Objects.requireNonNullElse(classes.floor(B), first) - B);
            int ceilDissatisfaction =
                    Math.abs(Objects.requireNonNullElse(classes.ceiling(B), last) - B);
            sb.append(Math.min(floorDissatisfactoion, ceilDissatisfaction) + "\n");
        }
        System.out.println(sb);
    }
}
