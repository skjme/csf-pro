#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){


    int counter;
    alarm(1);
    for(counter=0; 1; counter++)
        printf("counter=%d ", counter);

    exit(0);
}