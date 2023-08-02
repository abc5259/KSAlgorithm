package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    static int n, c;
    static int home[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        home = new int[n];
        for(int i=0; i<n; i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int low = 0, high = 1000000001;

        while(low+1 < high){
            int mid = (low+high)/2;

            if(check(mid)){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        System.out.println(low);
    }

    static Boolean check(int mid){
        int cnt = 1;
        int forehome = home[0];
        for(int i=0; i<n-1; i++){


            if(mid <= home[i+1]-forehome){
                forehome = home[i+1];
                cnt++;
            }
            if(cnt==c)return true;
        }
        return false;
    }
}
