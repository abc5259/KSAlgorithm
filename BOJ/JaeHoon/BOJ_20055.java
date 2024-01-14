package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20055 {
    static int N,K;
    static int[] belt;
    static boolean[] isUsed;
    static Queue<Integer> robotQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2*N];
        isUsed = new boolean[2*N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        do {
            answer++;
            rotate();
            moveRobot();
            raiseRobot();
        }while (!isGameOver());

        System.out.println(answer);
    }

    public static void raiseRobot() {
        if(belt[0] != 0) {
            belt[0] -= 1;
            isUsed[0] = true;
            robotQ.offer(0);
        }
    }

    public static void rotate() {
        int temp = belt[belt.length - 1];
        for(int i=2*N-1; i>=1; i--) {
            belt[i] = belt[i-1];
        }

        belt[0] = temp;

        int size = robotQ.size();
        for(int i=0; i<size; i++) {
            int curr = robotQ.poll();
            int next = (curr + 1) % (2*N);

            isUsed[curr] = false;
            isUsed[next] = true;
            if(next == N - 1) {
                isUsed[next] = false;
            }else {
                robotQ.offer(next);
            }
        }
    }

    public static void moveRobot() {
        Queue<Integer> q = new LinkedList<>();

        while (!robotQ.isEmpty()) {
            int curr = robotQ.poll();
            int next = (curr + 1) % (2*N);

            if(belt[next] < 1 || isUsed[next]) {
                // 못감
                q.offer(curr);
            }else {
                // 갈 수 있음
                isUsed[curr] = false;
                isUsed[next] = true;
                belt[next] -= 1;
                if(next == N - 1) { // 내리는 곳이라면 로봇 내리기
                    isUsed[next] = false;
                }else {
                    q.offer(next);
                }
            }
        }

        robotQ = q;
    }

    public static boolean isGameOver() {
        int sum = 0;
        for(int i=0; i<2*N; i++) {
            if(belt[i] == 0) sum++;
        }

        return K <= sum;
    }
}
