package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append("Pairs for " + n + ": ");
            int cnt = 0;
            for(int i=1; i<n; i++) {
                int a = i;
                int b = n-i;
                if(a>=b) continue;
                cnt++;
                sb.append(a + " " + b + ", ");
            }
            if(cnt > 0) {
                sb.delete(sb.length()-2, sb.length());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
