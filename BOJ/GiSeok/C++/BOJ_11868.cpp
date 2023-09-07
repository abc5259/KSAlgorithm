#include <iostream>
using namespace std;

int main()
{
    int N;
    cin >> N;

    int P[N];
    for (int i = 0; i < N; i++) {
        cin >> P[i];
        if (i != 0) P[0] ^= P[i];
    }

    cout << (P[0] > 0 ? "koosaga" : "cubelover") << endl;
}