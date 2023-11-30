package Programmers.JaeHoon.level3;

import java.util.*;

public class 표_편집 {

    class Solution {
        class Node {
            boolean isRemoved;
            Node prev;
            Node next;
        }
        public String solution(int n, int k, String[] cmd) {
            Node[] nodeArr = new Node[n];

            for(int i=0; i<n; i++) {
                nodeArr[i] = new Node();
            }
            for(int i=1; i<n; i++) {
                nodeArr[i-1].next = nodeArr[i];
                nodeArr[i].prev = nodeArr[i-1];
            }

            Stack<Node> stack = new Stack<>();
            Node currNode = nodeArr[k];
            for(String s: cmd) {
                if(s.length() > 1) {
                    String[] arr = s.split(" ");
                    int x = Integer.parseInt(arr[1]);
                    if(arr[0].equals("U")) {
                        for(int i=0; i<x; i++) {
                            currNode = currNode.prev;
                        }
                    }
                    else if(arr[0].equals("D")) {
                        for(int i=0; i<x; i++) {
                            currNode = currNode.next;
                        }
                    }
                }else {
                    if(s.equals("C")) {
                        stack.push(currNode);
                        currNode.isRemoved = true;
                        Node up = currNode.prev;
                        Node down = currNode.next;

                        if(up != null) {
                            up.next = down;
                        }

                        if(down != null) {
                            down.prev = up;
                            currNode = down;
                        }else {
                            currNode = up;
                        }

                    }
                    else if(s.equals("Z")) {
                        Node node = stack.pop();
                        node.isRemoved = false;
                        Node up = node.prev;
                        Node down = node.next;

                        if(up != null) {
                            up.next = node;
                        }

                        if(down != null) {
                            down.prev = node;
                        }

                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            for(int i=0; i<n; i++) {
                answer.append(nodeArr[i].isRemoved ? "X" : "O");
            }
            return answer.toString();
        }
    }
}
