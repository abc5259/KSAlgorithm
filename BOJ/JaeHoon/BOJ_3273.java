package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = 0;
        int L = 0;
        int R = N-1;
        while (L < R) {
            if(arr[L] + arr[R] == X) {
                answer++;
                R--;
                L++;
            }
            else if(arr[L] + arr[R] > X) {
                R--;
            }else {
                L++;
            }
        }
        System.out.println(answer);
    }
}
