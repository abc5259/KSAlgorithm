#include <iostream>
using namespace std;

int towerBreakers(int n, int m) {
    if (m == 1) return 2;
        
    if (n % 2 == 0)
        return 2;
    else
        return 1;
}

int main()
{
    int t;
    cin >> t;

    int n, m;

    for (int i = 0; i < t; i++) {
        cin >> n >> m;

        cout << towerBreakers(n, m) << endl;
    }

    return 0;
}