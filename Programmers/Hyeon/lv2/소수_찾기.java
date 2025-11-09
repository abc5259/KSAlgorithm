package Programmers.Hyeon.lv2;

import java.util.HashSet;

public class 소수_찾기 {

    class Solution {
        HashSet<Integer> numberSet = new HashSet<>();
        char[] nums;
        boolean[] visit;

        public int solution(String numbers) {

            nums = numbers.toCharArray();
            visit = new boolean[nums.length];

            dfs("");

            int answer = 0;

            for (int n : numberSet) {
                if (isPrime(n)) {
                    answer++;
                }
            }
            return answer;
        }

        public boolean isPrime(int n) {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return n > 1;
        }

        public void dfs(String currentNum) {
            for (int i = 0; i < nums.length; i++) {
                if (!visit[i]) {
                    String newNumber = currentNum + nums[i];

                    numberSet.add(Integer.parseInt(newNumber));
                    visit[i] = true;

                    dfs(newNumber);

                    visit[i] = false;
                }
            }
        }
    }
}
// lv2 소수 찾기 DFS, 백트래킹
// 40분
// 문제를 dfs 랑 백트래킹으로 접근하는데 너무 애를 썻다
// hasNext 나 PriorityQueue 등을 조합등을 고려했는데 dfs 랑 백트래킹 풀이 를 추천받았고
// 숫자를 "" 에다가 문자를 더하면서 이를 문자열로 가져가는 방식과 Integer.parseInt 가 0이 앞에와도 해결해준다
// 그리고 중복방지를 위해 Set 을 사용하며
// isPrime 으로 소수조건을 검사하고 그 갯수를 리턴한다.