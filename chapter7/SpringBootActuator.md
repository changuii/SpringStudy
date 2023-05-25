# Spring Boot Actuator


학습목표
- 상용 서비스 준비
- Actuator
- Actuator와 Prometheus


## 상용 서비스 준비

여태까지의 작업은 기능을 제공하는데 집중했다.  


상용서비스에 필요한 내용
- 컴퓨터 메모리 사용량
- 컴퓨터 디스크 공간

서비스가 안정적으로 돌아가는데 필요한 기능  
Spring Boot Actuator  

```gradle
	implementation 'org.springframework.boot:spring-boot-starter-actuator'
	runtimeOnly 'io.micrometer:micrometer-registry-prometheus'
```
종속성 추가  

http://localhost:8080/actuator endpoint가 만들어진다.  

```json
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/actuator",
            "templated": false
        },
        "health": {
            "href": "http://localhost:8080/actuator/health",
            "templated": false
        },
        "health-path": {
            "href": "http://localhost:8080/actuator/health/{*path}",
            "templated": true
        }
    }
}
```

hypermedia as the Engine of Application State  
사용할 수 있는 링크들을 가져온다.  


```yaml
management:
  endpoints:
    enabled-by-default: true
    web:
      exposure:
        include: health, info, loggers
  endpoint:
    health:
      exposure:
        include: health, info, loggers
```





## Actuator와 Prometheus

Prometheus
- 세계적으로 많이 사용하는 모니터링 도구
- 다양한 계측 정보를 HTTP 요청을 통해 받아온다.
- 계측 정보에 대한 내용을 GUI로 표시하고 위험 상황에 대한 알림을 보여준다.  

추가로 Grafana 시각화도구를 같이 사용한다.  

이 prometheus의 endpoint를 actuator에서 제공해준다.  


```yaml
global:
  scrape_interval: 15s
  evaluation_interval: 15s
  
scrape_configs:
  - job_name: 'spring boot scrape'
    metrics_path: '/actuator/prometheus'
    scrape_interval: 1s
    static_configs: 
      - targets: ['host.docker.internal:8080']
```
prometheus.yaml을 최상위 폴더에 생성한다.  



docker 

