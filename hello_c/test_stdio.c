#include <stdio.h>
#include "io/stdio/fopen1.c"
#include "io/stdio/maxfopen1.c"

/**
 * I/O: input & output, 是一切实现的基础
 *       stdio标准IO
 *       sysio系统调用IO（文件IO）
 *
 * stdio：FILE类型贯穿始终
 *
 * fopen()
 * fclose()
 *
 * fgetc()
 * fputc()
 * fgets()
 * fputs()
 * fread()
 * fwrite()
 *
 * printf()
 * scanf()
 *
 * fseek()
 * ftell()
 * rewind()
 *
 * fflush()
 *
 *
 * 查看文档
 * man 3 fopen
 * man 7 socket
 * man 7 epoll
 *
 */
void test_stdio(){

//    fopen1();
    maxfopen();

}