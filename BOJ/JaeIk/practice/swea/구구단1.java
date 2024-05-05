package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구구단1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            boolean result = false;
            loop : for(int i=1; i<=9; i++){
                for(int j=1; j<=9; j++){
                    if(i*j == n){
                        result = true;
                        break loop;
                    }
                }
            }

            String r = (result)?"Yes":"No";

            System.out.println("#"+(tc+1)+" "+r);
        }
    }
}
