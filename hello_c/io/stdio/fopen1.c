#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>

int fopen1() {

    FILE *fp;

    fp = fopen("/Users/ask123/Desktop/tmp", "w");

    if (fp == NULL) {
//        fprintf(stderr, "fopen() faild! errno=%d", errno);
//        perror("fopen()");
        fprintf(stderr, "fopen():%s\n", strerror(errno));

        exit(1);
    }

    puts("OK!");

    fclose(fp);

    exit(0);
}