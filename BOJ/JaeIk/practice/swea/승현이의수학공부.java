package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 승현이의수학공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[] x = st.nextToken().toCharArray();

            long decimal = 0;
            for(int i=x.length-1; i>=0; i--){
                decimal += Character.getNumericValue(x[i]);
            }

            System.out.println("#"+(tc+1)+" "+decimal%(n-1));
        }
    }
}
