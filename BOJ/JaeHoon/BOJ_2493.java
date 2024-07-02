package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Building[] arr = new Building[N];
        int[] answer = new int[N];
        Stack<Building> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            arr[i] = new Building(i+1, Integer.parseInt(st.nextToken()));
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            while (!stack.isEmpty() && stack.peek().value < arr[i].value) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                sb.append("0 ");
            }else {
                sb.append(stack.peek().idx).append(" ");
            }
            stack.push(arr[i]);
        }

        System.out.println(sb);

    }
    static class Building {
        int idx;
        int value;

        public Building(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
