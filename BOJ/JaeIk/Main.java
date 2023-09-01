package BOJ.JaeIk;

import java.util.*;
import java.io.*;

public class Main {
    static int cnt=0;
    //동서남북
    static int dr[] = {0, 0, 1, -1};
    static int dc[] = {1,-1, 0, 0};
    static int n,m,r;
    static int map[][];
    static char state[][];
    public static void main(String[] args) throws IOException{
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
            int d = getDirection(st.nextToken().charAt(0));

            attack(cr, cc, d);

            st = new StringTokenizer(br.readLine());
            cr = Integer.parseInt(st.nextToken())-1;
            cc = Integer.parseInt(st.nextToken())-1;

            defense(cr, cc);
        }

        System.out.println(cnt);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.println(state[i][j]+ " ");
            }
            System.out.println();
        }

    }

    static int getDirection(char d){
        if(d=='E')return 0;
        else if(d=='W')return 1;
        else if(d=='S')return 2;
        else if(d=='N')return 3;
        return 0;
    }

    static void attack(int cr, int cc, int d){
        if(state[cr][cc]=='F')return;

        else{
            cnt++;
            int size = map[cr][cc]-1;
            state[cr][cc] = 'F';

            while(size>0){

                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr<0 || nc<0 || nr>=n || nc>=m)return;

                //다음칸이 쓰러져있을때
                if(state[nr][nc]=='F'){
                    size--;
                    cr=nr;
                    cc=nc;
                    continue;
                }

                //다음칸이 세워져있을때
                size--;
                state[nr][nc] = 'F';
                cnt++;
                cr=nr;
                cc=nc;
                int newSize = map[nr][nc]-1;
                size = newSize>size ? newSize:size;
            }
        }
    }

    static void defense(int cr, int cc){
        if(state[cr][cc]=='F')state[cr][cc]='S';
        else return;
    }
}