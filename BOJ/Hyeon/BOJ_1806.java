package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int sum = 0;

//        while (start < end && end <= N) {
        while (end <= N) {

            if (sum >= S) {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            } else {
                if (end == N) {
                    break;
                }
                sum += arr[end++];
            }
        }
        System.out.print(min == Integer.MAX_VALUE ? 0 : min);
    }
}
// G4 부분합 슬라이딩 윈도우, 투포인터
// 일단 내가 푼 방식은 투 포인터를 구현하는 것과 다름이 없었다.
// 기존 풀이는 일단 한칸 채우고 시작하는 접근을 했다 start = 0이고 end 는 1로 해서 첫번째 원소를 포함 한 상태에서 탐색했다
// cnt 를 통해서 길이를 카운팅 했었고
// 루프 조건을 start < end 로 하다보니 end가 AOB 에러때문에 end <= N 조건도 확인했다
// 내부에는 합이 S를 넘었을 때 start 를 줄이기 위해 while(start < end - 2) 라는 반복문을 하나 더 중첩했다
// 포인터를 수동으로 움직이는 구현이었다
//
// refactor
// 일단 start 랑 end 모두 0에서 시작해서 원소를 동일한 로직에서 처리한다
// 길이는 필요할 때 계산한다 cnt 변수없이 end - start 하면된다
// while 은 end가 N까지 가고 N을 초과하면 멈춘다 이는 내가 end <= 와 같다.
// 그리고 while 반복문으 ㄹ빼고 그냥 if 조건 분기로해서 반복하게 했다.
