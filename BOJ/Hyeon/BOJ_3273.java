package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        boolean[] possible = new boolean[x];

        for (int val : arr) {
            if (x > val) {
                possible[val] = true;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= x / 2; i++) {
            if (i == x - i) {
                continue;
            }
            if (possible[i] && possible[x - i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
// S3 두 수의 합 배열 조회
// 14분
// 일단 나는 투 포인터로 푸려다가 만약 start 랑 end 를 더했는데 이게 x 보다 크면 start 를 키울지 end 를 낮출지
// 선택하는데 어렵더라고
// 내가 풀어 나간 방식은 일단 n 이 10만이야 그래서 n 에 대한 정렬을 했을 때 최악이면 시간초과겠다 싶었어
// 그래서 정렬을 꺼리고
// x가 200만 까지라해서 그럼 O(1) 로 접근가능하게 불리언으로 쓸가해서
// 먼저 n 개의 입력값을 받고 이는 모두 다 다른 양수니까 이 수중에서 x 보다 작은것들만
// 내가 가능한거니까 체크 해두고
// 또 x의 절반까지만 확인하면 되고 6이 x 일때 3 과 3이 되지않게 같은 경우를 제외하고
// 두개의 값을 투 포인터처럼 했는데 우리가 흔히아는 while 의 투포인터 개념은 아니게 풀었다.