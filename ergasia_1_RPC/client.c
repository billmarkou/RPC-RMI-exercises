#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>

void error(char *msg)
{
  perror(msg);
  exit(0);
}

int main(int argc, char *argv[])
{
  int sockfd, portno, n, numOfProccess, arrayLenght;

  struct sockaddr_in serv_addr;
  struct hostent *server;

  char buffer[256];
  int intbuffer[1], data[1];
  if (argc < 3)
  {
    fprintf(stderr, "usage %s hostname port\n", argv[0]);
    exit(0);
  }
  portno = atoi(argv[2]);
  sockfd = socket(AF_INET, SOCK_STREAM, 0);
  if (sockfd < 0)
    error("ERROR opening socket");
  server = gethostbyname(argv[1]);
  if (server == NULL)
  {
    fprintf(stderr, "ERROR, no such host\n");
    exit(0);
  }
  bzero((char *)&serv_addr, sizeof(serv_addr));
  serv_addr.sin_family = AF_INET;
  bcopy((char *)server->h_addr,
        (char *)&serv_addr.sin_addr.s_addr,
        server->h_length);
  serv_addr.sin_port = htons(portno);
  if (connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    error("ERROR connecting");

  bzero(buffer, 256);

  printf("Process number: ");
  fgets(buffer, 255, stdin);

  int processNumber = atoi(buffer);

  bzero(buffer, 256);

  printf("Enter array length: ");
  fgets(buffer, 255, stdin);

  int len = atoi(buffer);
  bzero(buffer, 256);

  int *numbers = (int *)malloc(sizeof(int) * len);

  for (int i = 0; i < len; i++)
  {
    printf("Enter number %d: ", i + 1);
    fgets(buffer, 255, stdin);

    numbers[i] = atoi(buffer);
    bzero(buffer, 256);
  }

  int multiplier = 0;
  if (processNumber == 3) {
    printf("Enter multiplier: ");
    fgets(buffer, 255, stdin);

    multiplier = atoi(buffer);
    bzero(buffer, 256);
  }

  // printf("Input Array: ");
  // fgets(buffer, 255, stdin);
  char* cursor = buffer; 

  *cursor = processNumber; 
  cursor += sizeof(int);

  *cursor = multiplier; 
  cursor += sizeof(int);

  *cursor = len; 
  for (int i = 0; i < len; i++) {
    cursor += sizeof(int);
    *cursor = numbers[i]; 
  }

  n = write(sockfd, buffer, (len + 3) * sizeof(int)); 

  bzero(buffer, 256);
 

  n = read(sockfd, buffer, 256);
  
  if (processNumber == 1) {
    printf("\n %d \n", (int)(*buffer));
  } else if (processNumber == 2) {
    int min = buffer[0];
    int max = (buffer + sizeof(int))[0];

    printf("min %d max %d \n", min, max);
  } else if (processNumber == 3) {
    char *cur = buffer;
    int arrLen = cur[0];

    int* resNumbers = (int *)malloc(sizeof(int) * arrLen);
    
    
    for (int i = 0; i < arrLen; i++) {
      cur += sizeof(int);
      resNumbers[i] = cur[0];
    }
  
    for (int i = 0; i < arrLen; i++) {  
      printf("%d\n", resNumbers[i]);
    }

  } 
  
  
  // n = write(sockfd,buffer,strlen(buffer));

  // if (n < 0)
  //      error("ERROR reading from socket");

  return 0;
}
