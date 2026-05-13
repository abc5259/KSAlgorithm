package Programmers.Hyeon.lv1;

public class 택배_상자_꺼내기_1 {
    class Solution {
        public int solution(int n, int w, int num) {

            int row = (num - 1) / w;
            int col = (num - 1) % w;

            if (row % 2 == 1) {
                col = w - 1 - col;
            }

            int topRow = (n - 1) / w;
            int topCol = (n - 1) % w;

            if (topRow % 2 == 1) {
                topCol = w - 1 - topCol;
            }

            int answer = topRow - row;

            if (topRow % 2 == 0) {
                if (col <= topCol) {
                    answer++;
                }
            } else {
                if (col >= topCol) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
// lv1 2025 프로그래머스 코드챌린지 택배 상자 꺼내기 수학
// 30분
// 또 다른 풀이로 이거는 내가 찾고자하는 좌표와 맨 끝의 좌표를 구한다음
// 행 단위로 차이를 내서 중간에 있는 상자들을 구하고 마지막 상자의 위치에 따라
// 이 상자가 내 머리 위보다 더 많이 갔는지 적게 갔는지를 방향에 따라 구분해야한다.
// 그래서 짝수행이라면 오른쪽 방향이라서 찾고자 하는 col 보다 크거나 같아야 하고
// 홀수행이라면 col 보다 작거나 같아야 한다.