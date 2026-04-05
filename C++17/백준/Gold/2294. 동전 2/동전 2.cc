#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);
    for (int i = 0; i < n; i++) {
        cin >> coins[i];
    }

    vector<int> dp(k + 1, 10001);
    dp[0] = 0;

    for (int i = 0; i < n; i++) {
        for (int j = coins[i]; j <= k; j++) {
            dp[j] = min(dp[j], dp[j - coins[i]] + 1);
        }
    }

    if (dp[k] == 10001) {
        cout << -1;
    } else {
        cout << dp[k];
    }

    return 0;
}