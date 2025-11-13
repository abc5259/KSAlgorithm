package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }
            HashSet<Integer> sang = new HashSet<>();

            for (int i = 0; i < N; i++) {
                sang.add(Integer.parseInt(br.readLine()));
            }

            HashSet<Integer> young = new HashSet<>();

            for (int i = 0; i < M; i++) {
                young.add(Integer.parseInt(br.readLine()));
            }

            HashSet<Integer> total = new HashSet<>();
            for (int i : sang) {
                if (young.contains(i)) {
                    total.add(i);
                }
            }
            sb.append(total.size()).append("\n");
        }
        System.out.println(sb);
    }
}
// S5 CD HashSet
// 10분
// 일단 입출력 조건이 별 불친절해서 헤매긴 했는데 최근에 푼 그리디랑 비슷해서 이렇게
// HashSet 써서 풀었다. contains 를 통해 둘다 가지고 있는 CD 를 찾는 HashSet을 만들고
// 이를 이용해서 size로 답을 구한다
// N과 M이 백만이고 값은 10억 이내라서 큰 문제가 없이 시간 복잡도와 공간복잡도 문제가 없었다.