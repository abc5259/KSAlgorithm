/* 
BaekJoon - 17298 오큰수 (05/03 화)

스택에 순차적으로 인덱스를 push하는데, 다음 인덱스 내용이 더 크다면 스택 내에 큰 인덱스 내용보다 작은 인덱스들을 pop하여
pop한 인덱스 내용을 큰 인덱스 내용으로 바꿔준다.

더 큰 인덱스가 없다면 그 인덱스 내용은 -1로 바꿈
*/
package BOJ.GiSeok.Java;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stk = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            while (!stk.empty() && sequence[stk.peek()] < sequence[i])
                sequence[stk.pop()] = sequence[i];
            stk.push(i);
        }

        while (!stk.empty())
            sequence[stk.pop()] = -1;
        for (int i = 0; i < N; i++) {
            bw.write(sequence[i] + " ");
        }
        
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}