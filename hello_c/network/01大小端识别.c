#include <stdio.h>
#include <stdlib.h>

typedef union std
{
    unsigned short a;
    unsigned  char b[2];
} STD;

// big-endian and little-endian 
int main(int argc, char *argv[])
{
    STD tmp;
    tmp.a = 0x0102;
    if(tmp.b[0] == 0x01)
    {
        printf("大端");
    }else{
        printf("小端");
    }

    exit(0);
}