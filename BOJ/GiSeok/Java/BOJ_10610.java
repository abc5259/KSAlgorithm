package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();
        int[] n = new int[N.length()];
        boolean isZero = false;

        for (int i = 0; i < n.length; i++) {
            n[i] = (N.charAt(i) - '0');

            if (n[i] == 0)
                isZero = true;
        }

        if (isZero) {
            int num = 0;
            for (int i = 0; i < n.length; i++) {
                num += n[i];
            }

            if (num % 3 == 0) {
                Arrays.sort(n);
                for (int i = n.length-1; i >= 0; i--)
                    System.out.print(n[i]);
                System.out.println();
                return;
            }
        }

        System.out.println(-1);
    }
}