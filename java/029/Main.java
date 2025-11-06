import java.util.Scanner;

public class Main {

    static int[] segtree;
    static int[] lazySegtree;

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int W = scn.nextInt();
        int N = scn.nextInt();
        initSegtree(W);
        var sb = new StringBuilder();
        for (int a = 0; a < N; a++) {
            int L = scn.nextInt() - 1;
            int R = scn.nextInt();
            int maxHeight = getMaxHeight(L, R, 0, 0, segtree.length / 2 + 1);
            update(L, R, 0, 0, segtree.length / 2 + 1, maxHeight);
            sb.append(maxHeight + 1 + "\n");
        }
        System.out.println(sb);
    }

    public static void initSegtree(int W) {
        int leefNodeCount = 2;
        while (leefNodeCount < W) {
            leefNodeCount *= 2;
        }
        segtree = new int[leefNodeCount * 2 - 1];
        lazySegtree = new int[leefNodeCount * 2 - 1];
    }


    public static void propagateToLeef(int k) {
        if (lazySegtree[k] == 0) {
            return;
        }
        if (k < lazySegtree.length / 2) {
            lazySegtree[k * 2 + 1] = lazySegtree[k];
            lazySegtree[k * 2 + 2] = lazySegtree[k];
        }
        segtree[k] = lazySegtree[k];
        lazySegtree[k] = 0;
    }

    public static int getMaxHeight(int targetL, int targetR, int nowNode, int l, int r) {
        propagateToLeef(nowNode);
        if (r <= targetL || targetR <= l) {
            return 0;
        } else if (targetL <= l && r <= targetR) {
            return segtree[nowNode];
        } else {
            int vl = getMaxHeight(targetL, targetR, nowNode * 2 + 1, l, (l + r) / 2);
            int vr = getMaxHeight(targetL, targetR, nowNode * 2 + 2, (l + r) / 2, r);
            return Math.max(vl, vr);
        }
    }

    static void update(int targetL, int targetR, int nowNode, int l, int r, int updated) {
        propagateToLeef(nowNode);
        if (targetL <= l && r <= targetR) {
            lazySegtree[nowNode] = updated;
            propagateToLeef(nowNode);
        } else if (targetL < r && l < targetR) {
            update(targetL, targetR, nowNode * 2 + 1, l, (l + r) / 2, updated);
            update(targetL, targetR, nowNode * 2 + 2, (l + r) / 2, r, updated);
            segtree[nowNode] = Math.max(segtree[nowNode * 2 + 1], segtree[nowNode * 2 + 2]);
        }
    }
}

