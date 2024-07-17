/**
 * 2852 - NBA 농구 [실패]
 * 실버3, 구현
 * 
 * 골을 넣는 팀과 시간이 차례로 입력될 때,
 * 처음 골을 넣은 팀 이후부터 이기는 팀의 이전 시간과의 차이를 계속해서 이기는 팀 시간합에 더한다.
 * 그럼 나중에 다른 팀이 역전해도 누적으로 시간을 더해왔기 때문에 따로 계산할 필요없이 그 합이 이긴 시간이 되는 것이다.
 * 처음 골을 넣은 팀 이후부터 이기는 팀의 시간 차이를 저장하는 이유는 처음 골을 넣어야 그 팀이 이기는 팀이 되기 때문이다.
 * 즉, 00:00에 시작하여 01:00에 골을 넣었다면, 00:00 ~ 01:00은 아무도 이기지 않고 있던 시간이므로 01:00부터 다음 골까지의 시간 차이를 계산해주는 것.
 *
 * 시간의 차이를 계속 누적한다는 아이디어가 떠오르지 않아 풀지 못했던 문제였다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2852 {
    // 골이 들어갈 때마다 골이 들어간 시간, 팀을 적음.
    // 농구경기는 정확히 48분 진행. 각 팀이 몇 분동안 이기고 있었는가?

    static int changeToSec(String s) {
        return (Integer.parseInt(s.split(":")[0]) * 60) + Integer.parseInt(s.split(":")[1]);
    }

    static String changeToFormat(int s) {
        int min = s / 60;
        int sec = s % 60;

        return (String.format("%02d", min) + ":" + String.format("%02d", sec));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String prev = "";

        int oneTeam = 0;
        int twoTeam = 0;
        int oneScore = 0;
        int twoScore = 0;
        for (int i = 0; i < N; i++) {
            String[] goal = br.readLine().split(" ");
            int team = Integer.parseInt(goal[0]);

            if (oneScore > twoScore) oneTeam += changeToSec(goal[1]) - changeToSec(prev);
            else if (oneScore < twoScore) twoTeam += changeToSec(goal[1]) - changeToSec(prev);
            if (team == 1) oneScore++;
            else twoScore++;

            prev = goal[1];
        }

        if (oneScore > twoScore) oneTeam += changeToSec("48:00") - changeToSec(prev);
        else if (oneScore < twoScore) twoTeam += changeToSec("48:00") - changeToSec(prev);
        
        System.out.println(changeToFormat(oneTeam));
        System.out.println(changeToFormat(twoTeam));
    }
}
