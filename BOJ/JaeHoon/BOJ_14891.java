package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14891 {
    static int[][] arr;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[4][8];
        for(int i=0; i<4; i++) {
            String s = br.readLine();
            for(int j=0; j<s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            int[] solve = solve(index, d);
            for(int i=0; i<4; i++) {
                if(solve[i] == 0) continue;
                rotate(i, solve[i]);
            }
        }

        int result = 0;
        int[] score = {1,2,4,8};
        for(int i=0; i<4; i++) {
            result += arr[i][0] == 0 ? 0 : score[i];
        }
        System.out.println(result);
    }

    public static int[] solve(int index, int d) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{index, d});
        int[] state = new int[4];
        state[index] = d;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] > 0 && state[cur[0] - 1] == 0) {
                if(arr[cur[0] - 1][2] != arr[cur[0]][6]) {
                    state[cur[0] - 1] = cur[1] == -1 ? 1 : -1;
                    q.offer(new int[]{cur[0]-1, state[cur[0] - 1]});
                }
            }
            if(cur[0] < 3 && state[cur[0] + 1] == 0) {
                if(arr[cur[0] + 1][6] != arr[cur[0]][2]) {
                    state[cur[0] + 1] = cur[1] == -1 ? 1 : -1;
                    q.offer(new int[]{cur[0]+1, state[cur[0] + 1]});
                }
            }
        }
        return state;
    }

    private static void rotate(int index, int d) {
        if(d == 1) { // 시계방향
            int temp = arr[index][7];
            for(int i=7; i>=1; i--) {
                arr[index][i] = arr[index][i-1];
            }
            arr[index][0] = temp;
        } else {
            int temp = arr[index][0];
            for(int i=0; i<7; i++) {
                arr[index][i] = arr[index][i+1];
            }
            arr[index][7] = temp;
        }
    }
}
