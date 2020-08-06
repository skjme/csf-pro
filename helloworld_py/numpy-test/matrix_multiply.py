import numpy as np

# see:https://www.pytorchtutorial.com/numpy-basic/#_NumPy

# 创建数组
# 在 NumPy 中创建一个数组最简单的方法是从 Python 本身的 list 转换而来：
myPythonList = [1, 9, 8, 3]
numpy_array_from_list = np.array(myPythonList)
print(numpy_array_from_list)

# 实际使用中，这两句可以合并：
a = np.array([1, 9, 8, 3])
print(a)

# 数组的形状
# 可以使用 shape 属性来查看数组的形状，也可以用 dtype 属性查看数组元素的类型：
print(a.shape)
print(a.dtype)
print()

# 多维数组
# 可以用双尖括号（[]）来创建多维数组，每个维度之间用逗号分隔，例如：
### 二维
c = np.array([(1, 2, 3), (4, 5, 6)])
print(c)
print('shape:', c.shape)
print()


### 三维
d = np.array([
    [[1, 2,3],
        [4, 5, 6]],
    [[7, 8,9],
        [10, 11, 12]]
])
print(d.shape)
print()

# np.zeros 和 np.ones
# 这两个命令可以创建值全部为 0 或全部为 1 的数组，一般用来初始化一个数组的时候：
#
# numpy.zeros(shape, dtype=float, order='C')
# numpy.ones(shape, dtype=float, order='C')
# 这里面的参数：
#
# shape：形状
# dtype：数据类型
# order：C 代表行优先；F 代表列优先
e = np.zeros((2, 2))
print(e)
f = np.zeros((2, 2), dtype=np.int16)
print(f)
print()


# 数组形状变换
# 有些时候需要对数组的形状进行变换，例如：
e  = np.array([(1,2,3), (4,5,6)])
print(e)
e1 = e.reshape(3,2)
print(e1)
print()
# 把一个多维数组“拍平”，可以使用 flatten 函数：
print(e.flatten())
print()

# hstack 和 vstack
# 这两个函数分别用于在水平方向和竖直方向增加数据，我们来看具体例子：
f = np.array([1,2,3])
g = np.array([4,5,6])

print('水平方向:', np.hstack((f, g)))
print('竖直方向:', np.vstack((f, g)))
print()


# 生成随机数
# 生成随机的高斯分布：
# numpy.random.normal(loc, scale, size)
# Loc: 平均值
# scale: 标准差（standard deviation）
# Size: 返回多少个数
normal_array = np.random.normal(5, 0.5, 10)
print(normal_array)
print()


# 生成区间
# 有些时候我们需要在一个区间内的一些数，这个时候要用到 arange。
# numpy.arange(start, stop, step)
# Start: 区间开始
# Stop: 区间结束
# Step: 步长，默认为 1
out = np.arange(1, 11)
print(out)
print()

# Linspace
# 这个方法可以在一个区间内平均地生成多个数。
# numpy.linspace(start, stop, num, endpoint)
# Start: 数列开始的值
# Stop: 数列结束的值
# Num: 生成的数量，默认 50
# Endpoint: 默认是 True，如果是 True, 则数列包含最后的 stop 值，反之不包含
out = np.linspace(1.0, 5.0, num=10, endpoint=False)
print(out)
print()

# 点乘
# 用 np.dot 实现矩阵的点乘操作
f = np.array([1, 2])
g = np.array([4, 5])

out = np.dot(f, g)
print(out)

# 矩阵相乘
# 用 np.matmul 实现矩阵相乘的操作

h = [[1, 2], [3, 4]]
i = [[5, 6], [7, 8]]

out2 = np.matmul(h, i)
print(out2)



