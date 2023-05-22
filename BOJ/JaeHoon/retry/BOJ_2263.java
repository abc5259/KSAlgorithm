package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2263 {
    static int N;
    static int[] inorder;
    static int[] postorder;
    static int[] inorderIndex;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        inorder = new int[N];
        postorder = new int[N];
        inorderIndex = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
            inorderIndex[inorder[i]] = i;
        }
        preorder(0,N-1,0,N-1);
        System.out.println(sb);
    }
    public static void preorder(int in_start,int in_end,int p_start,int p_end) {
        if(in_start > in_end || p_start > p_end) {
            return;
        }

        int rootNode = postorder[p_end];
        sb.append(rootNode + " ");

        int rootIndex = inorderIndex[rootNode];
        int leftNodeLength = rootIndex - in_start;

        preorder(in_start,rootIndex-1,p_start,p_start+leftNodeLength-1);

        preorder(rootIndex+1, in_end, p_start+leftNodeLength, p_end-1);
    }
}
