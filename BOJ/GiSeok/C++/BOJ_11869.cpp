#include <iostream>

int main()
{
    int M;
    std::cin >> M;
    
    int result = 0;
    int n;
    for (int i = 0; i < M; i++) {
        std::cin >> n;
        result ^= n;
    }
    
    std::cout << ((result > 0) ? "koosaga\n" : "cubelover\n");
}
