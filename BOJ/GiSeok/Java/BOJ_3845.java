package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_3845 {

    static double[] inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            double w = Double.parseDouble(st.nextToken());

            if (nx == 0 && ny == 0 && w == 0.0) break;

            // nx
            inputs = new double[nx];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < nx; i++) {
                inputs[i] = Double.parseDouble(st.nextToken());
            }
            Arrays.sort(inputs);

            double maxLength = connect(nx, w);

            // ny
            inputs = new double[ny];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < ny; i++) {
                inputs[i] = Double.parseDouble(st.nextToken());
            }
            Arrays.sort(inputs);

            double maxWidth = connect(ny, w);

            if (maxWidth < 100 || maxLength < 75) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");
        }
    }

    private static double connect(int range, double w) {
        double length = 0;
        for (int i = 0; i < range; i++) {
            if (i == 0 && inputs[i] - (w / 2) > 0) return -1;

            if (inputs[i] - (w / 2) <= length) {
                length = inputs[i] + (w / 2);
            }
        }

        return length;
    }
}
