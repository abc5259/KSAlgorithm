#include <iostream>
#include <cstring>
using namespace std;

class BOJ_1463
{
public:
    static void start()
    {
        int N;
        cin >> N;

        int dp[N + 1];
        memset(dp, 0, sizeof(int) * (N+1));
        dp[2] = dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0) dp[i] = dp[i] > (dp[i/3] + 1) ? (dp[i/3] + 1) : dp[i];
            if(i % 2 == 0) dp[i] = dp[i] > (dp[i/2] + 1) ? (dp[i/2] + 1) : dp[i];
        }

        cout << dp[N] << endl;
    }
};

int main()
{
    BOJ_1463::start();

    return 0;
}