package Programmers.Hyeon.lv3;

import java.util.ArrayDeque;

public class 단어_변환 {

    class Solution {
        String[] words;
        boolean[] visit;

        public int solution(String begin, String target, String[] words) {
            this.words = words;

            boolean contains = false;

            for (String w : words) {
                if (w.equals(target)) {
                    contains = true;
                    break;
                }
            }

            if (!contains) {
                return 0;
            }
            return bfs(begin, target);
        }

        int bfs(String begin, String target) {
            int N = words.length;
            visit = new boolean[N];

            ArrayDeque<String> queue = new ArrayDeque<>();
            queue.offer(begin);

            int level = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int s = 0; s < size; s++) {
                    String poll = queue.poll();

                    for (int i = 0; i < N; i++) {
                        if (!visit[i] && canConvert(poll, words[i])) {
                            if (words[i].equals(target)) {
                                return level + 1;
                            }
                            queue.offer(words[i]);
                            visit[i] = true;
                        }
                    }
                }
                level++;
            }
            return 0;
        }

        boolean canConvert(String s1, String s2) {
            int diff = 0;

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diff++;
                }
                if (diff >= 2) {
                    return false;
                }
            }
            return diff == 1;
        }
    }
}
// lv3 단어 변환 BFS
// 26분
// 일단 문제가 최단거리를 물었다. 그리고 주어진 문자와 최종 문자열을 주고 둘이 같아지게 되는 과정에 대해서
// 걸리는 횟수를 물어봤기 때문에
// 이는 DFS 로도 가능하고 BFS 로도 가능하다고 생각 왜냐면 가중치가 없음.
// 하지만 DFS 는 가짓수에 따라 잘못하면 2^50개가 될 수 있다고 생각했다 뭐 최악을 가정한다면 words 의 원소 모두가
// 다음 가짓수라고 고려했을 때 근데
// 일단 그렇게 DFS 를 사용하면 값을 기억해서 비교해야된다 지나가는 경로를 기억할 필요가 없기 떄문에
// 그냥 값 가지고 큐를 사용하는 BFS를 사용했다
// 일단 방문여부를 가지는 visit 배열과 각 레벨 별 홍수 단계를 사이즈 즉 홍수 단계별로 차야 되기 때문에 level 변수로 쓴다
// words 에 target 이 없을 경우 탈출 조건으로 bfs 문을 돌린다
// 그리고 bfs 를 돌려서 각 자리를 비교해서 방문하지않고 차이가 1인 경우에 큐에 넣는데 이거를