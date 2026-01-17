import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // 8방향 탐색을 위한 dx, dy 배열 (상, 하, 좌, 우, 대각선 4개)
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static char[] target = {'M', 'O', 'B', 'I', 'S'};
    static int N;
    static char[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 입력
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        // 격자 정보 입력
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int totalCount = 0;

        // 모든 칸을 순회
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 시작 글자가 'M'일 때만 8방향 탐색 시작
                if (grid[r][c] == 'M') {
                    totalCount += countMobis(r, c);
                }
            }
        }

        System.out.println(totalCount);
    }

    static int countMobis(int r, int c) {
        int count = 0;

        // 8방향 각각에 대해 검사
        for (int i = 0; i < 8; i++) {
            boolean match = true;
            
            // "MOBIS"의 나머지 4글자(O, B, I, S) 확인
            for (int k = 1; k < 5; k++) {
                int nr = r + dx[i] * k;
                int nc = c + dy[i] * k;

                // 격자 범위를 벗어나거나 글자가 일치하지 않으면 중단
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || grid[nr][nc] != target[k]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }
        return count;
    }
}