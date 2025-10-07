package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19637 {
    static int N;
    static Title[] titles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        titles = new Title[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            titles[i] = new Title(title, power);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int character = Integer.parseInt(br.readLine());
            sb.append(lowerBound(character)).append("\n");
        }
        System.out.print(sb);
    }

    static String lowerBound(int var) {
        int lo = -1;
        int hi = N - 1;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (titles[mid].power >= var) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return titles[hi].tier;
    }

    static class Title {
        String tier;
        int power;

        public Title(String tier, int power) {
            this.tier = tier;
            this.power = power;
        }
    }
}
// S3 IF문 좀 대신 써줘 이분탐색
// 쉽게 풀었다 클래스로 배열 만들어서 lowerBound 씀