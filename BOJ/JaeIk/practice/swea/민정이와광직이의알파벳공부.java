package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 민정이와광직이의알파벳공부 {

    static int result;
    static int n;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());

            arr = new String[n];
            for(int i=0; i<n; i++){
                arr[i] = br.readLine();
            }

            result = 0;
            dfs("", 0, -1);

            System.out.println("#"+(tc+1)+" "+result);

        }
    }

    static void dfs(String str, int depth, int foreIdx){
        if(check(str))result++;

        if(depth==n){
            return;
        }

        for(int i=foreIdx+1; i<n; i++){
            dfs(str+arr[i], depth+1, i);
        }
    }

    static boolean check(String str){

        for(int i=97; i<=122; i++){
            String alphabet = String.valueOf((char) i);

            if(!str.contains(alphabet)){
                return false;
            }
        }

        return true;
    }
}
