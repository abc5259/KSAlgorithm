package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 현주의상자바꾸기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] arr = new int[n+1];
            Arrays.fill(arr, 0);

            for(int i=1; i<=q; i++){
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                for(int j=l; j<=r; j++){
                    arr[j] = i;
                }
            }

            System.out.print("#"+(tc+1)+" ");
            for(int i=1; i<=n; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
