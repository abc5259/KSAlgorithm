package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 준홍이의카드놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int max = 0;
            int[] arr = new int[41];
            for(int i=1; i<=n; i++) {
                for (int j = 1; j<=m; j++) {
                    arr[i + j]++;
                    max = Math.max(max, arr[i + j]);
                }
            }

            System.out.print("#"+(tc+1)+" ");
            for(int i=0; i< arr.length; i++){
                if(max == arr[i]){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
    }
}
