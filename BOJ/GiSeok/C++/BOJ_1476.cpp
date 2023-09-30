#include <iostream>

int main()
{
    int E, S, M;
    std::cin >> E >> S >> M;
    
    int e = 1, s = 1, m = 1;
    int ans = 1;

    while (!(e == E && s == S && m == M))
    {
        e++; s++; m++;
        if (e > 15)
            e = 1;
        if (s > 28)
            s = 1;
        if (m > 19)
            m = 1;
            
        ans++;
    }
    
    std::cout << ans << "\n";
}
