#include <iostream>
using namespace std;

class BOJ_2839
{
public:
    static void start()
    {
        int N;
        cin >> N;

        int dp[N+1];
        memset(dp, 0, sizeof(int) * (N+1));
        
        dp[3] = dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            if (dp[i - 5]) dp[i] = dp[i - 5] + 1;

            if (dp[i - 3]) {
                if (dp[i])
                    dp[i] = dp[i - 3] + 1 >= dp[i] ? dp[i] : dp[i - 3] + 1;
                else
                    dp[i] = dp[i - 3] + 1;
            }
        }

        cout << (dp[N] == 0 ? -1 : dp[N]) << endl;
    }
};

int main()
{
    BOJ_2839::start();

    return 0;
}