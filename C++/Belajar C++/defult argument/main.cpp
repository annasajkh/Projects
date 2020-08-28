#include <iostream>

using namespace std;
//parameter yg mempunyai nilai default
void hitung(int a = 1,int b = 1,int c = 1){
    cout<<a+b+c<<endl;
}
int main()
{
    hitung();
    cin.get();
    return 0;
}
