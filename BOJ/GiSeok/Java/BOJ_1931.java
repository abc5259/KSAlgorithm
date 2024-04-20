package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] meeting = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] time = br.readLine().split(" ");

            meeting[i][0] = Integer.parseInt(time[0]);
            meeting[i][1] = Integer.parseInt(time[1]);
        }

        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] !=  o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int ans = 0;
        int done = 0;
        for (int i = 0; i < N; i++) {
            if (meeting[i][0] >= done) {
                done = meeting[i][1];
                ans++;
            }
        }

        System.out.println(ans);
    }
}
