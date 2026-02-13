package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1063 {
    static Map<String, Integer> dirMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] dir = {"T", "RT", "R", "RB", "B", "LB", "L", "LT"};

        for (int i = 0; i < 8; i++) {
            dirMap.put(dir[i], i);
        }

        String king = st.nextToken();
        int kingX = king.charAt(0) - 'A';
        int kingY = king.charAt(1) - '1';

        String stone = st.nextToken();

        int stoneX = stone.charAt(0) - 'A';
        int stoneY = stone.charAt(1) - '1';

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String com = br.readLine();

            int d = dirMap.get(com);

            int nkx = kingX + dx[d];
            int nky = kingY + dy[d];

            if (nkx < 0 || nky < 0 || nkx > 7 || nky > 7) {
                continue;
            }

            if (nkx == stoneX && nky == stoneY) {

                int nsx = stoneX + dx[d];
                int nsy = stoneY + dy[d];

                if (nsx < 0 || nsy < 0 || nsx > 7 || nsy > 7) {
                    continue;
                }

                stoneX = nsx;
                stoneY = nsy;
            }
            kingX = nkx;
            kingY = nky;
        }

        System.out.println(String.valueOf((char) (kingX + 'A')) + (kingY + 1) + "\n" +
                (char) (stoneX + 'A') + (stoneY + 1));
    }

    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
}
// 킹 S3 구현
// 35분
// 아니 문제가 너무 더러웠다.
// 일단 좌표에 대해서 접근하는 방식이랑 또 charAt 해서 추출하는거 또 이를 좌표로 바꿔서 연산하는거는
// 그냥 N 과 8 번 반복하면됏었다.
// 그리고 탈출 조건 고려해서 하면된다.
// 리팩토링
// Map 자료구조를 통해서 굳이 O(8) 으로 인한 dir 탐색을 안하고 그냥 Map 에다가 넣어두고
// com 에 대한것을 O(1) 로 접근해서 가져와서 불필요한 반복문 줄이기.