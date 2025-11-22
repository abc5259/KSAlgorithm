package Programmers.Hyeon.lv3;

import java.util.Arrays;
import java.util.Comparator;

public class 여행경로 {

    class Solution {
        String[][] tickets;
        int[] visit;

        public String[] solution(String[][] tickets) {
            this.tickets = tickets;
            visit = new int[tickets.length];
            Arrays.fill(visit, -1);

            Arrays.sort(tickets, new Comparator<>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    if (o1[0].equals(o2[0])) {
                        return o1[1].compareTo(o2[1]);
                    }
                    return o1[0].compareTo(o2[0]);
                }
            });

            dfs("ICN", 0);
            String[] answer = new String[tickets.length + 1];
            answer[0] = "ICN";

            int tmp = 1;
            for (int idx : visit) {
                answer[tmp++] = tickets[idx][1];
            }
            return answer;
        }

        void dfs(String start, int depth) {

            if (depth == tickets.length) {
                return;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (start.equals(tickets[i][0])) {
                    for (int var : visit) {
                        if (var == i) {
                            continue;
                        }
                        visit[depth] = i;
                        dfs(tickets[i][1], depth + 1);
                    }

                }
            }
        }
    }
}
// lv3 여행경로 DFS
// 50분
// 일단 visit 를 할 때 depth 순서대로 ticket 만큼의 크기에다가
// 방문 한 티켓의 인덱스를 저장한다 이때
// 내가 끝가지 가지못하는 상황에서 돌아오면 다시 그 인덱스 자리에 다음 숫자를 대입해서 백트래킹을 명시적으로 안 해도,
// DFS가 depth를 채우지 못하면 자연스럽게 이전 재귀 호출의 for문으로 돌아가서
// 다음 선택지를 시도한다.
// visit[depth] = -1을 안 해도 되는 이유:
// 어차피 visit[depth]는 그 depth가 다시 실행될 때 덮어씌워지므로 복원할 필요가 없다.