package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int max1 = 0;
        int idx1 = 0;
        int max2 = 0;
        int idx2 = 0;

        List<Integer> point = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            point.add(len);

            if (dir < 3) {
                if (max1 < len) {
                    max1 = len;
                    idx1 = i;
                }
            } else {
                if (max2 < len) {
                    max2 = len;
                    idx2 = i;
                }
            }
        }

        int min1 = point.get((idx1 + 3) % 6);
        int min2 = point.get((idx2 + 3) % 6);

        int area = max1 * max2 - (min1 * min2);
        System.out.println(area * K);
    }
}
// S2 참외밭 수학
// 1시간
// 움푹 패여져있는 공간의 길이를 어떻게 아나 했다 처음엔 가장 작은 2변인줄알았고 그다음은
// 가장 긴것도 되고 1개만 작고 이게 다양한 경우의 수가 있었다
// 그래서 어떻게 해야 구하지 싶었는데 가장 긴 변보다 3칸 뒤에 있대 각각
// 그래서 이걸 인덱스화 시키기 위해서 어레이 리스트를 쓴다음
// 가로와 세로의 가장 긴변의 인덱스와 값을 기억해두고 그걸 통해서 연산했다.