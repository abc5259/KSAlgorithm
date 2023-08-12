package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_23326 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        TreeSet<Integer> treeSet = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n == 1) treeSet.add(i);
        }

        StringBuffer sb = new StringBuffer();
        int pos = 0;
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                if(treeSet.contains(idx)) treeSet.remove(idx);
                else treeSet.add(idx);
            }
            else if(n == 2) {
                int x = Integer.parseInt(st.nextToken());
                pos = (pos + x) % N;
            }
            else if(n == 3) {
                if(!treeSet.isEmpty()) {
                    Integer lower = treeSet.ceiling(pos);
                    int first = treeSet.first();

                    if(lower == null) {
                        sb.append((N - pos + first)+"\n");
                    }else {
                        sb.append((lower - pos)+"\n");
                    }
                }else {
                    sb.append(-1+"\n");
                }

            }
        }
        System.out.println(sb);
    }
}
