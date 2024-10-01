package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int v = Integer.parseInt(st.nextToken());
            if(v < 0) {
                minus.add(-v);
            }else {
                plus.add(v);
            }
        }

        Collections.sort(plus);
        Collections.sort(minus);

        if(plus.isEmpty()) {
            int sum = minus.get(minus.size() - 1);
            int next = minus.size() - 1 - M;
            while (next >= 0) {
                sum += (minus.get(next) * 2);
                next -= M;
            }
            System.out.println(sum);
        }
        else if(minus.isEmpty()) {
            int sum = plus.get(plus.size() - 1);
            int next = plus.size() - 1 - M;
            while (next >= 0) {
                sum += (plus.get(next) * 2);
                next -= M;
            }
            System.out.println(sum);
        }
        else {
            if(minus.get(minus.size() - 1) >= plus.get(plus.size() - 1)) {
                int sum = 0;
                int next = plus.size() - 1;
                while (next >= 0) {
                    sum += (plus.get(next) * 2);
                    next -= M;
                }

                sum += minus.get(minus.size() - 1);
                next = minus.size() - 1 - M;
                while (next >= 0) {
                    sum += (minus.get(next) * 2);
                    next -= M;
                }
                System.out.println(sum);

            }else {
                int sum = 0;
                int next = minus.size() - 1;
                while (next >= 0) {
                    sum += (minus.get(next) * 2);
                    next -= M;
                }

                sum += plus.get(plus.size() - 1);
                next = plus.size() - 1 - M;
                while (next >= 0) {
                    sum += (plus.get(next) * 2);
                    next -= M;
                }
                System.out.println(sum);
            }
        }
    }
}
