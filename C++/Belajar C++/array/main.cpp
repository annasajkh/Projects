#include <iostream>

using namespace std;

int main()
{
    //membuat array
    int a[5];
    a[0]= 0;
    a[1]= 1;
    a[2]= 2;
    a[3]= 3;
    a[4]= 4;

    cout<<&a[0]<<" nilainya adalah : "<<a[0]<<endl;
    cout<<&a[1]<<" nilainya adalah : "<<a[1]<<endl;
    cout<<&a[2]<<" nilainya adalah : "<<a[2]<<endl;
    cout<<&a[3]<<" nilainya adalah : "<<a[3]<<endl;
    cout<<&a[4]<<" nilainya adalah : "<<a[4]<<endl;


    cin.get();
    return 0;
}
