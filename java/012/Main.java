import java.util.Scanner;

public class Main {

    static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        var scn = new Scanner(System.in);
        int H = scn.nextInt();
        int W = scn.nextInt();
        int Q = scn.nextInt();
        int[][] grid = new int[H][W];
        boolean[][] isPainted = new boolean[H][W];
        for (int a = 0; a < H; a++) {
            for (int b = 0; b < W; b++) {
                grid[a][b] = a * W + b;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < Q; a++) {
            int q = scn.nextInt();
            switch (q) {
                case 1:
                    int r = scn.nextInt() - 1;
                    int c = scn.nextInt() - 1;
                    isPainted[r][c] = true;
                    updateRoot(r, c, grid, isPainted);
                    break;
                case 2:
                    int ra = scn.nextInt() - 1;
                    int ca = scn.nextInt() - 1;
                    int rb = scn.nextInt() - 1;
                    int cb = scn.nextInt() - 1;
                    int rootA = findRoot(ra, ca, grid);
                    int rootB = findRoot(rb, cb, grid);
                    sb.append((isPainted[ra][ca] && isPainted[rb][cb] && rootA == rootB ? "Yes"
                            : "No") + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static int findRoot(int x, int y, int[][] unionFindMap) {
        int nextNodeAddr = unionFindMap[x][y];
        int nextNodeX = nextNodeAddr / unionFindMap[0].length;
        int nextNodeY = nextNodeAddr % unionFindMap[0].length;
        if (unionFindMap[x][y] != unionFindMap[nextNodeX][nextNodeY]) {
            int rootAddr = findRoot(nextNodeX, nextNodeY, unionFindMap);
            unionFindMap[x][y] = rootAddr;
            return rootAddr;
        } else {
            return nextNodeAddr;
        }
    }

    public static void updateRoot(int x, int y, int[][] unionFindMap, boolean[][] isPainted) {
        for (int[] direction : directions) {
            int neighborX = x + direction[0];
            int neighborY = y + direction[1];
            if (isExistAndPainted(neighborX, neighborY, isPainted)) {
                unionFindMap[x][y] = findRoot(neighborX, neighborY, unionFindMap);
            }
        }
        for (int[] direction : directions) {
            int neighborX = x + direction[0];
            int neighborY = y + direction[1];
            if (isExistAndPainted(neighborX, neighborY, isPainted)) {
                int neighborRootX = unionFindMap[neighborX][neighborY] / unionFindMap[0].length;
                int neighborRootY = unionFindMap[neighborX][neighborY] % unionFindMap[0].length;
                unionFindMap[neighborRootX][neighborRootY] = unionFindMap[x][y];
            }
        }
    }

    public static boolean isExistAndPainted(int x, int y, boolean[][] isPainted) {
        return 0 <= x && x < isPainted.length && 0 <= y && y < isPainted[0].length
                && isPainted[x][y];
    }
}
