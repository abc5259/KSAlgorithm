#include <iostream>
#include <cstring>
using namespace std;

class GameOfStones
{
public:
    static string start()
    {
        int n;
        cin >> n;
        
        int dp[n + 1];
        memset(dp, 0, sizeof(int)*(n+1));
        dp[1] = 0;
        dp[2] = dp[3] = dp[4] = dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (!(dp[i-2] % 2) || !(dp[i-3] % 2) || !(dp[i-5] % 2))
                dp[i] = 1;
            else
                dp[i] = 0;
        }

        if (dp[n])
            return "First";
        else
            return "Second";
    }
};

int main()
{
    cout << GameOfStones::start() << endl;

    return 0;
}