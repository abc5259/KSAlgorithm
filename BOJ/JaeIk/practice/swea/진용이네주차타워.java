package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 진용이네주차타워 {
    static Integer[] parked;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            //i번째 주차 공간의 단위 무게당 요금
            int[] fee = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                fee[i] = Integer.parseInt(br.readLine());
            }

            //차량 i의 무게
            int[] weight = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                weight[i] = Integer.parseInt(br.readLine());
            }

            //주차장 출입기록
            parked = new Integer[n + 1];
            int[] log = new int[2 * m];
            for (int i = 0; i < 2 * m; i++) {
                log[i] = Integer.parseInt(br.readLine());
            }

            System.out.println("#"+(tc+1)+" "+revenue(fee, weight, log));
        }
    }

    static int revenue(int[] fee, int[] weight, int[] log) {
        Queue<Integer> waiting_cars = new LinkedList<>();
        int total_revenue = 0;

        for (int i = 0; i < 2*m; i++) {
            //들어올 때
            if (log[i] > 0) {
                waiting_cars.add(log[i]);

                for (int p = 1; p <= n; p++) {
                    if (parked[p] == null) {
                        if(!waiting_cars.isEmpty()){
                            int car = waiting_cars.poll();
                            total_revenue += fee[p] * weight[car];
                            parked[p] = car;
                            break;
                        }
                    }
                }
            }

            //나갈 떄
            if (log[i] < 0) {
                int out_car = Math.abs(log[i]);

                //나가기
                for (int p = 1; p <= n; p++) {
                    if (parked[p]!=null && parked[p] == out_car) {
                        parked[p] = null;
                        break;
                    }
                }

                //대기 중인 차 들어가기
                if (!waiting_cars.isEmpty()) {
                    int waiting_car = waiting_cars.poll();

                    for (int p = 1; p <= n; p++) {
                        if (parked[p] == null) {
                            total_revenue += fee[p] * weight[waiting_car];
                            parked[p] = waiting_car;
                            break;
                        }
                    }
                }
            }
        }

        return total_revenue;
    }
}
