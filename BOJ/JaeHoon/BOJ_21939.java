package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21939 {
    static class Problem {
        int p, l;
        Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
    static int N, M;
    static PriorityQueue<Problem> upPq;
    static PriorityQueue<Problem> downPq;
    static Map<Integer, Integer> removedMap;
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        removedMap = new HashMap<>();
        map = new HashMap<>();
        upPq = new PriorityQueue<>((a,b) -> {
            if(a.l == b.l) return b.p - a.p;
            return b.l - a.l;
        });
        downPq = new PriorityQueue<>((a,b) -> {
            if(a.l == b.l) return a.p - b.p;
            return a.l - b.l;
        });
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(p, l);
            upPq.offer(problem);
            downPq.offer(problem);
            map.put(p, l);
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            if(query.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(p, l);
                upPq.offer(problem);
                downPq.offer(problem);
                map.put(p, l);
            }
            else if(query.equals("recommend")) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    while (removedMap.containsKey(upPq.peek().p) && removedMap.get(upPq.peek().p) == upPq.peek().l) {
                        upPq.poll();
                    }
                    sb.append(upPq.peek().p).append("\n");
                }
                else if(num == -1) {
                    while (removedMap.containsKey(downPq.peek().p) && removedMap.get(downPq.peek().p) == downPq.peek().l) {
                        downPq.poll();
                    }
                    sb.append(downPq.peek().p).append("\n");
                }
            }
            else if(query.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                removedMap.put(p, map.get(p));
                map.remove(p);
            }
        }

        System.out.println(sb);
    }
}
