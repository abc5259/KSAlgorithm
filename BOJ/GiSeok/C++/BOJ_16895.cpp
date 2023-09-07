#include <iostream>
using namespace std;

int main()
{
    int N;
    cin >> N;

    int P[N];
    for (int i = 0; i < N; i++)
        cin >> P[i];

    int cnt = 0;
    int result = 0;
    for (int i = 0; i < N; i++) {
        for (int x = 0; x < P[i]; x++) {
            result = x;
            for (int y = 0; y < N; y++)
                if (y != i) result ^= P[y];
            if (result == 0) cnt++;
        }
    }

    cout << cnt << endl;
}