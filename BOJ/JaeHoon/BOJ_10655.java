package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int[][] arr2 = new int[N-1][2];
        for(int i=0; i<N-1; i++) {
            arr2[i][0] = Math.abs(arr[i][0] - arr[i+1][0]) + Math.abs(arr[i][1] - arr[i+1][1]);
            sum += arr2[i][0];
            if(i + 2 < N) {
                arr2[i][1] = Math.abs(arr[i][0] - arr[i+2][0]) + Math.abs(arr[i][1] - arr[i+2][1]);
            }
        }

        int min = sum;
        for(int i=1; i<N-1; i++) {
            int temp = sum;
            temp -= arr2[i-1][0] + arr2[i][0];
            temp += arr2[i-1][1];
            min = Math.min(temp, min);
        }
        System.out.println(min);
    }
}
