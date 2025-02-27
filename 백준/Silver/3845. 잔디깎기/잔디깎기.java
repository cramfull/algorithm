
import java.io.*;
import java.util.*;

public class Main {
    // 가로 100 * 세로 75
    // TC 1
    // 10
    // 20

    // 브루트포스로 풀어보자
    // 기계 폭으로 +- 폭/2로 -인 경우, +인 경우 ==이거나 작은 경우

    // 입력 받기, 정렬
    // 이전 칠한 범위 = 이전 좌표 + 폭/2
    // 해당 조건이 만족하지 않은 경우 false

    static int nx, ny;
    static float w;
    static ArrayList<Float> xi;
    static ArrayList<Float> yi;
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException {
        init();
        System.out.println(sb);
    }

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            nx = Integer.parseInt(str.nextToken());
            ny = Integer.parseInt(str.nextToken());
            w = Float.parseFloat(str.nextToken());

            if (nx == 0 && ny == 0 && w == 0.0) {
                return;
            }
            xi = new ArrayList<>();
            yi = new ArrayList<>();
            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < nx; i++) {
                xi.add(Float.parseFloat(str.nextToken()));
            }

            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < ny; i++) {
                yi.add(Float.parseFloat(str.nextToken()));
            }


            solution();
        }
    }

    static void solution() {
        Collections.sort(xi);
        Collections.sort(yi);

        float halfWidth = w / 2;

        if (xi.get(0) - halfWidth > 0) {
            sb.append("NO").append("\n");
            return;
        }

        for (int i = 0; i < xi.size()-1; i++) {
            float nowX = xi.get(i);
            float nextX = xi.get(i + 1);
            if (nowX + halfWidth < nextX - halfWidth) {
                sb.append("NO").append("\n");
                return;
            }
        }

        if (xi.get(xi.size() - 1) + halfWidth < 75.0) {
            sb.append("NO").append("\n");
            return;
        }


        if (yi.get(0) - halfWidth > 0) {
            sb.append("NO").append("\n");
            return;
        }

        for (int i = 0; i < yi.size()-1; i++) {
            float nowY = yi.get(i);
            float nextY = yi.get(i + 1);
            if (nowY + halfWidth < nextY - halfWidth) {
                sb.append("NO").append("\n");
                return;
            }
        }

        if (yi.get(yi.size() - 1) + halfWidth < 100.0) {
            sb.append("NO").append("\n");
            return;
        }

        sb.append("YES").append("\n");
    }
}
