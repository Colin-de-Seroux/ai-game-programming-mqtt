#include <iostream>
#include <string>
#include <chrono>
#include <iomanip>

int main()
{
    std::string line;

    while (std::getline(std::cin, line))
    {
        line.erase(0, line.find_first_not_of(" \n\r\t"));
        line.erase(line.find_last_not_of(" \n\r\t") + 1);

        auto now = std::chrono::high_resolution_clock::now();
        auto ns_since_epoch = std::chrono::duration_cast<std::chrono::nanoseconds>(now.time_since_epoch()).count();

        std::cout << ns_since_epoch << std::endl;
        std::cout.flush();
    }

    return 0;
}
