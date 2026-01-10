import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        // A와 B는 1부터 999까지 가능함
        for (int a = 1; a <= 999; a++) {
            for (int b = a; b <= 999; b++) {
                // A부터 B까지 이어 붙인 문자열 만들기
                StringBuilder sb = new StringBuilder();
                for (int i = a; i <= b; i++) {
                    sb.append(i);
                }
                
                // 생성한 문자열의 길이가 S와 다르면 비교할 필요 없음
                if (sb.length() != s.length()) {
                    // 단, 생성한 문자열이 이미 S보다 길어지면 
                    // 현재 A에 대해 더 큰 B를 검사할 필요가 없으므로 break
                    if (sb.length() > s.length()) break;
                    continue;
                }
                
                // 문자열이 완전히 일치하는지 확인
                if (sb.toString().equals(s)) {
                    System.out.println(a + " " + b);
                    return; // A가 가장 작은 것부터 찾았으므로 즉시 종료
                }
            }
        }
    }
}