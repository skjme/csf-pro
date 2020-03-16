#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int fork1() {
    pid_t pid;
    printf("[%d]:Begin!\n", getpid());

    fflush(NULL);

    pid = fork();

    if (pid < 0) {
        perror("fork()");
        exit(1);
    }

    if (pid == 0) // child
    {
        printf("[%d]:Child is working!\n", getpid());
    }

    if (pid > 0) // parent
    {
        printf("[%d]:Parent is working!\n", getpid());
    }

    printf("[%d]:End!\n", getpid());

    getchar();

    exit(0);
}