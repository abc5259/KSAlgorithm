package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Cost implements Comparable<Cost>{
    int n, cost, max;

    public Cost(int n, int cost){
        this.n = n;
        this.cost = cost;
    }

    public Cost(int n, int cost, int max){
        this.n = n;
        this.cost = cost;
        this.max = max;
    }

    @Override
    public int compareTo(Cost o) {
        if(cost == o.cost)return n - o.n;
        return cost - o.cost;
    }
}

public class BOJ_20182 {
    static int[] min;
    static int N, M, A, B, C;
    static List<List<Cost>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        min = new int[N+1];
        Arrays.fill(min, Integer.MAX_VALUE);

        for(int i=0; i<=N; i++)map.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map.get(a).add(new Cost(b,c));
            map.get(b).add(new Cost(a,c));
        }

        PriorityQueue<Cost> pq = new PriorityQueue<>();

        boolean [] visited = new boolean[N+1];

        pq.add(new Cost(A, 0, Integer.MIN_VALUE));

        while(!pq.isEmpty()){
            Cost cur = pq.poll();
            if(visited[cur.n] || cur.n == B) continue;
            visited[cur.n] = true;

            for(Cost next : map.get(cur.n))
            {
                int totalCost = cur.cost + next.cost;
                if(visited[next.n] || totalCost > C) continue;
                int curMax = cur.max;
                if(curMax < next.cost)
                {
                    curMax = next.cost;
                }
                if(min[next.n] > curMax) min[next.n] = curMax;
                pq.add(new Cost(next.n,totalCost,curMax));
            }
        }
        int answer = min[B] != Integer.MAX_VALUE ? min[B] : -1;
        System.out.println(answer);
    }
}
