package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int resX = (x + t) % (w * 2);
        int resY = (y + t) % (h * 2);

        if (resX > w) {
            resX = resX - ((resX - w) * 2);
        }
        if (resY > h) {
            resY = resY - ((resY - h) * 2);
        }
        System.out.println(resX + " " + resY);
    }
}

// S3 개미 수학
// 반사 안된다고 가정하는 범위를 생각해서 동작한다. 반사되는 면을 모두 펼쳐서 4개의 사분면으로 이용해서 푼다.
// t에 따라 확장해서 갈 때 확장 사각형을 초과하면 mod 연산을 통해 다시금 확장 사각형을 초과하지 않게한다.
// mod 했을 때 w와 h를 넘는 기존의 사분면을 초과하는 부분에 있어서는 y, x, yx 둘다 반사되었다는 뜻으로
// 해당되는 좌표에서 w와 h 보다 클경우 기존의 좌표 -( (사분면이 초과된 만큼)*2) == 기존좌표에서 돌아가야 하니까