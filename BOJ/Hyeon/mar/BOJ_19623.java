package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
        }
    }

    static class meeting implements Comparable<meeting> {
        int start;
        int end;
        int man;

        public meeting(int start, int end, int man) {
            this.start = start;
            this.end = end;
            this.man = man;
        }

        @Override
        public int compareTo(meeting o) {
            if (this.man == o.man) {
                if (this.end == o.end) {
                    return this.start - o.start;
                }
                return this.end - o.end;
            }
            return this.man - o.man;
        }
    }
}
