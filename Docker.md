# Docker

## Docker의 기본개념
- OS 위에 컨테이너를 올려 어플리케이션을 활용 (가상화)
- OS 별로 모두 달랐던 IDE 같은 상황에서 벗어날 수 있다.
- DOCKER위에 일정한 규격의 컨테이너가 올라간다면 모두 사용할 수 있다.

## 이전의 가상화 기술
| Application |
| ----------- |
| 라이브러리  |
| Guest OS    |
| Hypervisor  |
| Host OS     |
| Hardware |

- 위의 그림 에서 DOCKER로  

| Application |
| ----------- |
| 라이브러리  |
| Host OS     |
| Hardware |

- 이전의 가상화 기술에 비하여 훨씬 가볍다.

## Spring에서의 Docker

- 오직 Spring만을 이용해서 웹 서버를 구현하는 것이 아니다.
- MySQL : 관계형 데이터베이스 소프트웨어
- Redis : Key-Value 데이터베이스 소프트웨어
- RabbitMQ : 메시지 브로커
- 서로 다른 다양한 소프트웨어가 여러 하드웨어와 OS에서 설정이 다르다.
- 이들을 일일이 모두 설치하면서 문제를 해결하기는 매우 힘들다.
> 즉, 웹 어플리케이션 개발에 필요한 다양한 소프트웨어의 설치를 간소화 해준다.  


## Docker CLI

- docker --help
- CLI에서의 docker 명령어들을 볼 수 있다.
- docker --version

간단한 이미지를 받고 사용하기

```bash
docker run -d -p 80:80 docker/getting-started
```
- docker : Docker Deamon에 요청을 보낸다.
- run : 컨테이너 실행
- -d : Detached, 컨테이너를 background에서 실행하는 옵션
- -p : Port, 컨테이너의 포트를 물리 서버의 포트와 연결한다.
- docker/getting-started : 컨테이너로 실행할 이미지 이름

```bash
docker rm -f Container name
```

- 컨테이너 삭제