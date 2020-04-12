#include <stdio.h>
#include <stdlib.h>
#include <arpa/inet.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>

#define SERVER_PORT 8000

int main(void)
{
    struct sockaddr_in serveraddr, clientaddr;
    int sockfd, addrlen, confd;
    char ipstr[128];

    // 1.socket
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    printf("sockfd=%d\n", sockfd);

    // 2.bind
    bzero(&serveraddr, sizeof(serveraddr));
    /* 地址族协议IPv4 */
    serveraddr.sin_family = AF_INET;
    /* IP地址 */
    serveraddr.sin_addr.s_addr = htonl(INADDR_ANY);
    serveraddr.sin_port = htons(SERVER_PORT);
    bind(sockfd, (struct sockaddr *)&serveraddr, sizeof(serveraddr));

    // 3.listen
    listen(sockfd, 128);
    while(1){
        // 4.accept 阻塞监听客户端链接请求
        addrlen = sizeof(clientaddr);
        confd = accept(sockfd, (struct sockaddr *)&clientaddr, &addrlen);
        printf("confd=%d\n", confd);
        
        // 输出客户端IP地址和端口号
        inet_ntop(AF_INET, &clientaddr.sin_addr.s_addr, ipstr, sizeof(ipstr));
        printf("client ip %s\t port %d\n",
            inet_ntop(AF_INET, &clientaddr.sin_addr.s_addr, ipstr, sizeof(ipstr)),
            ntohs(clientaddr.sin_port));

        // 和客户端交互数据操作confd
        // 5.处理客户端请求

        close(confd);
    }

    close(sockfd);

    exit(0);

}