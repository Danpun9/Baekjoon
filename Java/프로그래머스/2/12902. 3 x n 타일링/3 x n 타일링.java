class Solution {
    public long solution(int n) {    
        // 가로 홀수 시 경우의 수 없음
        if (n % 2 != 0) return 0;
        
        long mod = 1000000007;
        long[] dp = new long[n+1]; // dp[i]: i*3 공간에서의 경우의 수
        
        dp[0] = 1;
        dp[2] = 3;
        
        for(int i = 4; i <= n; i += 2){
            dp[i] = (dp[i-2] * 3) % mod; // 이전 경우 뒤에 3*2 타일 추가
            
            for(int j = i - 4; j >= 0; j -= 2){
                dp[i] = (dp[i] + dp[j] * 2) % mod; // 통짜 모델 결합 경우
            }
        }
        
        return dp[n];
    }
}