package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] res = new int[M][N];
        int[] og = new int[N];

        List<Integer> sorted = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int rank, cnt = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sorted.clear();
            map.clear();

            for (int j = 0; j < N; j++) {
                og[j] = Integer.parseInt(st.nextToken());
                sorted.add(og[j]);
            }
            Collections.sort(sorted);

            rank = 0;
            for (int j = 0; j < N; j++) {
                if (!map.containsKey(sorted.get(j))) {
                    map.put(sorted.get(j), rank++);
                }
            }
            for (int j = 0; j < N; j++) {
                res[i][j] = map.get(og[j]);
            }
            for (int j = 0; j < i; j++) {
                if (check(res[i], res[j])) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }

    private static boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
