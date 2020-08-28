#include <iostream>
#include <random>

int main(){
    string x;
    for(int i = 0;i<100;i++){
        x += string(int(rand() *9));
    }
    std::cout << x << std::endl;
    return 0;
}
