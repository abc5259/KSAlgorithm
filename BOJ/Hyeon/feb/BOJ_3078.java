package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer>[] queue = new ArrayDeque[21];
        for (int i = 2; i < 21; i++) {
            queue[i] = new ArrayDeque<>();
        }

        long res = 0;

        for (int i = 0; i < N; i++) {
            int len = br.readLine().length();
            while (!queue[len].isEmpty() && i - queue[len].peek() > K) {
                queue[len].poll();
            }
            res += queue[len].size();

            queue[len].offer(i);
        }
        System.out.println(res);
    }
}
// 시간 초과 발생 -> 큐에서 탐색을 할 때는 인덱스로 하지말고 직접 접근 하도록
// G4 좋은 친구 큐
// 처음에 큐라고 판단하고 큐에다가 인덱스와 길이를 넣어서 인덱스를 제한으로 두고 길이가 같을 때의 수를 구하려 했지만
// 이렇게하면 이중 반복이 된다. 그래서 O(N * K) 이기 때문에 시간초과가 발생했다.

// 그렇다면 같을 때의 수를 어떻게 구하냐?
// 똑같이 while 반복문의 비었을 때와 큐에다가 인덱스를 푸시할 때 인덱스에서 큐의 가장 앞인 peek의 값을 뺏을 때 K보다 큰 경우는
// 좋은 친구의 조건이 아니기 때문에 이때 peek를 빼면된다== peek에는 더이상 좋은친구가 생길 수 없기 때문
// 슬라이딩 윈도우
// 그래서 빼고 나면 이름의 길이 배열 큐에 사이즈만큼 누적해서 더해준다.