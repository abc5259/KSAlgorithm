package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11501 {
    public static void main(String[] args) throws IOException {
        //8:44
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] stockArr = new int[N];
            for(int i=0; i<N; i++) {
                stockArr[i] = Integer.parseInt(st.nextToken());
            }

            long money = 0;
            Queue<Integer> buyStock = new LinkedList<>();
            for(int i=0; i<N-1; i++) {
                if(stockArr[i] <= stockArr[i+1]) {
                    buyStock.offer(stockArr[i]);
                }
                else {
                    boolean isOk = true;
                    for(int j=i+1; j<N; j++) {
                        if(stockArr[i] < stockArr[j]) {
                            isOk = false;
                            buyStock.offer(stockArr[i]);
                            break;
                        }
                    }
                    if(isOk) {
                        while (!buyStock.isEmpty()) {
                            money += stockArr[i] - buyStock.poll();
                        }
                    }
                }
            }

            while (!buyStock.isEmpty()) {
                money += stockArr[N-1] - buyStock.poll();
            }

            sb.append(money+"\n");
        }
        System.out.println(sb);
    }
}
