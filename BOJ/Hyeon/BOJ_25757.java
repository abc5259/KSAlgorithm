package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String game = st.nextToken();

        Set<String> gamer = new HashSet<>();

        while (N-- > 0) {
            gamer.add(br.readLine());
        }
        int cnt;

        if (game.equals("Y")) {
            cnt = gamer.size();
        } else if (game.equals("F")) {
            cnt = gamer.size() / 2;
        } else {
            cnt = gamer.size() / 3;
        }

        System.out.println(cnt);
    }
}
// S5 임스와 함께하는 미니게임 HashSet
// 5분
// 그냥 중복 허용 안 하고 갯수를 세어 반환하는 문제
// N이 시간복잡도 10만 이기에 이에 대해서 O(1) 로 접근할 수 있어야 했고 size O(1) 그리고
// O(N * 1)으로 삽입 switch 보다 if 가 더 시간적으로 적절해서 사용했다.