import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        var userNames = new HashSet<>();
        var sb = new StringBuilder();
        for (int a = 1; a <= N; a++) {
            var name = scn.next();
            if (!userNames.contains(name)) {
                userNames.add(name);
                sb.append(a + "\n");
            }
        }
        System.out.println(sb);
    }
}
