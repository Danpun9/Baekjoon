#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    int a;

    cin >> n >> a;

    int cnt = 0;

    while (n >= a){
        n /=a;
        cnt += n;
    }
    
    cout << cnt;

    cout << "\n";

    return 0;
}