package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class BOJ_2870 {

    public static void main(String[] args) throws IOException {
        //02:04
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String s = br.readLine();

            String n = "";
            for(int j=0; j<s.length(); j++) {
                if('a' <= s.charAt(j) && s.charAt(j) <= 'z') {
                    if(!n.equals("")) {
                        pq.add(new BigInteger(n));
                        n = "";
                    }
                    continue;
                }

                n += s.charAt(j);
            }
            if(!n.equals("")) {
                pq.add(new BigInteger(n));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append('\n');
        }
        System.out.print(sb);
    }
}
