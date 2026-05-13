package Programmers.Hyeon.lv1;

public class 택배_상자_꺼내기 {
    class Solution {
        public int solution(int n, int w, int num) {

            int row = n / w;
            int[][] map = new int[row + 1][w];

            boolean right = true;
            int y = row, x = 0;

            int numY = -1, numX = -1;
            int tmp = 1;

            while (y >= 0) {
                if (right) {
                    for (int j = 0; j < w; j++) {
                        if (tmp == num) {
                            numY = y;
                            numX = x + j;
                        }
                        map[y][x + j] = tmp++;
                    }
                    x += w - 1;
                } else {
                    for (int j = 0; j < w; j++) {
                        if (tmp == num) {
                            numY = y;
                            numX = x - j;
                        }
                        map[y][x - j] = tmp++;
                    }
                    x -= w - 1;
                }
                right = !right;
                y -= 1;
            }

            int answer = 0;

            while (numY >= 0) {
                if (map[numY--][numX] <= n) {
                    answer++;
                } else {
                    break;
                }
            }

            return answer;
        }
    }
}
// lv1 2025 프로그래머스 코드챌린지 택배 상자 꺼내기 시뮬레이션
// 30분
// 2차원 배열에 상자에 번호를 다 써넣고 찾고자 하는 result 의 상자 좌표를 기억한 후
// y 좌표를 감소하며 이 값이 n보다 작거나 같은지 즉 판단하고 클경우 바로 break 해서 나옴
// n은 22까지 있고 w가 6이라면 우리 상자에 기록되는 마지막 수는 24 이기 때문에.