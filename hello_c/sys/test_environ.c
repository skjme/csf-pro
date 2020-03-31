#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
    char *val;

    const char *name = "JAVA_HOME1";

    val = getenv(name);
    printf("1,%s = %s\n", name, val);

    setenv(name, "vvvv", 1);

    val = getenv(name);
    printf("2,%s = %s\n", name, val);

    exit(0);
}