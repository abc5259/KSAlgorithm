package BOJ.GiSeok.Java;

import java.util.*;
import java.io.*;

public class BOJ_9517 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int time = 0;
        int ans = k - 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            String z = st.nextToken();

            time += t;
            if (time > 210) break;

            if (z.equals("T")) ans = (ans + 1) % 8;
        }

        System.out.println(ans + 1);
    }
}
