package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2613 {
    static int N,M;
    static int[] arr;
    static int minGroupCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int low = 0;
        int high = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i <N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            low = Math.max(low, arr[i]); 	// 구슬 합의 최소 범위
            high += arr[i]; 					// 구슬 합의 최대 범위
        }
        low -=1;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if(check(mid)) {
                high = mid;
            }else {
                low = mid;
            }
        }

        StringBuffer sb = new StringBuffer();

        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > high) { 	// 만약 구슬 합이 최댓값보다 크면
                M--;			// 묶음이 하나 만들어진 것이므로 M--;
                sum = arr[i];
                sb.append(cnt).append(" "); // 현재 구슬 수를 sb에 추가
                cnt = 1; 					// 다시 구슬 수를 1로 카운트
            } else {
                cnt++;
            }

            if(M == N - i) break; // 묶음 수가 1인 경우를 세어 주기 위해
        }

        // 현재 M == (남은 묶음 수) 이므로
        // 구슬이 다 묶일 때까지 M--;
        while(M-- > 0) {
            // 위에 for문에서 최댓값에 도달하지 못한 합의 구슬 수를 먼저 추가
            sb.append(cnt).append(" ");
            // 그 다음은 다 1씩 묶음이므로
            cnt = 1;
        }
        System.out.println(high);
        System.out.println(sb);
    }
    public static boolean check(int target) {
        int sum = 0;
        int groupCnt = 1;
        for(int i=0; i<N; i++) {
            sum += arr[i];
            if(sum > target) {
//                if(sum - arr[i] == 0) return false;
                groupCnt++;
                sum = arr[i];
            }
        }

        if(groupCnt <= M) minGroupCnt = groupCnt;
        return groupCnt <= M;
    }
}
//5 5
//1 1 1 1 1

//6 4
//1 1 1 4 1 1 1

//4 4
//3 1 1 1

//3
//1 3
//9 6
//1 1 1 1 1 1 1 1 1
//9 9
//1 1 1 1 1 1 1 1 1

