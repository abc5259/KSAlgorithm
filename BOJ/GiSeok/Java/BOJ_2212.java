package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] streets = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            streets[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(streets);

        int ans = 0;
        if (K < N) {
            int[] dists = new int[N-1];
            for (int i = 0; i < N-1; i++)
                dists[i] = streets[i+1] - streets[i];

            Arrays.sort(dists);
            for (int i = 0; i < N-K; i++)
                ans += dists[i];
        }

        System.out.println(ans);
    }
}
