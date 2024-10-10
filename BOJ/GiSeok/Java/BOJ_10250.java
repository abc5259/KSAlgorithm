package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_10250 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int xx = n / h + 1;
            int yy = n % h;
            if (n % h == 0) { xx--; yy = h; }
            System.out.println(yy + String.format("%2s", xx).replace(" ", "0"));
        }
    }
}
