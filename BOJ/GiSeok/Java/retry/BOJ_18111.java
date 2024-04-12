package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {

    static int N, M, B;
    static int[] map;
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N*M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int range = (n * M);
            for (int m = range; m < range + M; m++)
                map[m] = Integer.parseInt(st.nextToken());
        }

        answer[0] = Integer.MAX_VALUE;
        for (int h = 0; h <= 256; h++)
            digging(h);

        System.out.println(answer[0] + " " + answer[1]);
    }

    static void digging(int h) {
        int b = B;
        int time = 0;

        for (int v = 0; v < N*M; v++) {
            if (map[v] < h) {
                b -= (h - map[v]);
                time += (h - map[v]);
            } else if (map[v] > h) {
                b += (map[v] - h);
                time += ((map[v] - h) * 2);
            }
        }

        if (b < 0)
            return;

        if (time < answer[0]) {
            answer[0] = time;
            answer[1] = h;
        } else if (time == answer[0]) {
            if (answer[1] < h)
                answer[1] = h;
        }
    }
}
