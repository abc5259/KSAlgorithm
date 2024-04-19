package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int a = T / 300;
        T %= 300;

        int b = T / 60;
        T %= 60;

        int c = T / 10;
        T %= 10;

        if (T != 0) System.out.println(-1);
        else System.out.println(a + " " + b + " " + c);
    }
}
