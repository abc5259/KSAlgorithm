package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2457 {
    static int[] monthDays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] plants = new int[N][2];
        int[] sum = new int[13];
        for(int i=1; i<13; i++) {
            sum[i] = sum[i-1] + monthDays[i];
        }
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());

            int endM = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            plants[i][0] = sum[startM-1] + startDay;
            plants[i][1] = sum[endM-1] + endDay;
        }

        Arrays.sort(plants, (a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });


        int start = sum[2] + 1;

        int max = -1;

        int count = 0;
        for(int i=0; i<N; i++) {
            if(plants[i][0] <= start && start < plants[i][1]) {
                max = Math.max(max, plants[i][1]);
            }
            else if(start >= plants[i][1]) {
                continue;
            }
            else {
                if(max == -1) {
                    System.out.println(0);
                    return;
                }

                count++;
                if(max > sum[10] + 30) {
                    System.out.println(count);
                    return;
                }
                start = max;
                max = -1;
                if(plants[i][0] <= start && start < plants[i][1]) {
                    max = plants[i][1];
                }
            }
        }

        if(max == -1) {
            System.out.println(0);
            return;
        }

        count++;
        System.out.println(max > sum[10] + 30 ? count : 0);
    }
}