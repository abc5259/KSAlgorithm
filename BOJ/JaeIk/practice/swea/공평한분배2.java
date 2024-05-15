package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 공평한분배2 {
    static int result;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            List<Integer> pocket = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pocket.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(pocket);

            result = Integer.MAX_VALUE;
            for(int i=0; i<=n-k; i++){
                int diff = pocket.get(i+k-1)-pocket.get(i);

                result = Math.min(result, diff);
            }

            System.out.println("#" + (tc + 1) + " " + result);
        }
    }
}
