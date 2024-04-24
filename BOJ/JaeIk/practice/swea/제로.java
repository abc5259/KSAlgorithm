package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int k = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<k; i++){
                int newNumber = Integer.parseInt(br.readLine());

                if(newNumber==0 && !stack.empty()){
                    stack.pop();
                    continue;
                }

                stack.add(newNumber);
            }

            int answer = 0;
            for(int i : stack){
                answer += i;
            }

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}
