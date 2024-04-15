package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    
    static int[] op = new int[4];
    static int[] seq;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            seq[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            op[i] = Integer.parseInt(st.nextToken());


        cal(1, seq[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void cal(int idx, int num) {

        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--; 
                switch (i) {
                    case 0:
                        cal(idx + 1, num + seq[idx]);
                        break;
                    case 1:
                        cal(idx + 1, num - seq[idx]);
                        break;
                    case 2:
                        cal(idx + 1, num * seq[idx]);
                        break;
                    case 3:
                        cal(idx + 1, num / seq[idx]);
                        break;
                }

                op[i]++;
            }
        }
    }
}
