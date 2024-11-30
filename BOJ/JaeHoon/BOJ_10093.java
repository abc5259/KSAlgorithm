package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long min = Math.min(a, b);
        long max = Math.max(a, b);
        long dif = max - min - 1;
        StringBuilder sb = new StringBuilder();
        if(dif == -1) dif = 0;
        sb.append(dif).append('\n');
        for(long i=min+1; i<=max-1; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
