import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 최대상금
{
    static char[] arr;
    static int chance;
    static int max;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String number = st.nextToken();
            chance = Integer.parseInt(st.nextToken());

            arr = new char[number.length()];
            for(int i=0; i<number.length(); i++) {

                arr[i] = number.charAt(i);
                //System.out.println("arr: "+arr[i]);
            }

            max = Integer.MIN_VALUE;
            if(arr.length < chance) {	// swap 횟수가 자릿수보다 클 때
                chance = arr.length;	// 자릿수만큼만 옮겨도 전부 옮길 수 있음
            }
            dfs(0, 0);

            System.out.println("#"+(tc+1)+" "+max);
        }
    }

    static void dfs(int start, int depth) {
        if(depth == chance) {
            String result = "";
            for(char num : arr) {
                result+=num;
            }
            max = Math.max(max, Integer.parseInt(result));
            return;
        }

        for(int i=start; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                dfs(start, depth+1);

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}