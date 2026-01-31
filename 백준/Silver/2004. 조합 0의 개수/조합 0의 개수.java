import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        // 조합의 성질: nCm = n! / (m! * (n-m)!)
        // 5의 개수 계산
        long count5 = getFactorCount(n, 5) - getFactorCount(m, 5) - getFactorCount(n - m, 5);
        // 2의 개수 계산
        long count2 = getFactorCount(n, 2) - getFactorCount(m, 2) - getFactorCount(n - m, 2);

        // 2와 5의 쌍이 맞아야 10이 되므로 최솟값 출력
        System.out.println(Math.min(count5, count2));
    }

    // n!에 포함된 소수 k의 개수를 구하는 함수
    private static long getFactorCount(long n, int k) {
        long count = 0;
        while (n >= k) {
            count += n / k;
            n /= k;
        }
        return count;
    }
}