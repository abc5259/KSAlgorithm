package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        Arrays.fill(arr, 1);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<S; i++) {
            arr[Integer.parseInt(st.nextToken())-1]--;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++) {
            arr[Integer.parseInt(st.nextToken())-1]++;
        }

        for(int i=0; i<N; i++) {
            if(arr[i] == 2) {
                if(i-1 >= 0 && arr[i-1] == 0) {
                    arr[i-1] = 1;
                    arr[i] = 1;
                }
                else if(i + 1 < N && arr[i+1] == 0) {
                    arr[i+1] = 1;
                    arr[i] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(arr[i] == 0) cnt++;
        }
        System.out.println(cnt);
    }
}
