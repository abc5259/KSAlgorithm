package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17420 {
    static int[] A;
    static int[] B;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr, (a,b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int prevMax = arr[0][1];
        int AMax = -1;

        for(int i=0; i<N; i++) {
            if(arr[i][0] < prevMax) {
                int cnt = (prevMax - arr[i][0] + 29) / 30;
                answer += cnt;
                arr[i][0] += cnt * 30;
            }

            AMax = Math.max(AMax,arr[i][0]);

            if(i + 1 < N && arr[i][1] != arr[i+1][1]) {
                prevMax = Math.max(AMax, arr[i+1][1]);
            }
        }

        System.out.println(answer);
    }
}
