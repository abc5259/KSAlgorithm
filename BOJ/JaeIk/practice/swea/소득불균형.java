package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소득불균형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int average=0;
            for(int i=0; i<arr.length; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                average += arr[i];
            }
            average /= n;

            int result = 0;
            for(int i=0; i<n; i++){
                if(arr[i] <= average)result++;
            }

            System.out.println("#"+(tc+1)+" "+result);

        }
    }
}
