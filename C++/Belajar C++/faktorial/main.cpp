#include <iostream>

using namespace std;
double faktorial(double f){
    if(f <=1){
        cout<<"1";
        return f;
    }else{
        cout<<f<<" * ";
        return f * faktorial(f - 1);
    }
}
int main()
{
    while(true){
    double a,hasil;
    cout<<"Masukan faktorial : ";
    cin>>a;
        hasil = faktorial(a);
        cout<<" = "<<hasil<<endl;
    }


    cin.get();
    return 0;
}
