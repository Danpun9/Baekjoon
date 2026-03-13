#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    
    cin >> n;

    int res = 0;

    for(int i = 0; i < n; i++){
        int temp;
        cin >> temp;
        if(i == 0) res = temp;
    }

    cout << "YES\n";

    cout << res*111 << "\n";

    return 0;
}