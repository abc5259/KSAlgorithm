package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int N;
    static boolean[] isVisited;
    static boolean[] isUsed;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        isVisited = new boolean[N+1];
        isUsed = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<cnt; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        divide(1);
        System.out.println(min == Integer.MAX_VALUE ? - 1 : min);
    }

    private static void divide(int idx) { // 1. 선거구 나누기
        if (idx == N + 1) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (isUsed[i])
                    aList.add(i);
                else
                    bList.add(i);
            }
            if (aList.size() == 0 || bList.size() == 0) // 한 지역에 몰빵 X
                return;

            if (check(aList) && check(bList)) { // 두 구역이 각각 연결되었는지 확인
                getPeopleDiff();
            }
            return;
        }

        isUsed[idx] = true;
        divide(idx + 1);
        isUsed[idx] = false;
        divide(idx + 1);

    }

    private static boolean check(List<Integer> list) {

        Queue<Integer> q = new LinkedList<>();
        isVisited = new boolean[N+1];
        isVisited[list.get(0)] = true;
        q.offer(list.get(0));

        int count = 1; // 방문한 지역 개수
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next: graph.get(cur)) {
                if(list.contains(next) && !isVisited[next]) {
                    q.offer(next);
                    isVisited[next] = true;
                    count++;
                }
            }
        }

        if(count==list.size()) // 선거구에 해당하는 지역수와 방문한 지역수가 같은 경우
            return true;
        else
            return false;
    }


    private static void getPeopleDiff() { // 3. 선거구의 인구 차 구하기
        // a구역 사람수
        int pA = 0, pB = 0;
        for (int i = 1; i <= N; i++) {
            if (isUsed[i])
                pA += arr[i];
            else
                pB += arr[i];
        }
        int diff = Math.abs(pA - pB);
        min = Math.min(min, diff);
    }
}

