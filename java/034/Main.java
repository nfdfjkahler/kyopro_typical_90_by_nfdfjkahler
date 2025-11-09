import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        var N = scn.nextInt();
        var K = scn.nextInt();
        int[] nums = new int[N];
        for (int a = 0; a < N; a++) {
            nums[a] = scn.nextInt();
        }
        int ans = 0;
        int rangeFrom = 0;
        Map<Integer, Set<Integer>> typesMap = new HashMap<>();
        for (int b = 0; b < N; b++) {
            typesMap.merge(nums[b], new HashSet<>(), (k, v) -> {
                return v;
            }).add(b);
            if (typesMap.size() <= K) {
                ans = Math.max(ans, b - rangeFrom + 1);
            } else {
                while (K < typesMap.size()) {
                    var idxSet = typesMap.get(nums[rangeFrom]);
                    idxSet.remove(rangeFrom);
                    if (idxSet.isEmpty()) {
                        typesMap.remove((Integer) nums[rangeFrom]);
                    }
                    rangeFrom++;
                }
            }
        }
        System.out.println(ans);
    }
}
