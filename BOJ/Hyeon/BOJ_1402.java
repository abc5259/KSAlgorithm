package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            br.readLine();
            sb.append("yes\n");
        }

        System.out.println(sb);
    }
}
// S5 아무래도이문제는A번난이도인것같다 애드훅
// X 다시