def mem_use():
    free=0
    used=0
    total=0
    buffers=0
    cached=0
    with open('/proc/meminfo','r') as file:
        for line in file.readlines():
            if line.startswith('MemTotal:'):
                total=line.split()[1]
            if line.startswith('MemFree:'):
                free=line.split()[1]
            if line.startswith('Cached:'):
                cached=line.split()[1]
            if line.startswith('Buffers:'):
                buffers=line.split()[1]
    used=int(total)-int(free)-int(cached)-int(buffers)
    # insert_sql="""insert into `monitor_mem_use` (`used`,`free`,`cached`,`buffers`,`flow_time`) values ({0},{1},{2},{3},'{4}')""".format(used,free,cached,buffers,now_zero)
    # cursorUpdate(insert_sql,[])
    print(used)


if __name__ == '__main__':
    mem_use()
