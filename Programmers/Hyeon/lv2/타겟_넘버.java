package Programmers.Hyeon.lv2;

public class 타겟_넘버 {
    class Solution {
        int answer;
        int[] numbers;
        int target;

        public int solution(int[] numbers, int target) {
            this.numbers = numbers;
            this.target = target;

            dfs(0, 0);

            return answer;
        }

        public void dfs(int idx, int sum) {
            if (idx == numbers.length) {
                if (sum == target) {
                    answer++;
                }
                return;
            }

            dfs(idx + 1, sum + numbers[idx]);

            dfs(idx + 1, sum - numbers[idx]);
        }
    }
}
// lv2 타겟 넘버 DFS
// 30분
// 최종적인 리턴 값 answer 를 두고
// 현재 인덱스 와 현재까지의 합을 가정하는 2개의 매개변수를 활용한 dfs 를 활용
// 더할지 뺄지니까 2지선다라서 반복문 없이 2개의 dfs 를 계속 하고
// 기저 조건을 걸어서 탈출시킬 때 검사만 하면된다.