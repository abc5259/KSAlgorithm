package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int L = 0;
        int R = N-1;
        int num = 1000000000;
        int[] answer = new int[2];
        while (L < R) {
            int n = arr[L] + arr[R];
            if(Math.abs(n) < num) {
                answer[0] = arr[L];
                answer[1] = arr[R];
                num = Math.abs(n);
            }
            if(n == 0) break;
            else if(n < 0) {
                L++;
            }else {
                R--;
            }


        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
