#include <stdio.h>
#include <stdlib.h>
#include <arpa/inet.h>


//
int main(int argc, char *argv[])
{
   char buf_ip[] = "192.168.1.48";
   int num = 0;
   inet_pton(AF_INET, buf_ip, &num);
   unsigned char *p = (char *)&num;

    printf("%d %d %d %d\n", *p, *(p+1), *(p+2), *(p+3));

    exit(0);
}