package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다솔이의월급상자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            double result=0;
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                double p = Double.parseDouble(st.nextToken());
                double x = Double.parseDouble(st.nextToken());

                result += p*x;
            }

            System.out.printf("#%d %.6f", tc+1, result);
        }
    }
}
