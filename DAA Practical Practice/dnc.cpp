#include <iostream>
#include <cmath>
#include <string.h>
using namespace std;


string sqLargeNum(string num){

    //base case: if number is small 
    if(num.size() <= 2){
        int smallNum = stoi(num);
        int sq = smallNum*smallNum;
        return to_string(sq);
    }

    int mid = num.size()/2;

    string high = num.substr(0, mid);
    string low = num.substr(mid);

    string z0 = sqLargeNum(low);
    string z1 = sqLargeNum(high);

    






}




int main(){
    string LargeNum = "123456789101112";

    string sqrNum = sqLargeNum(LargeNum);

    return 0;
}