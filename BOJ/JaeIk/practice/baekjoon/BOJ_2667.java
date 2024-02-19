package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BOJ_2667 {
    static List<Integer> answer = new ArrayList<>();
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));

                if(graph[i][j] == 0)visited[i][j] = true;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                }
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());

        for(int i=0; i< answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }

    static void bfs(int row, int col){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));
        visited[row][col] = true;
        int count = 0;

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            count++;

            for(int i=0; i<4; i++){
                int nextRow = currentNode.row + dr[i];
                int nextCol = currentNode.col + dc[i];

                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<n){
                    if(!visited[nextRow][nextCol]){
                        {
                            visited[nextRow][nextCol] = true;
                            queue.add(new Node(nextRow, nextCol));
                        }
                    }
                }
            }
        }

        answer.add(count);
    }
}

class Node{
    int row;
    int col;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}