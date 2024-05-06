package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계산기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());


            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = Integer.parseInt(st.nextToken());
            for(int i=1; i<n; i++){
                int number = Integer.parseInt(st.nextToken());

                result = Math.max(result*number, result+number);
            }

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
