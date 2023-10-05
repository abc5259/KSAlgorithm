package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class _Node implements Comparable<_Node>{
    int a; int b; int val;

    _Node(int a, int b, int val){
        this.a = a; this.b = b; this.val = val;
    }


    @Override
    public int compareTo(_Node o) {
        int val = o.val;

        if(this.val > val)return 1;
        else return -1;
    }
}

public class BOJ_1992 {
    static int[] parent;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        List<_Node> list = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list.add(new _Node(a,b,val));
        }

        Collections.sort(list);

        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }

        for(_Node n : list){
            int A = n.a;
        }


    }

    static int find(int a){
        if(parent[a] == a)return a;
        else return find(parent[a]);
    }

    static void union(int a, int b){
        int A = find(a); int B = find(b);

        if(A!=B)parent[B] = A;
    }
}
