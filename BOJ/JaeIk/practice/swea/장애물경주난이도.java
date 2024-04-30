package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장애물경주난이도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            int min = 0;
            for(int i=1; i<n; i++){
                //올라갈 때
                if(arr[i] >= arr[i-1]){
                    max = Math.max(max, arr[i]-arr[i-1]);
                }

                //내려갈 때
                if(arr[i] <= arr[i-1]){
                    min = Math.max(min, arr[i-1]-arr[i]);
                }
            }

            System.out.println("#"+(tc+1)+" "+max+" "+min);
        }
    }
}
