#include <iostream>
#include <cstring>
using namespace std;

int grundy[3000001];
int main()
{
    int N;
    cin >> N;
    
    int P[N];
    for (int i = 0; i < N; i++)
        cin >> P[i];
    
    int fibo[34];
    fibo[0] = 0;
    fibo[1] = 1;
    for (int i = 2; i < 34; i++)
        fibo[i] = fibo[i-1] + fibo[i-2];
    
    bool numCheck[16];
    grundy[0] = 0;
    grundy[1] = 1;
    grundy[2] = 2;
    grundy[3] = 3;

    for (int n = 4; n < 3000001; n++) {
        memset(numCheck, false, sizeof(bool) * 16);
        for (int i = 2; i < 34; i++) {
            if (fibo[i] <= n)
                numCheck[grundy[n - fibo[i]]] = true;
            else {
                for (int i = 0; i < 16; i++) {
                    if (!numCheck[i]) {
                        grundy[n] = i;
                        break;
                    }
                }
            }
        }
    }

    int result = 0;
    for (auto n : P)
        result ^= grundy[n];

    cout << (result ? "koosaga\n" : "cubelover\n");
    
    return 0;
}
