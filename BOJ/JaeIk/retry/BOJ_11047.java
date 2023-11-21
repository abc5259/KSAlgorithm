package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_11047 {
    static int count = 0;
    static int[] unit;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        unit = new int[n];
        for(int i=0; i<n; i++){
            unit[i] = Integer.parseInt(br.readLine());
        }


        for(int i=n-1; i>=0; i--){
            if(k==0)break;

            if(k%unit[i] >= 0){
                count += (k/unit[i]);
                k = k%unit[i];
            }
        }

        System.out.println(count);
    }
}
