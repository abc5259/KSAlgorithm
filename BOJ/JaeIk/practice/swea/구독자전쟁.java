package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구독자전쟁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = 0;
            int max = 0;
            if(a+b < n){
                min = 0;
                max = Math.min(a, b);
            }else if(a+b >= n){
                if(a==b && b==n){
                    min = n;
                    max = n;
                }else if(n==a || n==b){
                    min = Math.min(a, b);
                    max = Math.min(a, b);
                }else{
                    min = Math.abs(a+b-n);
                    max = Math.min(a, b);
                }
            }

            System.out.println("#"+(tc+1)+" "+max+" "+min);
        }
    }
}
