package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1765 {
    static int N,M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;

        ArrayList<Integer>[] enemyList = new ArrayList[N+1];
        for(int i=0; i<=N; i++) enemyList[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if(c == 'F') {
                union(v1,v2);
            }
            else if(c == 'E') {
                enemyList[v1].add(v2);
                enemyList[v2].add(v1);
            }
        }

        for(int i=1; i<=N; i++) {
            if(!enemyList[i].isEmpty()) {
                for (int enemy : enemyList[i]) {
                    for (int friend : enemyList[enemy]) {
                        union(i,friend);
                    }
                }
            }
        }

        Set<Integer> team = new HashSet<>();
        for(int i=1; i<=N; i++) {
            team.add(find(i));
        }

        System.out.println(team.size());
    }
    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a <= b) {
            parents[b] = a;
        }else {
            parents[a] = b;
        }
    }


}
