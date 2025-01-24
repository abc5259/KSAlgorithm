package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] buildings = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildings[i][0] = Integer.parseInt(st.nextToken());
            buildings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(buildings, (a,b) -> a[0] - b[0]);

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(int i=0; i<N; i++) {
            int y = buildings[i][1];
            if(stack.isEmpty()) {
                if(y != 0) stack.push(y);
            }
            else if(stack.peek() < y) {
                stack.push(y);
            }
            else if(stack.peek() > y) {
                while (!stack.isEmpty() && stack.peek() > y) {
                    stack.pop();
                    cnt++;
                }
                if(y != 0) {
                    if(stack.isEmpty()) stack.push(y);
                    else if(stack.peek() != y) stack.push(y);
                }
            }
        }
        cnt += stack.size();
        System.out.println(cnt);
    }
}
