package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.imageio.IIOException;

public class 스도쿠2 {
    static int[] visit;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            map = new int[9][9];

            StringTokenizer st;
            for(int i=0; i<9; i++){
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<9; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = (checkAll())?0:1;

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static boolean checkAll(){
        if(checkRow() || checkCol() || checkGrid())return true;

        return false;
    }

    static boolean isWrong(){
        for(int i=1; i<=9; i++){
            if(visit[i] != 1){
                return true;
            }
        }

        return false;
    }

    static boolean checkGrid(){
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                visit = new int[10];

                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++){
                        visit[map[k][l]]++;
                    }
                }

                if(isWrong()){
                    return true;
                }
            }
        }

        return false;
    }

    static boolean checkCol(){
        for(int i=0; i<9; i++){
            visit = new int[10];

            for(int j=0; j<9; j++){
                visit[map[j][i]]++;
            }

            if(isWrong()){
                return true;
            }
        }

        return false;
    }

    static boolean checkRow(){
        for(int i=0; i<9; i++){
            visit = new int[10];

            for(int j=0; j<9; j++){
                visit[map[i][j]]++;
            }

            if(isWrong()){
                return true;
            }
        }

        return false;
    }
}
