package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int f,b,val;

    Node(int f, int b, int val){
        this.f = f;
        this.b = b;
        this.val = val;
    }


    @Override
    public int compareTo(Node a) {
        int val = a.val;

        if(this.val > val)return 1;
        else return -1;
    }
}

public class BOJ_1197 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();

        parent = new int[v+1];

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a,b,c));
        }

        Collections.sort(list);

        int sum = 0;
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        for(Node n : list){
            int A = n.f;
            int B = n.b;
            int val = n.val;

            if(find(A)==find(B))continue;
            sum += val;
            union(A,B);
        }

        System.out.println(sum);
    }

    static int find(int F) {
        if(parent[F] == F)return F;
        else return find(parent[F]);
    }

    static void union(int F, int B){
        int a = find(F); int b = find(B);

        if(a!=b)parent[b] = a;
    }
}
