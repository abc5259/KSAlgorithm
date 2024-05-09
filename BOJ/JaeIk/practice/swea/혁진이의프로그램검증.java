package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Random;

public class 혁진이의프로그램검증 {
    static int n, m;
    static boolean flag;
    static boolean[][][][] visited;
    static char[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new char[n][m];
            for(int i=0; i<n; i++){
                map[i] = br.readLine().toCharArray();
            }

            flag = false;
            visited = new boolean[21][21][4][16];
            Robot robot = new Robot(0, 0, 0, 0);
            game(robot);

            String answer = flag?"YES":"NO";

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static void game(Robot robot){

        int memory = robot.memory;
        char code = map[robot.row][robot.col];
        switch (code){
            case '>':
                robot.direction = 0;
                break;
            case '<':
                robot.direction = 1;
                break;
            case 'v':
                robot.direction = 2;
                break;
            case '^':
                robot.direction = 3;
                break;
            case '_':
                if(memory == 0)robot.direction=0;
                else robot.direction=1;
                break;
            case '|':
                if(memory == 0)robot.direction=2;
                else robot.direction=3;
            case '.':
                break;
            case '@':
                flag = true;
                return;

            case '0':
                robot.memory = Character.getNumericValue(code);
                break;
            case '1':
                robot.memory = Character.getNumericValue(code);
                break;
            case '2':
                robot.memory = Character.getNumericValue(code);
                break;
            case '3':
                robot.memory = Character.getNumericValue(code);
                break;
            case '4':
                robot.memory = Character.getNumericValue(code);
                break;
            case '5':
                robot.memory = Character.getNumericValue(code);
                break;
            case '6':
                robot.memory = Character.getNumericValue(code);
                break;
            case '7':
                robot.memory = Character.getNumericValue(code);
                break;
            case '8':
                robot.memory = Character.getNumericValue(code);
                break;
            case '9':
                robot.memory = Character.getNumericValue(code);
                break;
            case '+':
                if(memory==15)robot.memory=0;
                else robot.memory += 1;
                break;
            case '-':
                if(memory==0)robot.memory=15;
                else robot.memory -= 1;
                break;
            case '?':
                for(int i=0; i<4; i++){
                    int nextRow = robot.row + dr[i];
                    int nextCol = robot.col + dc[i];

                    if(nextRow==-1)nextRow = n-1;
                    else if(nextRow==n)nextRow = 0;
                    else if(nextCol==-1)nextCol=m-1;
                    else if(nextCol==m)nextCol=0;

                    if(map[nextRow][nextCol] == '@'){
                        flag = true;
                        return;
                    }
                }
        }

        int nowRow=robot.row;
        int nowCol=robot.col;
        int nextRow = 0;
        int nextCol = 0;
        switch (robot.direction){
            case 0:
                nextRow = nowRow + dr[0];
                nextCol = nowCol + dc[0];
                if(nowCol == m-1){
                    nextCol = 0;
                }
                break;
            case 1:
                nextRow = nowRow + dr[1];
                nextCol = nowCol + dc[1];
                if(nowCol == 0){
                    nextCol = m-1;
                }
                break;
            case 2:
                nextRow = nowRow + dr[2];
                nextCol = nowCol + dc[2];
                if(nowRow == n-1){
                    nextRow = 0;
                }
                break;
            case 3:
                nextRow = nowRow + dr[3];
                nextCol = nowCol + dc[3];
                if(nowRow == 0){
                    nextRow = n-1;
                }
                break;
        }

        robot.row = nextRow;
        robot.col = nextCol;
        if(visited[robot.row][robot.col][robot.direction][robot.memory]){
            return;
        }

        visited[robot.row][robot.col][robot.direction][robot.memory] = true;

        game(robot);
    }
}

class Robot{
    int direction;
    int memory;
    int row;
    int col;

    Robot(int direction, int memory, int row, int col){
        this.direction = direction;
        this.memory = memory;
        this.row = row;
        this.col = col;
    }
}
