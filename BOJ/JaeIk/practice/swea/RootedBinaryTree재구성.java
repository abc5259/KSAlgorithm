package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RootedBinaryTree재구성 {
    static int[] newTree;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int level = Integer.parseInt(br.readLine());

            int length = (int)Math.pow(2, level);
            tree = new int[length];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<tree.length; i++){
                tree[i] = Integer.parseInt(st.nextToken());
            }

            newTree = new int[length];
            recursive(1, length-1, 1);


            System.out.print("#"+(tc+1)+" ");
            for(int i=1; i<= newTree.length/2; i*=2){
                for(int j=i; j<i+i; j++){
                    System.out.print(newTree[j]+" ");
                }
                System.out.println();
            }
        }
    }

    static void recursive(int left, int right, int idx){
        int root = (left + right)/2;
        newTree[idx] = tree[root];

        if(left==right)return;

        recursive(left, root-1, idx*2);
        recursive(root+1, right, idx*2+1);
    }
}
