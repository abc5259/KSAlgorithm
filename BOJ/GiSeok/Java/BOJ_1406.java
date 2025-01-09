/**
 * [S2 구현] 에디터 - O, 00:12:33
 * 시도3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(br.readLine());
        int cursor = sb.length();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            if (cmd == 'L') {
                if (cursor > 0) cursor--;
            } else if (cmd == 'D') {
                if (cursor < sb.length()) cursor++;
            } else if (cmd == 'B') {
                if (cursor > 0) {
                    sb.delete(cursor - 1, cursor);
                    cursor--;
                }
            } else {
                String ch = st.nextToken();
                sb.insert(cursor, ch);
                cursor++;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
