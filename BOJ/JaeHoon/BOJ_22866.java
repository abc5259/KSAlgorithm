package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_22866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Building> stack = new Stack<>();
        int[][] answer = new int[N][2];
        int[][] answer2 = new int[N][2];

        for(int i=0; i<N; i++) {
            while (!stack.isEmpty() && stack.peek().h <= arr[i]) {
                stack.pop();
            }

            answer[i][0] = stack.size();
            answer[i][1] = !stack.isEmpty() ? stack.peek().index : Integer.MAX_VALUE;

            stack.push(new Building(i, arr[i]));
        }

        Stack<Building> stack2 = new Stack<>();
        for(int i=N-1; i>=0; i--) {
            while (!stack2.isEmpty() && stack2.peek().h <= arr[i]) {
                stack2.pop();
            }

            answer2[i][0] = stack2.size();
            answer2[i][1] = !stack2.isEmpty() ? stack2.peek().index : Integer.MAX_VALUE;

            stack2.push(new Building(i, arr[i]));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
//            System.out.println("i = " + i  + " " + Arrays.toString(answer[i]) + " " + Arrays.toString(answer2[i]));
            int sum = answer[i][0] + answer2[i][0];
            sb.append(sum);

            if(sum > 0) {
                sb.append(" ");
                int a = Math.abs(i - answer[i][1]);
                int b = Math.abs(i - answer2[i][1]);
                if(a <= b) {
                    sb.append(answer[i][1] + 1);
                }else {
                    sb.append(answer2[i][1] + 1);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
    static class Building {
        int index, h;

        public Building(int index, int h) {
            this.index = index;
            this.h = h;
        }
    }
}
