package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.swing.Icon;

public class 상호의배틀필드2 {
    static int h, w;
    static Tank tank;
    //동 서 남 북
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            for(int i=0; i<h; i++){
                map[i] = br.readLine().toCharArray();
            }

            int direction=0;
            int row=0;
            int col=0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j]=='^'){
                        direction=3;
                        row = i; col = j;
                    }
                    else if(map[i][j]=='v'){
                        direction=2;
                        row = i; col = j;
                    }
                    else if(map[i][j]=='<'){
                        direction=1;
                        row = i; col = j;
                    }
                    else if(map[i][j]=='>'){
                        direction=0;
                        row = i; col = j;
                    }
                }
            }
            tank = new Tank(direction, row, col);

            int cmdSize = Integer.parseInt(br.readLine());
            String cmd = br.readLine();

            process(cmd);

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    sb.append(map[i][j]);
                }
                if(i<h-1){
                    sb.append("\n");
                }
            }

            System.out.println("#"+(tc+1)+" "+sb);
        }
    }

    static void updateMap(int direction, int row, int col, int nextRow, int nextCol){
        switch (direction){
            case 0:
                map[row][col] = '.';
                map[nextRow][nextCol] = '>';
                break;
            case 1:
                map[row][col] = '.';
                map[nextRow][nextCol] = '<';
                break;
            case 2:
                map[row][col] = '.';
                map[nextRow][nextCol] = 'v';
                break;
            case 3:
                map[row][col] = '.';
                map[nextRow][nextCol] = '^';
                break;
        }
    }

    static void move(int direction){
        tank.direction = direction;

        int nextRow = tank.row + dr[direction];
        int nextCol = tank.col + dc[direction];
        switch (direction){
            case 0:
                map[tank.row][tank.col] = '>';
                break;
            case 1:
                map[tank.row][tank.col] = '<';
                break;
            case 2:
                map[tank.row][tank.col] = 'v';
                break;
            case 3:
                map[tank.row][tank.col] = '^';
                break;
        }

        if(nextRow<0 || nextCol<0 || nextRow>=h || nextCol>=w)return;
        if(map[nextRow][nextCol] == '-')return;

        if(map[nextRow][nextCol] == '.'){
            updateMap(direction, tank.row, tank.col, nextRow, nextCol);
            tank.row += dr[direction];
            tank.col += dc[direction];

        }
    }

    static void shoot(){
        int dir = tank.direction;
        int nextRow = tank.row;
        int nextCol = tank.col;

        while(true){
            nextRow += dr[dir];
            nextCol += dc[dir];

            if(nextRow<0 || nextCol<0 || nextRow>=h || nextCol>=w)return;

            switch (map[nextRow][nextCol]){
                case '*':
                    map[nextRow][nextCol] = '.';
                    return;

                case '#':
                    return;
            }
        }
    }

    static void process(String cmd){
        for(int i=0; i<cmd.length(); i++){
            switch (cmd.charAt(i)){
                case 'U':
                    tank.direction = 3;
                    move(3);
                    break;

                case 'D':
                    tank.direction = 2;
                    move(2);
                    break;

                case 'L':
                    tank.direction = 1;
                    move(1);
                    break;

                case 'R':
                    tank.direction = 0;
                    move(0);
                    break;

                case 'S':
                    shoot();
                    break;
            }
        }
    }
}

class Tank{
    int direction;
    int row;
    int col;

    Tank(int direction, int row, int col){
        this.direction = direction;
        this.row = row;
        this.col = col;
    }
}
