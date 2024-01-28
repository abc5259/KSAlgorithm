package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        if (a + b - 1 > N) {
            System.out.println(-1);
            return;
        }

        for(int i=1; i<=a-1; i++) {
            list.add(i);
        }

        list.add(Math.max(a, b));

        for(int i=b-1; i>=1; i--) {
            list.add(i);
        }

        for(int i=1; i<=N - (a+b) +1; i++) {
            list.add(1,1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
