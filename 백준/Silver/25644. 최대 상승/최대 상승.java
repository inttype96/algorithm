import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력 속도 최적화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 첫 번째 날의 주가를 초기 최솟값으로 설정
        int firstPrice = Integer.parseInt(st.nextToken());
        int minPrice = firstPrice;
        int maxProfit = 0; // 이득이 없는 경우 0이 최솟값
        
        for (int i = 1; i < N; i++) {
            int currentPrice = Integer.parseInt(st.nextToken());
            
            // 1. 현재 주가에서 이전까지의 최솟값을 뺀 이득 계산
            int currentProfit = currentPrice - minPrice;
            
            // 2. 최대 이득 갱신
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
            
            // 3. 최저 주가 갱신 (더 싼 가격이 나타나면 매수 시점 변경)
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
        }
        
        // 결과 출력
        System.out.println(maxProfit);
    }
}