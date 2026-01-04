import java.io.*;
import java.util.*;

public class Main {
    // 나침반 기록을 저장할 클래스
    static class Record {
        int x, y, k;
        Record(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Record[] records = new Record[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            records[i] = new Record(x, y, k);
        }

        // 1x1부터 NxN까지 모든 칸을 보물 후보로 가정하고 검사
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                boolean isPossible = true;

                for (Record res : records) {
                    // 보물 후보(r, c)가 나침반 위치(res.x, res.y)와 같은 경우 제외
                    if (r == res.x && c == res.y) {
                        isPossible = false;
                        break;
                    }

                    // 각 방향 k에 따른 조건 검사
                    if (!isValid(res.x, res.y, res.k, r, c)) {
                        isPossible = false;
                        break;
                    }
                }

                // 모든 조건을 만족하는 유일한 좌표 출력
                if (isPossible) {
                    System.out.println(r + " " + c);
                    return;
                }
            }
        }
    }

    // 나침반 위치 (x, y)에서 방향 k가 보물 위치 (tr, tc)를 가리키는지 확인
    static boolean isValid(int x, int y, int k, int tr, int tc) {
        switch (k) {
            case 1: return tr < x && tc == y;
            case 2: return tr < x && tc > y;
            case 3: return tr == x && tc > y;
            case 4: return tr > x && tc > y;
            case 5: return tr > x && tc == y;
            case 6: return tr > x && tc < y;
            case 7: return tr == x && tc < y;
            case 8: return tr < x && tc < y;
            default: return false;
        }
    }
}