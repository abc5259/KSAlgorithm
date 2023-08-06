package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Ant> antSortList = new ArrayList<>();
            List<Integer> failList = new ArrayList<>();
            Deque<Integer> deque = new ArrayDeque<>();
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());

                deque.add(a);
                if(a > 0) {
                    antSortList.add(new Ant(a,L - p));
                }else {
                    antSortList.add(new Ant(a,p));
                }
            }

            Collections.sort(antSortList,(a,b) -> {
                if(a.dist == b.dist) return a.id - b.id;
                return a.dist - b.dist;
            });

            for(int i=0; i<N; i++) {

                int front = deque.peekFirst();
                int back = deque.peekLast();

                if(i != N-1 && antSortList.get(i).dist == antSortList.get(i+1).dist) {

                    if(front > back) {
                        failList.add(back);
                        failList.add(front);
                    }else {
                        failList.add(front);
                        failList.add(back);
                    }

                    deque.pollFirst();
                    deque.pollLast();
                    i++;
                }
                else if(antSortList.get(i).id > 0) {
                    deque.pollLast();
                    failList.add(back);
                }else {
                    deque.pollFirst();
                    failList.add(front);
                }
            }

            sb.append(failList.get(K-1)+"\n");
        }
        System.out.println(sb);
    }
    static class Ant {
        int id,dist;

        public Ant(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

}
