package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stk = new Stack<>();
        
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N+1; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        stk.push(N);
        for (int i = N-1; i > 0; i--) {
            int past = stk.peek();

            if (numbers[i] < numbers[past]) {
                stk.push(i);
            } else {
                while (!stk.isEmpty() && numbers[i] > numbers[stk.peek()])
                    numbers[stk.pop()] = i;
                stk.push(i);
            }
        }

        while (!stk.isEmpty())
            numbers[stk.pop()] = 0;

        for (int i = 1; i < N+1; i++)
            System.out.print(numbers[i] + " ");
        System.out.println();
    }
}