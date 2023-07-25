package BOJ.JaeIk;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2565 {
    static int[][] wire;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //첫번째 원소가 연결된 두 와이어의 지점, 두 번째 원소가 a와 b전봇대
        wire = new int[n][2];
        dp = new Integer[n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 원소(A전봇대)를 기준으로 오름차순으로 정렬
        Arrays.sort(wire, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        int max=0;

        for(int i=0; i<n; i++){
            recur(i);
        }

        for(int i=0; i<n; i++){
            if(max<dp[i])max=dp[i];
        }

        //전선 갯수 - 설치 가능 갯수
        System.out.println(n-max);
    }

    static int recur(int n){
        if(dp[n]==null){
            dp[n] = 1;

            for(int i= n+1; i<dp.length; i++){
                if(wire[n][1] < wire[i][1]){
                    //recur(i)에 +1 반드시 해줘야한다
                    dp[n] = Math.max(dp[n], recur(i)+1);
                }
            }
        }
        return dp[n];
    }
}
