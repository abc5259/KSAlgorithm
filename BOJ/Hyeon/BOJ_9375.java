package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (T-- > 0) {
            int j = Integer.parseInt(br.readLine());

            Map<String, Integer> cloth = new HashMap<>();
            while (j-- > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();
                cloth.put(category, cloth.getOrDefault(category, 0) + 1);
            }
            int res = 1;
            for (int cnt : cloth.values()) {
                res *= (cnt + 1);
            }
            sb.append(res - 1).append("\n");
        }
        System.out.println(sb);
    }
}

// S3 패션왕 신해빈 HashMap
// 일단 이거는 이항계수라고 생각하면된다. 무수히 많은 규칙을 찾으려 했지만
// 전체적으로 계산을 해봐야 안다. 예시로 1 2 3 4 라는건 15개이지만 1 2 1 2 는 8개 1 2 3 1 은 11개였다
// 이는 4C1 + 4C2 + 4C3 + 4C4까지를 더했을 때 중복을 제외하고 더해야되는거기 때문에
//
// 근데 보니까 1 2 3 4가 있을 때 1의 개수 * 2의 개수 * 3의 개수 * 4의 개수 -1(알몸) 이니까 15가 나오더라
// 그래서 Map 자료구조를 통해서 값들을 구한다음에 map.values() 를 통해 값들의 곱을 구해서 출력했다.