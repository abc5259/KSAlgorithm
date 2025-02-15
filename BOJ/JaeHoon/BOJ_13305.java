package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dist = new int[N-1];
        for(int i=0; i<N-1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1;
        long sum = 0;
        while (right < N) {
            if(arr[left] <= arr[right]) {
                right++;
            }
            else if(arr[left] > arr[right]) {
                for(int i=left; i<right; i++) {
                    sum += (long) arr[left] * dist[i];
                }
                left = right;
                right++;
            }
            else { // 같다면
                right++;
            }
        }
        if(left < N-1) {
            for(int i=left; i<N-1; i++) {
                sum += (long) arr[left] * dist[i];
            }
        }
        System.out.println(sum);
    }
}
