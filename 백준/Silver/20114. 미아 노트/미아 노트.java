import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 원래 문자열 길이
        int H = Integer.parseInt(st.nextToken()); // 세로 번짐
        int W = Integer.parseInt(st.nextToken()); // 가로 번짐

        // 번진 문자열 전체를 저장할 2차원 배열
        char[][] blurred = new char[H][N * W];
        for (int i = 0; i < H; i++) {
            blurred[i] = br.readLine().toCharArray();
        }

        StringBuilder result = new StringBuilder();

        // 원래 문자열의 각 자리(i)를 순회
        for (int i = 0; i < N; i++) {
            char restoredChar = '?';
            
            // i번째 글자가 번진 H * W 격자 범위를 탐색
            // 가로 범위: [i * W] ~ [(i + 1) * W - 1]
            // 세로 범위: [0] ~ [H - 1]
            boolean found = false;
            for (int r = 0; r < H; r++) {
                for (int c = i * W; c < (i + 1) * W; c++) {
                    if (blurred[r][c] != '?') {
                        restoredChar = blurred[r][c];
                        found = true;
                        break;
                    }
                }
                if (found) break; // 문자를 찾았으면 해당 글자 탐색 종료
            }
            result.append(restoredChar);
        }

        System.out.println(result.toString());
    }
}