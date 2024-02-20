package BOJ.JaeIk.practice.programmers;

import java.util.*;

class 게임_맵_최단거리 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] visited;

    public int solution(int[][] maps) {
        int answer = 0;

        visited = new int[maps.length][maps[0].length];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length; j++){
                visited[i][j]=0;
            }
        }

        answer = solve(maps);

        return (answer==0)?-1 :answer;
    }

    static int solve(int[][] maps){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = 1;

        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int i=0; i<4; i++){
                int nextRow = current.row + dr[i];
                int nextCol = current.col + dc[i];

                if(nextRow>=0 && nextRow<maps.length && nextCol>=0 && nextCol<maps[0].length){
                    if(maps[nextRow][nextCol]==1 && visited[nextRow][nextCol]==0){
                        queue.add(new Node(nextRow, nextCol));
                        visited[nextRow][nextCol] = visited[current.row][current.col]+1;
                    }
                }
            }
        }
        return visited[maps.length-1][maps[0].length-1];
    }
}

class Node{
    int row; int col;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}