
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    static SortedSet<String> parenthesesSet = new TreeSet<>();

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        if (N % 2 == 0) {
            String[] parentheses = new String[N];
            enumParentheses(N / 2, N / 2, parentheses);
        }
        StringBuilder ans = new StringBuilder();
        parenthesesSet.forEach(str -> ans.append(str + "\n"));
        System.out.println(ans);
    }

    public static void enumParentheses(int leftCount, int rightCount, String[] parentheses) {
        if (rightCount < 0 || leftCount < 0) {
            return;
        } else if (rightCount == 0 && leftCount == 0) {
            parenthesesSet.add(Arrays.stream(parentheses).reduce("", (a, b) -> a + b));
            return;
        }
        if (leftCount < rightCount) {
            parentheses[parentheses.length - leftCount - rightCount] = ")";
            enumParentheses(leftCount, rightCount - 1, parentheses);
        }
        parentheses[parentheses.length - leftCount - rightCount] = "(";
        enumParentheses(leftCount - 1, rightCount, parentheses);
    }
}
