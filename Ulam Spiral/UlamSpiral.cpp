#include <iostream>
#include <stdio.h>

using namespace std;

bool isprime(int num){
    bool out = true;
    for(int i = 2; i<num; i++){
        if(num%i==0){
            out = false;
            break;
        }
    }
    return out;
}

int main(){
    FILE *fp = NULL;
    FILE *gnupipe = NULL;
    char *GnuCommands[] = {"set title \"Ulam Spiral\"", "plot 'data.tmp'"};
    fp = fopen("data.tmp", "w");
    gnupipe = _popen("gnuplot -persitent", "w");
    int step_size = 1;
    int num_step = 1;
    int number = 1;
    int state = 0;
    int x = 0;
    int y = 0;
    int x0;
    int y0;
    int turn_counter = 0;
    int num;
    cin>>num;
    while(number <= num){
        x0 = x;
        y0 = y;
        switch(state){
            case 0: x += step_size;
            case 1: y -= step_size;
            case 2: x -= step_size;
            default: y += step_size;
        }
        if(number % num_step == 0){
            state = (state + 1) % 4;
            turn_counter = turn_counter + 1;
            if(turn_counter % 2 == 0){
                num_step = num_step + 1;
            }
        }
        number = number + 1;
        bool pnp = isprime(number);
        if(pnp){
            fprintf(fp, "%d %d\n", x, y);
        }
    }
    for(int i = 0; i<2; i++){
        fprintf(gnupipe, "%s\n", GnuCommands[i]);
    }
    return 0;
}