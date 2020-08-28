#include <iostream>
#include <array>
using namespace std;
int main()
{
    //membuat array
    array<int,5> nilai;
    for(int i = 1;i<=4;i++){
        nilai[i] = i;
        cout<<"nilai ke- "<<i<<" adalah : "<<nilai[i]<<endl;
    }
    int arn[8] = {3,7,8,5,3,9,8,0};
    for (int nilai: arn){
        cout<<&nilai<<" = ";
        cout<<nilai<<endl;
    }
    int arr[5]={0,2,3,2,3};
    for(int tampung : arr){
        cout<<tampung<<endl;
    }


    cout<<nilai.size()<<endl;
    cin.get();
    return 0;
}
