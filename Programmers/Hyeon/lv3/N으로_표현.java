package Programmers.Hyeon.lv3;

import java.util.HashSet;

public class N으로_표현 {
    class Solution {
        public int solution(int N, int number) {
            HashSet<Integer>[] dp = new HashSet[9];

            for (int i = 1; i < 9; i++) {
                dp[i] = new HashSet<>();
            }

            for (int i = 1; i < 9; i++) {
                dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));

                for (int j = 1; j < i; j++) {

                    for (int start : dp[j]) {
                        for (int end : dp[i - j]) {
                            dp[i].add(end * start);
                            dp[i].add(end + start);
                            dp[i].add(end - start);
                            if (start != 0) {
                                dp[i].add(end / start);
                            }
                        }
                    }
                }
                if (dp[i].contains(number)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
// lv3 N으로 표현 DP
// 1시간 5분
// 와 진짜 어렵다 이거 충격적이고 신선한 문제
// 일단 개수에 따른 DP 였다 왜냐하면 1개 쓰면 N이고 2개 쓰면 NN으로 쓸 수 있어서 이를 고려할 때
// 개수에 따른 DP로 만들었고 또 이때 만약 1개에서 2를 만들었는데 3개에서 2를 만들경우 굳이 3개에 넣을 필요없이 1개에서
// 쓴거를 사용하면 되기에 중복이 없어야 됐다 그래서
// HashSet 을 고민했는데 이걸로 배열을 만들고 add 해버리면 됐다
// 그래서 String의 repeat 메소드를 통해서 NNNN 과 같은 수를 4 에 대입할 수 있었고
// 사칙 연산 또한 dp[i] 에 dp[j] + [i-j] 이런식으로 점화식이 가져간다고 생각하면 되었다
// 그래서 먼저 찾는게 해당 자릿수에 먼저라서 SET 으로 하고
// 사칙 연산 입력 후 해당 set dp[i] 에 찾고자 하는 number 가 있는지 검사하고
// dp[i].contains 로 해결해서 리턴했다.