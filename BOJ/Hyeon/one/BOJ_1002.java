package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(cnt(x1, y1, r1, x2, y2, r2)).append("\n");
        }
        System.out.println(sb);
    }

    private static int cnt(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dis = (int) Math.pow(x2 - x1, 2) + (int) Math.pow(y2 - y1, 2);

        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }

        if (dis > Math.pow(r2 + r1, 2)) {
            return 0;
        }
        if (dis < Math.pow(r2 - r1, 2)) {
            return 0;
        }
        if (dis == Math.pow(r2 - r1, 2)) {
            return 1;
        }
        if (dis == Math.pow(r1 + r2, 2)) {
            return 1;
        }
        return 2;
    }
}

// S3 터렛 기하
// 외접 내접을 이용해서 풀었다.