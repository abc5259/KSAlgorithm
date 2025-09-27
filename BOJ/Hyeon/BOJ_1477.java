package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        List<Integer> restPlace = new ArrayList<>();
        restPlace.add(0);
        restPlace.add(L);

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                restPlace.add(Integer.parseInt(st.nextToken()));
            }
        }
        Collections.sort(restPlace);

        int lo = 0;
        int hi = L - 1;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            int cnt = 0;

            for (int i = 0; i < restPlace.size() - 1; i++) {
                int dis = restPlace.get(i + 1) - restPlace.get(i);
                cnt += (dis - 1) / mid;
            }

            if (cnt <= M) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        System.out.println(hi);
    }
}
// G4 휴게소 세우기 이분탐색