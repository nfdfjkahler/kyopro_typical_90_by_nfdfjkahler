import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        var houses = new long[N];
        var schools = new long[N];
        for (int a = 0; a < N; a++) {
            houses[a] = scn.nextInt();
        }
        for (int b = 0; b < N; b++) {
            schools[b] = scn.nextInt();
        }
        Arrays.sort(houses);
        Arrays.sort(schools);
        System.out.println(LongStream.range(0, N)
                .map(i -> Math.abs(houses[(int) i] - schools[(int) i])).sum());
    }
}
