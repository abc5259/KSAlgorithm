/**
 * 19942 - 다이어트 [성공|01:22:25]
 * 골드4, 조합|백트레킹, 시도4
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_19942 {
    // 식재료를 보고 각 영양분 합이
    // 최소 100, 70, 90, 10이 되는 가격 중 최솟값.
    // 식품 갯수 N (3 <= N <= 15)

    static int N;
    static int[] max;
    static int[][] diet;
    static ArrayList<Integer> stk = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static int mnprice = Integer.MAX_VALUE;

    static void letsDiet(int idx) {
        int mp = 0, mf = 0, ms = 0, mv = 0;
        int price = 0;

        for (int ix : stk) {
            mp += diet[ix][0];
            mf += diet[ix][1];
            ms += diet[ix][2];
            mv += diet[ix][3];
            price += diet[ix][4];
        }

        if (mp >= max[0] && mf >= max[1] && ms >= max[2] && mv >= max[3]) {
            if (mnprice > price) {
                mnprice = price;
                list = new ArrayList<>();
                for (int ix : stk) list.add(ix + 1);
            }
        }
       
        for (int i = idx + 1; i < N; i++) {
            stk.add(i);
            letsDiet(i);
            stk.remove((Integer)i);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        diet = new int[N][5];
        max = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++)
            max[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                diet[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        letsDiet(-1);

        if (!list.isEmpty()) {
            System.out.println(mnprice);
            for (int ix : list) System.out.print(ix + " ");
            System.out.println();
        } else System.out.println(-1);
    }
}
