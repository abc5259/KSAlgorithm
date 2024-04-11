package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드 {
    static int h, w;
    static int[] vector;
    //동 서 남 북
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] map;
    static char[] command;
    static int[] coordinate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            //맵 초기화
            coordinate = new int[2];
            map = new char[h][w];
            for(int i=0; i<h; i++){
                String input = br.readLine();
               for(int j=0; j<w; j++){
                    map[i] = input.toCharArray();
                }
            }

            //전차 위치, 벡터
            coordinate = new int[2];
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j] == '^'){
                        setCoordinate(i, j);
                        setVector('^');
                    }
                    if(map[i][j] == 'v'){
                        setCoordinate(i, j);
                        setVector('v');
                    }
                    if(map[i][j] == '<'){
                        setCoordinate(i, j);
                        setVector('<');
                    }
                    if(map[i][j] == '>'){
                        setCoordinate(i, j);
                        setVector('>');
                    }
                }
            }

            //명령 입력
            int n = Integer.parseInt(br.readLine());
            command = br.readLine().toCharArray();

            game(n);

            System.out.print("#"+(tc+1)+" ");
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    static void game(int n){

        for(int i=0; i<n; i++){
            if(i==6) {
                i=6;
            }

            if(command[i] == 'U'){
                map[coordinate[0]][coordinate[1]] = '^';
                setVector('^');
                movePlain();
            }

            if(command[i] == 'D'){
                map[coordinate[0]][coordinate[1]] = 'v';
                setVector('v');
                movePlain();
            }

            if(command[i] == 'L'){
                map[coordinate[0]][coordinate[1]] = '<';
                setVector('<');
                movePlain();
            }

            if(command[i] == 'R'){
                map[coordinate[0]][coordinate[1]] = '>';
                setVector('>');
                movePlain();
            }

            if(command[i] == 'S'){
                int nextRow = coordinate[0];
                int nextCol = coordinate[1];
                int originRow = coordinate[0];
                int originCol = coordinate[1];
                while(nextRow<h && 0<=nextRow && nextCol<w && 0<=nextCol){
                    nextRow = getNextCoordinate()[0];
                    nextCol = getNextCoordinate()[1];

                    if(nextRow>=h || 0>nextRow || nextCol>=w || 0>nextCol)break;

                    setCoordinate(nextRow, nextCol);

                    if(map[nextRow][nextCol] == '.')continue;

                    if(map[nextRow][nextCol] == '*'){
                        map[nextRow][nextCol] = '.';
                        break;
                    }

                    if(map[nextRow][nextCol] == '#'){
                        break;
                    }
                }
                setCoordinate(originRow, originCol);
            }
        }
    }

    static void setCoordinate(int r, int c){
        coordinate[0] = r;
        coordinate[1] = c;
    }

    static void setVector(char direction){
        if(direction == '^'){
            vector = new int[] {dr[3], dc[3]};
        }
        if(direction == 'v'){
            vector = new int[] {dr[2], dc[2]};
        }
        if(direction == '<'){
            vector = new int[] {dr[1], dc[1]};
        }
        if(direction == '>'){
            vector = new int[] {dr[0], dc[0]};
        }
    }

    static int[] getNextCoordinate(){
        int nextRow = coordinate[0] + vector[0];
        int nextCol = coordinate[1] + vector[1];

        return new int[]{nextRow, nextCol};
    }

    static void movePlain(){
        int nextRow = getNextCoordinate()[0];
        int nextCol = getNextCoordinate()[1];

        if(nextRow>=h || 0>nextRow || nextCol>=w || 0>nextCol)return;

        if(map[nextRow][nextCol] == '.'){
            updateMapByMove(nextRow, nextCol);
            setCoordinate(nextRow, nextCol);
        }
    }

    static void updateMapByMove(int nextRow, int nextCol){
        map[coordinate[0]][coordinate[1]] = '.';

        if(vector[0]==0 && vector[1]==1){
            map[nextRow][nextCol] = '>';
        }

        if(vector[0]==0 && vector[1]==-1){
            map[nextRow][nextCol] = '<';
        }

        if(vector[0]==1 && vector[1]==0){
            map[nextRow][nextCol] = 'v';
        }

        if(vector[0]==-1 && vector[1]==0){
            map[nextRow][nextCol] = '^';
        }
    }
}
