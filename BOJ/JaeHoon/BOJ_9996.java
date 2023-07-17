package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] pattern = br.readLine().split("\\*");

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            if(str.length() >= pattern[0].length() + pattern[1].length() && str.startsWith(pattern[0]) && str.endsWith(pattern[1]))
                sb.append("DA\n");
            else
                sb.append("NE\n");
        }

        System.out.println(sb);
    }
}
