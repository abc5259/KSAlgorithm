package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;

        Deque<Task> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int part = Integer.parseInt(st.nextToken());

            if (part == 0) {
                if (!stack.isEmpty()) {
                    Task pop = stack.peek();
                    pop.time--;
                    
                    if (pop.time == 0) {
                        sum += pop.score;
                        stack.pop();
                    }
                }
            } else {
                int tmpScore = Integer.parseInt(st.nextToken());
                int tmpTime = Integer.parseInt(st.nextToken());

                if (tmpTime == 1) {
                    sum += tmpScore;
                } else {
                    stack.push(new Task(tmpScore, tmpTime - 1));
                }
            }
        }

        System.out.println(sum);
    }

    static class Task {
        int score;
        int time;

        Task(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
// S3 과제는 끝나지 않아! 스택
// 12분
// 시간복잡도는 N이 100만인데 스택의 경우 pop 과 push peek 등 O(1) 이기 떄문에 시간적으로 문제없다고 판단.
// 일단 많은 조건을 통해서 관리하면된다 과제를 Task 라는 객체로 빼서
// 현재의 과제의 time 이 1이면 바로 지금 과제를 처리해서 sum 에 더해버리고 아니라면 -1 한다음에 스택에 넣는다
// 그다음 분에 과제가 없다면 그 과제를 꺼내서 다시 처리하면 되는 구현이고
// 과제가 있다면 스택은 냅두고 새로 받은 과제를 처리해서 스택에 넣는 구조이다 즉
// 최근에 나온 순서대로 한다는 문제와 과제가 끝나면 이전 과제를 이어서 할 수 있다라는건 순서를 기억해야되는거고
// 역순으로 하기 떄문에 Stack 이라고 생각했다.