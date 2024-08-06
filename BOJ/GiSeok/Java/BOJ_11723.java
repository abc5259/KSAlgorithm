/**
 * 11723 - 집합 [성공|00:47:08]
 * 실버5, 비트마스킹, 시도11
 * 
 * System.out.println 때문에 시간초과 났다.
 * 억울하다..
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11723 {
    // 시간제한 1.5초, 메모리제한 4MB
    // 비어있는 공집합 S
    // add x : S에 x 추가 (1 <= x <= 20)

    static int s = 0;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char op = st.nextToken().charAt(1);
            int x = 0;

            if (op != 'l' && op != 'm') {
                x = Integer.parseInt(st.nextToken());

                if (op == 'd')
                    s |= (1 << x);
                else if (op == 'e')
                    s &= ~(1 << x);
                else if (op == 'o')
                    s ^= (1 << x);
                else if (op == 'h') { bw.write((s & (1 << x)) >= 1 ? '1' : '0'); bw.newLine(); }
            } 
            else if (op == 'm')
                s = 0;
            else if (op == 'l')
                s = (1 << 21) - 1;
        }

        bw.flush();
        bw.close();
    }
}
