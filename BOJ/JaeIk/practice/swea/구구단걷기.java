package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구구단걷기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            long n = Long.parseLong(br.readLine());

            long length  = (long) Math.sqrt(n);

            long min = 1000000000001L;
            for(int i=1; i<=length; i++){
                if(n%i==0){
                    long div = n/i;

                    min = Math.min((i-1) + (div-1), min);
                }
            }

            System.out.println("#"+(tc+1)+" "+min);
        }
    }
}

