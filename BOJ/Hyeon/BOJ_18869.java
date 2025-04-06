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

        ArrayList[] res = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            res[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            List<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            List<Integer> sorted = new ArrayList<>(list);
            Collections.sort(sorted);

            Map<Integer, Integer> map = new HashMap<>();
            int rank = 0;
            for (int val : sorted) {
                if (!map.containsKey(val)) {
                    map.put(val, rank++);
                }
            }
            for (int j = 0; j < N; j++) {
                res[i].add(map.get(list.get(j)));
            }
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (res[i].equals(res[j])) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
// G5 멀티버스 2 좌표 압축