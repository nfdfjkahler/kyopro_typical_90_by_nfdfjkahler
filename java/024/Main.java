import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        int K = scn.nextInt();
        int[] arrayA = new int[N];
        int[] arrayB = new int[N];
        for (int a = 0; a < N; a++) {
            arrayA[a] = scn.nextInt();
        }
        for (int b = 0; b < N; b++) {
            arrayB[b] = scn.nextInt();
        }
        for (int c = 0; c < N; c++) {
            int diff = Math.abs(arrayA[c] - arrayB[c]);
            if (diff > K) {
                System.out.println("No");
                return;
            }
            K -= diff;
        }
        System.out.println(K % 2 == 0 ? "Yes" : "No");
    }
}
