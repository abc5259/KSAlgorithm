package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] input = new int[N];
        int[][] res = new int[M][N];

        List<Integer> sorted = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank, count = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sorted.clear();
            map.clear();

            for (int j = 0; j < N; j++) {
                input[j] = Integer.parseInt(st.nextToken());
                sorted.add(input[j]);
            }

            Collections.sort(sorted);

            rank = 0;
            for (int j = 0; j < N; j++) {
                if (!map.containsKey(sorted.get(j))) {
                    map.put(sorted.get(j), rank++);
                }
            }

            for (int j = 0; j < N; j++) {
                res[i][j] = map.get(input[j]);
            }

            for (int p = 0; p < i; p++) {
                if (check(res[i], res[p])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}

// G5 멀티버스 2 좌표 압축
// 리트라이 필