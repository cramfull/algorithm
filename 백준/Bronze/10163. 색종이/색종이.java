
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String [] args) throws IOException {
        N=0;
        board = new int[1001][1001];

        inputs();
        checking();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(hashMap.get(i)));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 입력 : 좌표x, 좌표y, 너비, 높이
    public static void inputs() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            hashMap.put(i, 0);
            String[] tmp = br.readLine().split(" ");
            int y = Integer.parseInt(tmp[0]);
            int x = Integer.parseInt(tmp[1]);
            int width = Integer.parseInt(tmp[2]);
            int height = Integer.parseInt(tmp[3]);

            painting(i, new Point(x,y),width,height);
        }
    }

    public static void painting(int num, Point point, int width, int height) {
        for (int i = point.getX(); i < point.getX() + height; i++) {
            for (int j = point.getY(); j < point.getY() + width; j++) {
                board[i][j]= num;
            }
        }
    }

    public static void checking() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int num = board[i][j];
                if (num == 0) {
                    continue;
                }
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
    }


}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
