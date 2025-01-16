package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long min = Math.min(X, Y);
        long sum = Math.min(min * 2 * W, min * S);
        long dif = Math.max(X - min, Y - min);
        if(dif == 0) {
            System.out.println(sum);
            return;
        }

        if(dif % 2 == 0) {
            sum += Math.min(dif * W, dif * S);
        } else {
            sum += Math.min(dif * W, (dif-1) * S + W);
        }

        System.out.println(sum);
    }
}
