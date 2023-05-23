package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    static class Node {
        Node left;
        Node right;
        int num;

        public Node(int num) {
            this.num = num;
        }

        void insert(int num) {
            if(num < this.num) {
                if(this.left == null) {
                    this.left = new Node(num);
                }else {
                    this.left.insert(num);
                }
            }else {
                if(this.right == null) {
                    this.right = new Node(num);
                }else {
                    this.right.insert(num);
                }
            }
        }
    }
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String input;
        while(true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;

            int num = Integer.parseInt(input);

            root.insert(num);
        }

        postorder(root);
        System.out.println(sb);
    }
    public static void postorder(Node node) {
        if(node.left != null) postorder(node.left);
        if(node.right != null) postorder(node.right);
        sb.append(node.num + "\n");
    }
}
