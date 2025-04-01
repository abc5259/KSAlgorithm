package BOJ.Hyeon;

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
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            red[i] += Math.min(green[i - 1], blue[i - 1]);
            green[i] += Math.min(red[i - 1], blue[i - 1]);
            blue[i] += Math.min(red[i - 1], green[i - 1]);
        }
        System.out.println(Math.min(red[N - 1], Math.min(blue[N - 1], green[N - 1])));
    }
}
// 0번은 기초로 깔려있다고 가정하고 1번 인덱스부터 연산하여 본인을 제외한 이전 값들의 최소값을
// 저정해 나가서 이를 각 색깔의 dp에 저장, 그리고 최소값을 구해내는 메모이네이션 방식채용.
