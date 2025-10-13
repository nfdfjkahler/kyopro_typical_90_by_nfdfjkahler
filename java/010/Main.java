import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int N = scn.nextInt();
        SortedMap<Integer, Integer> classOne = new TreeMap<>();
        SortedMap<Integer, Integer> classTwo = new TreeMap<>();
        for (int a = 1; a <= N; a++) {
            int C = scn.nextInt();
            int P = scn.nextInt();
            if (C == 1) {
                classOne.put(a, P);
            } else {
                classTwo.put(a, P);
            }
        }
        NavigableMap<Integer, Integer> classOneCumulativeScore = createCumulativeScoreMap(classOne);
        NavigableMap<Integer, Integer> classTwoCumulativeScore = createCumulativeScoreMap(classTwo);
        int Q = scn.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int b = 0; b < Q; b++) {
            int L = scn.nextInt();
            int R = scn.nextInt();
            int scoreSumClassOne = getCumulativeSum(L, R, classOneCumulativeScore);
            int scoreSumClassTwo = getCumulativeSum(L, R, classTwoCumulativeScore);
            sb.append(scoreSumClassOne + " " + scoreSumClassTwo + "\n");
        }
        System.out.println(sb);
    }

    public static NavigableMap<Integer, Integer> createCumulativeScoreMap(
            Map<Integer, Integer> scoreMap) {
        int scoreSum = 0;
        NavigableMap<Integer, Integer> cumulativeScoreMap = new TreeMap<>();
        cumulativeScoreMap.put(0, 0);
        for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
            scoreSum += entry.getValue();
            cumulativeScoreMap.put(entry.getKey(), scoreSum);
        }
        return cumulativeScoreMap;
    }

    public static int getCumulativeSum(int L, int R,
            NavigableMap<Integer, Integer> cumulativeScoreMap) {
        int left = cumulativeScoreMap.lowerKey(L);
        Integer right = cumulativeScoreMap.floorKey(R);
        if (right == null) {
            right = cumulativeScoreMap.lastKey();
        }
        return cumulativeScoreMap.get(right) - cumulativeScoreMap.get(left);
    }
}
