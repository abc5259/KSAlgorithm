package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2342 {
    static int[][] arr = {
            {1, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1}
    };
    static int[][][] dp;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                break;
            }
            list.add(num);
        }

        dp = new int[5][5][list.size()];

        System.out.println(ddr(0, 0, 0));
    }


    static int ddr(int y, int x, int depth) {
        if (depth == list.size()) {
            return 0;
        }

        if (dp[y][x][depth] != 0) {
            return dp[y][x][depth];
        }

        int dir = list.get(depth);

        if (dir == y || dir == x) {
            dp[y][x][depth] = ddr(y, x, depth + 1) + 1;
        } else {
            dp[y][x][depth] = Math.min(ddr(Math.min(dir, y), Math.max(dir, y), depth + 1) + arr[x][dir],
                    ddr(Math.min(x, dir), Math.max(x, dir), depth + 1) + arr[y][dir]);

        }
        return dp[y][x][depth];
    }
}

// G3 Dance Dance Revolution DP
// 어렵다 분기점을 잡아가고 있다.