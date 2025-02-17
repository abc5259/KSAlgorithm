package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
    //    static int R, C, res;
//    static char[][] pipe;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        R = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//
//        pipe = new char[R][C];
//        String str;
//        for (int i = 0; i < R; i++) {
//            str = br.readLine();
//            for (int j = 0; j < C; j++) {
//                pipe[i][j] = str.charAt(j);
//            }
//        }
//
//        for (int i = 0; i < R; i++) {
//            if (dfs(i, 0))
//                res++;
//        }
//        System.out.println(res);
//    }
//
//    static int[] dy = {-1, 0, 1};
//
//    static boolean dfs(int y, int x) {
//        int nx = x + 1;
//
//        if (nx == C - 1) {
//            return true;
//        }
//        for (int i = 0; i < 3; i++) {
//            int ny = y + dy[i];
//
//            if (ny >= 0 && ny < R && pipe[ny][nx] != 'x') {
//                pipe[ny][nx] = 'x';
//                if (dfs(ny, nx)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    }
}
