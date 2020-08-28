#include "iostream"
#include "string"
#include "random"

int rnd(){
    return rand();
}

int main(){
    std::string a = "Helo";
    std::cout << a + " hai" << std::endl;
    std::cout << rnd() << std::endl;
    return 0;
}
