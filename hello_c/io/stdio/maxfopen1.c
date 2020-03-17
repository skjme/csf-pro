#include <stdio.h>
#include <stdlib.h>

// ulimit -a
// stream ->  stdin, stdout, stderr
//标准输入 0
//标准输出 1
//标准错误 2
int maxfopen(){

    FILE *fp;
    int count;

    while (1)
    {
        fp = fopen("tmp", "r");
        if(fp == NULL)
        {
            perror("fopen()");
            break;
        }
        count++;
    }

    printf("count=%d\n", count);

    exit(0);
}