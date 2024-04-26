package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홀수피라미드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            long n = Long.parseLong(br.readLine());

            long b = n*n;
            long a = b - 2*(n-1);

            b = b*2-1;
            a = a*2-1;

            System.out.println("#"+(tc+1)+" "+a+" "+b);
        }
    }
}
