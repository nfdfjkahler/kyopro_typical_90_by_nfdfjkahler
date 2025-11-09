import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        var H = scn.nextDouble();
        var W = scn.nextDouble();
        if (H < 2 || W < 2) {
            System.out.println((int) (H * W));
            return;
        }
        System.out.println((int) (Math.ceil(H / 2) * Math.ceil((W / 2))));
    }
}
