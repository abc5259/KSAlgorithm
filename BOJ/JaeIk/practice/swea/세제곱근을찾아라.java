package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세제곱근을찾아라 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            long n = Long.parseLong(br.readLine());

            long result = 0;
            for(long i=1; ; i++){
                long x = i*i*i;

                if(x>n)break;
                if(x==n) {
                    result=i;
                    break;
                }
            }

            result = (result>0)?result:-1;

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
