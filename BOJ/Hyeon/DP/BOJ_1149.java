package BOJ.Hyeon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] red = new int[N];
        int[] green = new int[N];
        int[] blue = new int[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            red[i] += Math.min(green[i - 1], blue[i - 1]);
            green[i] += Math.min(red[i - 1], blue[i - 1]);
            blue[i] += Math.min(red[i - 1], green[i - 1]);
        }
        System.out.println(Math.min(red[N - 1], Math.min(green[N - 1], blue[N - 1])));
    }
}
