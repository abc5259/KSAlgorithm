package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Integer[] ship = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            ship[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ship, Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        Integer[] boxArr = new Integer[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            boxArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(boxArr,Collections.reverseOrder());


        if(boxArr[M-1] > ship[0]) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        int loadCnt = 0;
        boolean[] isLoad = new boolean[M];
        Loop: while (loadCnt < M) {
            time++;
            int shipIdx = 0;
            for(int i=0; i<M; i++) {
                if(shipIdx >= N) continue Loop;
                if(isLoad[i]) continue;

                if(ship[shipIdx] >= boxArr[i]) {
                    isLoad[i] = true;
                    shipIdx++;
                    loadCnt++;
                }
            }
        }

        System.out.println(time);
    }
}
