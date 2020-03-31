# 自定义变量
target = app
# obj = hellomake.o hellofunc.o

# makefile自带的变量
CC=gcc
CFLAGS=-I.
# makefile自带的函数使用
src = $(wildcard ./*.c)
obj = $(patsubst ./%.c, ./%.o, $(src))

$(target): $(obj)
	$(CC) $(obj) -o $(target) 
	
#  $@ 规则中的目标；
#  $< 规则中的第一个依赖；
#  $^ 规则中的所有依赖；
#  只能在命令行（第二行）中使用
%.o: %.c 
	$(CC) -c $< -o $@

# 伪目标
.PHONY: clean

clean:
	rm -f $(obj) $(target)

hello:
	echo $(target)
