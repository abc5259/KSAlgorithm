package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] height = new int[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        String[][] blocks = {
                {},
                {"0", "0000"}, // 1번
                {"00"}, // 2번
                {"001", "10"}, // 3번
                {"100", "01"}, // 4번
                {"000", "01", "10", "101"}, // 5번
                {"000", "00", "011", "20"}, // 6번
                {"000", "00", "02", "110"} // 7번
        };

        int cnt = 0;

        for (String block : blocks[P]) {
            int len = block.length();
            for (int i = 0; i <= C - len; i++) {
                boolean isValid = true;
                for (int j = 0; j < len - 1; j++) {
                    if (height[i + j] - block.charAt(j) != height[i + j + 1] - block.charAt(j + 1)) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}
// G5 테트리스 브루트포스
// 잘 생각해보자 일단 C와 P로 값을 입력받고
// int 배열을 만든다 이는 바닥의 높이를 나타낸다
// 그리고 각 블록들이 회전해서 나타날 수 있는 모든 경우의 수를 적고 이는 바닥과의 차이를 기준으로 만든다
// 문자열 배열을 만든다음 P에 해당하는 문자열 배열을 선택해서 해당 1차원 문자열 배열을 반복해서 완전탐색한다.
// 일단 블록의 길이를 구한다음 블록의 길이만큼빼서 반복해야되고 무조건 통과라는 플래그를 만들고
// block 과 height 가 양쪽으로 차이가 같으면 딱 맞춰지니까 -1 만큼 해서 반복시키고
// 양옆을 비교한다. 근데 1개라도 다르면 플래그를 false로 하고 break 하고
// 다 통과되면 true로 1씩 증가시킨다.