package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            List<Integer> boxes = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                boxes.add(r * c);
            }

            boxes.sort(Collections.reverseOrder());

            int cnt = 0;
            for (int capacity : boxes) {
                J -= capacity;
                cnt++;
                if (J <= 0) {
                    break;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
// S5 사탕 정렬
// 7분
// 쉽게 풀었다
// 일단 T 는 10 J, N 은 1000이라서 시간 복잡도는 O(10 * N log N)이었다.
// 내림차순으로 사탕의 크기를 담을 수 있는 상자를 구하고 이를 현재 담아야하는 J에서 차감하면서
// 그리디로 접근해서 이가 break 될경우의 idx +1 은 박스로 출력하면된다.
// 배열리스트로 조회가 빠르게 고려함.
// 개선된 풀이 For each 로 배열에 접근해서 차감하는 방식으로 cnt 를 리턴 굳이 idx 로 할필요가 없었다.