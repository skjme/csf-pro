#include <stdio.h>
#include <stdlib.h>

// use:
// ./mycpy sourcefile destfile
// diff sourcefile destfile
int mycpy(int argc, char **argv)
{

    if( argc < 2){
        fprintf(stderr, "Usage...\n");
        exit(1);
    }

    FILE *fps, *fpd;
    int ch;

    fps = fopen(argv[1], "r");
    if(fps == NULL){
        perror("fopen()");
        exit(1);
    }

    fpd = fopen(argv[2], "w");
    if(fpd == NULL)
    {
        fclose(fps);
        perror("fopen()");
        exit(1);
    }

    while(1)
    {
        ch = fgetc(fps);
        if(ch == EOF)
        {
            break;
        }
        fputc(ch, fpd);
    }

    fclose(fps);
    fclose(fpd);

    exit(0);
}
