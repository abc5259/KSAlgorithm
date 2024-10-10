package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_2609 {

    public static int eculidean(int a, int b) {
        a %= b;
        if (a == 0) return b;
        return eculidean(b, a);
    }

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = eculidean(a, b);
        System.out.println(gcd);
        System.out.println(a*b / gcd);
    }
}