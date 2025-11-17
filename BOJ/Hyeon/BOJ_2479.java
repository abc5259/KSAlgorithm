package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2479 {
    static int N, K;
    static String[] arr;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = br.readLine();
        }
        num = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        if (!bfs(A, B)) {
            System.out.println(-1);
        } else {
            while (B != 0) {
                sb.insert(0, B + " ");
                B = num[B];
            }
        }
        System.out.println(sb);
    }

    static boolean bfs(int A, int B) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(A);
        Arrays.fill(num, -1);
        // 방문 여부
        num[A] = 0;

        while (!queue.isEmpty()) {
            int curIdx = queue.poll();

            if (curIdx == B) {
                return true;
            }

            String curStr = arr[curIdx];

            for (int nextIdx = 1; nextIdx <= N; nextIdx++) {
                if (num[nextIdx] == -1) {
                    int cnt = 0;
                    for (int i = 0; i < K; i++) {
                        if (curStr.charAt(i) != arr[nextIdx].charAt(i)) {
                            cnt++;
                        }
                    }
                    if (cnt != 1) {
                        continue;
                    }
                    queue.offer(nextIdx);
                    num[nextIdx] = curIdx;
                }
            }
        }
        return false;
    }
}
// G4 경로 찾기 BFS 역추적
// 1시간 10분
// 쓸데 없이 너무 오래걸린 문제 같다
// 하나도 안 어려웠는데 역추적과 인덱스 관리 등 내가 못하는게 꽤 많았고 문제를 잘 못 이해하고 시작하기도 했음
// dfs 로 하면 경로 찾는게 더 쉽지 않을까? 역추적 없이 라고 생각하기도 했고
// bfs 로 하면 내가 가다가 답없는 경로로 갔을 때 걔로 하면안되니까 따로 경로를 저장할 역추적 배열을 선언했다
// 그런데 queue 에 인덱스도 같이 넣을까 했는데 이도 좀 이상한게 큐에서 나오면 따로 저장해서 관리하질못하니,,
// 그래서 헷갈리다가 방문 여부는 set 으로 해서 contains 로 빨리 할 수 잇었는데
// 그냥 num 만써서 방문 여부를 했었어야 햇나 싶기도 하다.

// 개선점
// 일단 내가 고민한대로 방문여부는 num으로 처리하면서 역추적도 같이했고 Queue에 String 이 아니라
// 인덱스를 넣어서 굳이 반복 탐색으로 안하게끔 하였다
// 또 역추적을 할때 -1 로 초기화 된 역추적 배열에서 0이 아닐때까지로 해서 출력문을 개선했다.