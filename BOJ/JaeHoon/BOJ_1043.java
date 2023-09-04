package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043 {
    static int N,M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;

        st = new StringTokenizer(br.readLine());
        int trueCnt = Integer.parseInt(st.nextToken());
        for(int i=0; i<trueCnt; i++) {
            parents[Integer.parseInt(st.nextToken())] = 0;
        }

        ArrayList<Integer>[] partyList = new ArrayList[M];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            partyList[i] = new ArrayList<>();
            partyList[i].add(Integer.parseInt(st.nextToken()));
            for(int j=1; j<cnt; j++) {
                partyList[i].add(Integer.parseInt(st.nextToken()));
                union(partyList[i].get(j-1),partyList[i].get(j));
            }
        }

        int answer = 0;

        for(int i=0; i<M; i++) {
            boolean isOk = true;
            for(int idx:partyList[i]) {
                if(find(idx) == 0) {
                    isOk = false;
                    break;
                }
            }

            if(isOk) answer++;
        }

        System.out.println(answer);
    }
    public static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a <= b) {
            parents[b] = a;
        }else {
            parents[a] = b;
        }
    }
}
