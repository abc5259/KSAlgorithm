package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] bench = br.readLine().toCharArray();
        boolean[] eat = new boolean[N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (bench[i] == 'H') {
                continue;
            }

            int start = Math.max(i - K, 0);
            int end = Math.min(i + K, N - 1);

            for (int j = start; j <= end; j++) {
                if (i == j) {
                    continue;
                }
                if (bench[j] == 'H' && !eat[j]) {
                    eat[j] = true;
                    sum++;
                    break;
                }
            }
        }
        System.out.print(sum);
    }
}
// S3 햄버거 분배 그리디
// 일단 내가 생각하기에 가져야 되는 상태
// 1. 먼저 주어진 햄버거와 사람의 입력값
// 2. 그 입력값을 통해 구하고자 하는 사람의 최대 수
// 3. 근데 햄버거를 먹었는지 안먹었는지에 대한 여부
// 그래서 이 3개를 통해 입력값과 수를 2차원 문자 배열을 통해 입력받고 '1'을 입력해서 갯수를 세고
// visit 을 통해 방문 여부를 검증 그리고나서
// i-K 와 i+K 에 대한 범위를 통해 반복문을 만들어서 i==j 는 건너뛰고 그 범위내에 햄버거이고 방문 안했으면
// 증가하고 방문처리 하는거로 했다.

// 개선
// 근데 그냥 방문여부를 안보고 햄버거를먹었는지 여부의 개수만 세면되잖아 굳이 2차원안하고..?
// 왜냐하면 방문 여부 의 개수랑 그냥 '1'이랑 같았을 테니까... 그래서 1차원 배열로 바꾸고 visit 도 eat으로 바꿈