#include <stdio.h>
#include "fork1.c"
//#include "test_stdio.c"
#include "./io/stdio/mycpy.c"

// * 编译器gcc：

// * C编译运行过程：
// * 源文件 -  预处理 - 编译 - 汇编 - 连接 - 可执行文件
// *  gcc -E hello.c > hello.i (预处理)
// *  gcc -S hello.i > hello.s (编译成汇编)
// *  gcc -c hello.s （连接）
// *  gcc -o app hello.o （生成可执行文件）
// *  ./app （运行）

// 或
// gcc -o app hello.c

/**
 * @param argc
 * @param argv
 * @return
 */
int main(int argc, char **argv) {

    fork1();
//    test_stdio();

//    mycpy(argc, argv);

    return 0;
}