package Programmers.Hyeon.lv1;

public class 최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {

            int maxLarge = 0;
            int maxSmall = 0;

            for (int[] size : sizes) {

                int w = size[0];
                int h = size[1];

                int large = Math.max(w, h);
                int small = Math.min(w, h);

                maxLarge = Math.max(maxLarge, large);
                maxSmall = Math.max(maxSmall, small);
            }
            return maxLarge * maxSmall;
        }
    }
}
// lv1 최소직사각형 완전탐색
// 15분
// 프로그래머스 적응 중
// 코테 환경에서의 Solution 클래스의 매개변수 입력값 적응
// 그냥 완탐으로 하고 값 비교해서 구현