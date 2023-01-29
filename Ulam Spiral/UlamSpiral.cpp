#include <iostream>
#include <vector>
#include <cmath>
#include "matplotlibcpp.h"

using namespace std;
namespace plt = matplotlibcpp;

bool isprime(int num){

}

int main(){
    vector<int> x = {1,2,3};
    vector<int> y = {3,2,1};
    plt::plot(x, y);
    plt::show();

    return 0;
}

//g++ UlamSpiral.cpp -I E:\Python\Include -I E:\Python\Lib\site-packages\numpy\core\include -L E:\Python\libs -lpython