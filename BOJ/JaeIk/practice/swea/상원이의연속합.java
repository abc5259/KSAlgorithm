package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 상원이의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            int count = 0;
            for(int i=1; i<=n; i++){
                int sum = 0;

                for(int j=i; j<=n; j++){
                    sum += j;
                    if(sum > n)break;

                    if(sum == n){
                        count++;
                        break;
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+count);
        }
    }
}
