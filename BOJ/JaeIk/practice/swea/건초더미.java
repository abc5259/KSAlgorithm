package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 건초더미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            int sum = 0;
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(br.readLine());
                sum += arr[i];
            }
            int avg = sum/n;

            int result = 0;
            for(int i=0; i<n; i++){
                result += Math.abs(arr[i]-avg);
            }
            result /= 2;

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
