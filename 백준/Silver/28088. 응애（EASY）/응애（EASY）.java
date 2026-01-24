import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 부원 수
        int M = Integer.parseInt(st.nextToken()); // 초기 인사 수
        int K = Integer.parseInt(st.nextToken()); // 진행 횟수

        // 부원들의 현재 인사 상태 (true: 인사함, false: 안함)
        boolean[] current = new boolean[N];
        for (int i = 0; i < M; i++) {
            current[Integer.parseInt(br.readLine())] = true;
        }

        // K번 반복
        for (int k = 0; k < K; k++) {
            boolean[] next = new boolean[N];
            boolean hasAny = false;

            for (int i = 0; i < N; i++) {
                // 원형 구조를 위한 인덱스 계산
                int left = (i == 0) ? N - 1 : i - 1;
                int right = (i == N - 1) ? 0 : i + 1;

                // XOR 연산: 양 옆 중 한 명만 인사를 했을 때 true
                next[i] = current[left] ^ current[right];
                if (next[i]) hasAny = true;
            }
            
            current = next;

            // 만약 아무도 인사를 하지 않는 상태가 되면 이후는 계속 0이므로 조기 종료
            if (!hasAny) break;
        }

        // K번 후 다음에 인사할 사람의 수 카운트
        int count = 0;
        for (boolean b : current) {
            if (b) count++;
        }

        System.out.println(count);
    }
}