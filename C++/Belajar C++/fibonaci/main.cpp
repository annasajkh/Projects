#include <iostream>

using namespace std;
int fibonaci(int n){
    if((n == 0)||(n == 1)){
    return n;
    }else{
        cout<<n;
        return fibonaci(n - 1) + fibonaci(n - 2);
    }


}

int main()
{
    while(true){
    int k,hasil;
    cout<<"masukan nilai : ";
    cin>>k;
        hasil = fibonaci(k);
        cout<<" = "<<hasil<<endl;
    }



    cin.get();
    return 0;
}
