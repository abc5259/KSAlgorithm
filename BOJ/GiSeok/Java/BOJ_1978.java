package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_1978 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (isPrime(a)) ret++;
        }

        System.out.println(ret);
    }

    private static boolean isPrime(int a) {
        if (a == 1) return false;

        for (int m = 2; m <= a/2; m++) {
            if (a % m == 0) return false;
        }

        return true;
    }
}