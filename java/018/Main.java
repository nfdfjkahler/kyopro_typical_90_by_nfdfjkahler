import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        var T = scn.nextDouble();
        var L = scn.nextDouble();
        var X = scn.nextDouble();
        var Y = scn.nextDouble();
        int Q = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < Q; a++) {
            var E = scn.nextDouble();
            double y = Math.sin(-E / T * 2 * Math.PI) * L / 2;
            double z = -Math.cos(E / T * 2 * Math.PI) * L / 2 + L / 2;
            double horizontalDist = Math.sqrt(Math.pow(X, 2) + Math.pow(Y - y, 2));
            sb.append(Math.toDegrees(Math.atan(z / horizontalDist)) + "\n");
        }
        System.out.println(sb);
    }
}
