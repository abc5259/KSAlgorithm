package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2564 {
    static int C, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(br.readLine());

        List<int[]> call = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            call.add(new int[]{dir, dis});
        }

        st = new StringTokenizer(br.readLine());

        int curDir = Integer.parseInt(st.nextToken());
        int curDis = Integer.parseInt(st.nextToken());

        int curPos = getPos(curDir, curDis);

        int res = 0;

        for (int i = 0; i < s; i++) {
            int[] tmp = call.get(i);

            int dir = tmp[0];
            int dis = tmp[1];
            int pos = getPos(dir, dis);

            int one = Math.abs(curPos - pos);
            int min = Math.min(one, 2 * (R + C) - one);
            res += min;
        }
        System.out.println(res);
    }

    static int getPos(int dir, int dis) {
        if (dir == 1) {
            return dis;
        } else if (dir == 4) {
            return C + dis;
        } else if (dir == 2) {
            return C + R + C - dis;
        } else {
            return C + R + C + R - dis;
        }
    }
}
// S1 경비원 시뮬레이션, 조건 분기
// 50분
// 와,,, 이거는 진짜 너무 많은 조건에 대해서 구하다가 시간 다 지나가서 찾아봤더니 한줄로 이어서 절대값 연산으로
// 구하는 수식이었다 방향 별로 시작해서 시계 방향, 반대 방향에 대한 절대값과 둘레 - 절대값으로 비교
// 처음에는 내 방향별로 거리들을 모두 연산해서 하려고 했는데..
// 접근 방법
// 테두리 위에서만 움직인다 == 더이상 좌표 평면이 아니다 왜? 그냥 테두리에서만 움직이기에 직선과 같다
// 시작점과 끝점이 만나는 사이클은 원과 같다 두 지점의 최단거리는 시계와 반시계 뿐이다.