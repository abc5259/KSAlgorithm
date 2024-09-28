package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2141 {
    static class Village {
        int x, cnt;

        Village(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Village[] villages = new Village[N+1];
        villages[0] = new Village(0, 0);
        long total = 0;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            villages[i] = new Village(x, cnt);
            total += villages[i].cnt;
        }

        Arrays.sort(villages, (a,b) -> a.x - b.x);

        long sum = 0;
        long mid = (total + 1) / 2;
        for(Village v: villages) {
            sum += v.cnt;
            if(sum >= mid) {
                System.out.println(v.x);
                return;
            }
        }


    }
}
