#include <stdio.h>
#include <stdlib.h>
#include <arpa/inet.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>

int main(int argc, char *argv[])
{
    printf("udp");
    struct sockaddr_in server_addr;
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(9000);
    inet_pton(AF_INET, "192.168.127.1", &server_addr.sin_addr.s_addr);

    // create socket
    int sock_fd = socket(AF_INET, SOCK_DGRAM, 0);
    printf("sock_fd = %d\n", sock_fd);
    if (sock_fd < 0)
    {
        perror("socket()");
    }

    while (1)
    {
        char buf[128] = "";
        fgets(buf, sizeof(buf), stdin);
        buf[strlen(buf) - 1] = 0;
        sendto(sock_fd, buf, strlen(buf), 0, (struct sockaddr *) &server_addr, sizeof(server_addr));
        char read_buf[128] = "";
        recvfrom(sock_fd, read_buf, sizeof(read_buf), 0, NULL, NULL);
        printf("%s\n", read_buf);
    }

    exit(0);
}