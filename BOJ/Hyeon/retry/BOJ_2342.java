package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2342 {
    private final static int MAX = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            int dir = Integer.parseInt(st.nextToken());
            if (dir == 0) {
                break;
            }
            list.add(dir);
        }

        if (list.isEmpty()) {
            System.out.println(0);
            return;
        }

        int[][][] ddr = new int[list.size() + 1][5][5];
        for (int i = 0; i < ddr.length; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(ddr[i][j], MAX);
            }
        }
        ddr[0][0][0] = 0;

        for (int i = 0; i < list.size(); i++) {
            int dir = list.get(i);

            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (ddr[i][l][r] == MAX) {
                        continue;
                    }
                    if (dir != l) {
                        int cost = calculate(r, dir);
                        ddr[i + 1][l][dir] = Math.min(ddr[i + 1][l][dir], ddr[i][l][r] + cost);
                    }
                    if (dir != r) {
                        int cost = calculate(l, dir);
                        ddr[i + 1][dir][r] = Math.min(ddr[i + 1][dir][r], ddr[i][l][r] + cost);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (min > ddr[list.size()][i][j]) {
                    min = ddr[list.size()][i][j];
                }
            }
        }
        System.out.print(min);
    }

    private static int calculate(int prev, int dir) {
        if (dir == prev) {
            return 1;
        }
        if (prev == 0) {
            return 2;
        }
        if (Math.abs(prev - dir) == 2) {
            return 4;
        }
        return 3;
    }
}

// G3 Dance Dance Revolution DP
// 주어진 순서에 따라 왼쪽 오른쪽 발을 움직여서 최소 비용을 구한다 == DP 최적해
// 일단 입력처리 시 입력값이 0일때까지 입력받으니까 크기가 몰라서 ArrayList 로 받았고 그리고 list가 비었으면 0출력하고 끝낸다.
// 1. 상태 정의
// 그리고 dp 상태를 정의하는데 우리가 기억해야되는 정보가 몇번째 움직임인지, 오른쪽발의 위치, 왼쪽발의 위치 를 기억해야된다.
// 그래서 3차원으로 정의하고 나서 ddr[i][l][r] 으로 i번재 움직였을 때 왼쪽발의 위치와 오른쪽발의 위치 를 정의하고 값은 비용이다.
// 2. 바텀업을 통해서 0번째 스텝부터해서 순서에 따라서 dp를 채워나가는데 근데 최소값을 구하기에 10억정도로 dp 배열을 채운다
// 3. 점화식 i 번째 스텝일 때 이게 MAX가 아니면 다음 발의 위치를 알 수 있다. 왜냐하면 지금값 + cost 를 하면된다
// 왼발을 움직이는 경우 와 오른발을 움직이는 경우이다
// 그리고 비용계산은 절대값으로 쉽게 찾았다.
