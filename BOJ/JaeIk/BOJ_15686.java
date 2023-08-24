package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15686 {
    static int houseCount=0;
    static int chickenCount=0;
    static int[] chickenRow= new int[13], chickenCol = new int[13];
    static int[] houseRow= new int[13], houseCol = new int[13];
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input==1){
                    houseRow[houseCount] = i;
                    houseCol[houseCount] = j;
                    houseCount++;
                }
                else if(input==2){
                    chickenRow[chickenCount] = i;
                    chickenCol[chickenCount] = j;
                    chickenCount++;
                }
            }
        }

        System.out.println(solve());
    }

    static int solve(){
        int ret = Integer.MAX_VALUE;

        //1에 치킨집갯수만큼 쉬프트한 수만큼 비교
        //countBits에서 i값의 2진수를 인자로 넣어줌
        for(int subset=0; subset<1<<chickenCount; ++subset){
            if(countBits(subset)==m){
                int sum =0;
                for(int i=0; i<houseCount; ++i){
                    int distance = Integer.MAX_VALUE;
                    for(int j=0; j<chickenCount; ++j){
                        //치킨집이 있는 부분집합의 값인지 확인 ??
                        if((subset & 1>>j) != 0){
                            distance = Math.min(distance, Math.abs(houseRow[i]-chickenRow[j]
                                    + houseCol[i]-chickenCol[j]));
                        }
                        sum += distance;
                    }
                    ret = Math.min(ret, sum);
                }
            }
        }
        return ret;
    }

    static int countBits(int n){
        int count=0;

        //n의 2진수를 1과 AND연산하여 n에 1이 몇개인지 count
        while(n>0){
            if((n&1)==1) ++count;
            n = n>>1;
        }
        return count;
    }
}
