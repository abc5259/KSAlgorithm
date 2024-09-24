package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3980 {
    static int[][] arr;
    static boolean[] isUsed;
//    static List<List<Integer>> list = new ArrayList<>();
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            max = 0;
            arr = new int[11][11];
            isUsed = new boolean[11];

            for(int i=0; i<11; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve(0,0);
            sb.append(max).append("\n");
        }
        System.out.print(sb);

    }

    static void solve(int k, int sum) {

        if(k == 11) {
            max = Math.max(sum, max);
            return;
        }

        for(int i=0; i<11; i++) {
            if(arr[i][k] > 0) {
                if(isUsed[i]) continue;
                isUsed[i] = true;
                solve(k+1, sum+arr[i][k]);
                isUsed[i] = false;
            }
        }
    }
}