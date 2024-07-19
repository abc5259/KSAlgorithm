/**
 * 17298 - 오큰수 [성공|00:59:21]
 * 골드4, 스택, 시도6
 */
package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {
    // 수열 A = A1, A2, ..., An이 있다.
    // 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구함.
    // Ai의 오큰수는 Ai보다 오른쪽에 있으면서 큰 수 중에서 가장 왼쪽에 있는 수
    
    // 시간제한 1초
    // 단순하게 Ai의 오큰수는 A(i+1)부터 끝까지 탐색하며 큰 수가 나오면 stop
    // 이 로직은 최악의 경우 수열이 10만부터 내림차순으로 10만개 있을 경우 10만 * 10만 = 100억
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] seq = new int[N+1];
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());

            while (!stk.isEmpty() && seq[stk.peek()] < seq[i])
                seq[stk.pop()] = seq[i];

            stk.push(i);
        }

        while (!stk.isEmpty())
            seq[stk.pop()] = -1;
        
        for (int i = 1; i <= N; i++)
            bw.write(seq[i] + " ");
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
