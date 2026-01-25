import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 국가의 수
            int M = Integer.parseInt(st.nextToken()); // 비행기 종류의 수

            // M개의 비행기 노선 정보를 읽지만 사용하지는 않음
            for (int i = 0; i < M; i++) {
                br.readLine(); 
            }

            // 모든 국가를 연결하는 최소 간선 수는 항상 N - 1
            System.out.println(N - 1);
        }
    }
}