package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if(N == 0) break;

            int[] arr = new int[N];
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(arr, arr.length)).append("\n");
        }

        System.out.println(sb);


    }
    public static long getArea(int[] arr, int len) {

        Stack<Integer> stack = new Stack<Integer>();

        long maxArea = 0;

        for(int i = 0; i < len; i++) {

            while((!stack.isEmpty()) && arr[stack.peek()] >= arr[i]) {
                int height = arr[stack.pop()];	// 이전 체인의 높이

                long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                System.out.println("width = " + width);
                maxArea = Math.max(maxArea, height * width);	// 최대 넓이 값 갱신
            }

            stack.push(i);

        }
        while(!stack.isEmpty()) {
            int height = arr[stack.pop()];
            long width = stack.isEmpty() ? len: len - 1 - stack.peek();
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;

    }
}
