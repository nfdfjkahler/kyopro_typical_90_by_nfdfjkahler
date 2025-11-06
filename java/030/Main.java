import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        int K = scn.nextInt();
        int[] factorCount = new int[N + 1];
        for (int a = 2; a <= N; a++) {
            if (factorCount[a] == 0) {
                factorCount[a] = 1;
                for (int b = a * 2; b <= N; b += a) {
                    factorCount[b]++;
                }
            }
        }
        System.out.println(Arrays.stream(factorCount).filter(c -> K <= c).count());
    }
}

