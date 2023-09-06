#include <iostream>
#include <cstring>
using namespace std;

class BOJ_9655
{
public:
    static string start()
    {
        int N;
        cin >> N;

        int dp[N+1];
        memset(dp, 0, sizeof(int)*(N+1));

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for (int i = 4; i <= N; i++)
            dp[i] = dp[i-1] + 1 < dp[i-3] + 1 ? dp[i-1] + 1 : dp[i-3] + 1;

        if (dp[N] % 2 == 0)
            return "CY";
        else
            return "SK";
    }
};

int main()
{
    cout << BOJ_9655::start() << endl;

    return 0;
}