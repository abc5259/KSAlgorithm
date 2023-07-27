package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    static int[] W;
    static int[] V;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        W = new int[n];
        V = new int[n];

        //배열의 0이 아닌 1번째 부터 채운다
        dp = new Integer[n][k+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(n-1,k));

    }

    static int knapsack(int i, int k){
        if(i<0){
            return 0;
        }


        if(dp[i][k]==null){

            //현재 물건(i)을 추가로 못담는 경우 (이전 i값 탐색)
            //예를 들어 i=3 dp=3일 때는 3번째의 가치 6을 가진다
            //하지만 i=4일 때 4번째 무게가 5이므로 갱신을 못하고 이전값을 그대로 가진다
            if(W[i] > k) {
                dp[i][k] = knapsack(i - 1, k);
            }
            // 현재 물건(i)을 담을 수 있는 경우
            else {
                //이전 i값과 이전 i값에 대한 k-W[i]의 값, 현재 가치(V[i])중 큰 값을 저장
                //i일 때의 무게가 k보다 커서 가치를 갱신하지 못할 때의 이전 값
                //i=4일 때 knapsack(3, k-이전까지의 최대가치) + 4번째의 가치
                //둘 중에 큰 것을 구한다
                dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - W[i]) + V[i]);
            }
        }
        return dp[i][k];
    }
}
