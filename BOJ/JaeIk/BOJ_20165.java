package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20165 {
    static int cnt=0;
    //오 왼 하 상
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static int map[][];
    static char state[][];
    static int n,m,r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        state = new char[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                state[i][j] = 'S';
            }
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int cr = Integer.parseInt(st.nextToken())-1;
            int cc = Integer.parseInt(st.nextToken())-1;
            int d = checkDir(st.nextToken().charAt(0));

            attack(cr,cc,d);

            st = new StringTokenizer(br.readLine());
            cr = Integer.parseInt(st.nextToken())-1;
            cc = Integer.parseInt(st.nextToken())-1;
            defense(cr,cc);
        }

        System.out.println(cnt);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(state[i][j] + " ");
            }
            System.out.println(); // Print a newline after each row
        }

    }

    static int checkDir(char dir){
        if(dir=='E')return 0;
        else if(dir=='W')return 1;
        else if(dir=='S')return 2;
        else if(dir=='N')return 3;
        return 0;
    }

    static void attack(int cr, int cc, int d){
        if(state[cr][cc]=='F')return;
        else{
            state[cr][cc] = 'F';
            cnt++;
            int size = map[cr][cc]-1;

            while(size>0){
                int nr = cr+dr[d];
                int nc = cc+dc[d];

                if(nr<0 || nc<0 || nr>=n || nc>=m)return;

                //다음칸이 이미 쓰러진 경우
                if(state[nr][nc]=='F'){
                    size--;
                    cr=nr;
                    cc=nc;
                    continue;
                }

                //다음칸이 세워져있는 경우
                //-1한 사이즈와 다음 칸의 사이즈를 비교하여 도미노 연쇄작용 구현
                size--;
                state[nr][nc] = 'F';
                int newSize = map[nr][nc] -1;
                cr=nr;
                cc=nc;
                cnt++;
                size = newSize>size ? newSize:size;
            }
        }
    }

    static void defense(int cr, int cc){
        if(state[cr][cc]=='F')state[cr][cc]='S';
        else return;
    }
}
