#include <stdio.h>
#include <stdlib.h>
#include <arpa/inet.h>



int main(int argc, char *argv[])
{
    int num = 0x01020304;
    short a = 0x0102;
    int sum = htonl(num);
    printf("%x\n", sum);
    short b = htons(a);
    printf("%x\n", b);

    exit(0);
}