#include <iostream>
#include <cstring>
using namespace std;

class BOJ_9095
{
public:
    static void start()
    {
        int T;
        cin >> T;

        for (int t = 0; t < T; t++) {
            int n;
            cin >> n;

            int dp[n + 1];
            memset(dp, 0, sizeof(int) + (n + 1));
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            cout << dp[n] << endl;
        }
    }
};

int main()
{
    BOJ_9095::start();

    return 0;
}