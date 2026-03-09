#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> A, B;

    // F_i = F_{i-1} + F_{i-2} 로 A는 F_i, B는 F_{i-1}과 F_{i-2} 분배
    if (N % 3 == 0) { 
        for (int i = N; i >= 3; i -= 3) {
            A.push_back(i);
            B.push_back(i - 1);
            B.push_back(i - 2);
        }
    } 
    // F_2 = F_1 = 1 이므로, 분배 후 마지막 두개의 1을 A와 B에 분배
    else if (N % 3 == 2) { 
        A.push_back(2);
        B.push_back(1);
        
        for (int i = N; i >= 5; i -= 3) {
            A.push_back(i);
            B.push_back(i - 1);
            B.push_back(i - 2);
        }
    } 
    // F_4 = F_3 + F_2 를 사용하여 F_1을 제외하고 분배
    else {
        
        A.push_back(4);
        B.push_back(3);
        B.push_back(2);

        for (int i = N; i >= 7; i -= 3) {
            A.push_back(i);
            B.push_back(i - 1);
            B.push_back(i - 2);
        }
    }

    // 출력
    cout << A.size() << "\n";
    for (int i = 0; i < A.size(); ++i) {
        cout << A[i] << (i == A.size() - 1 ? "" : " ");
    }
    cout << "\n";

    cout << B.size() << "\n";
    for (int i = 0; i < B.size(); ++i) {
        cout << B[i] << (i == B.size() - 1 ? "" : " ");
    }
    cout << "\n";

    return 0;
}