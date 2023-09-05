# Spock 병렬 테스트

코틀린 디렉터리에 정리할까 자바 디렉터리에 정리할까 하다가 자바 디렉터리에 정리하기로 결정했다. Kotlin 을 사용하더라도 거의 비슷하게 작업하면 된다. 



### 참고자료

- [spock 최신버전 docs - https://spockframework.org/spock/docs/](https://spockframework.org/spock/docs/)

- [spock framework - /docs/parallel_execution](https://spockframework.org/spock/docs/2.3/parallel_execution.html)
- [Spock 병렬 테스트하기](https://tw-you.tistory.com/entry/Spock-%EB%B3%91%EB%A0%AC-%ED%85%8C%EC%8A%A4%ED%8A%B8%ED%95%98%EA%B8%B0)

<br>



### dependency

```groovy
dependencies {
    // ...
    testImplementation 'org.apache.groovy:groovy:4.0.6'
    testImplementation 'org.spockframework:spock-core:2.3-groovy-4.0'
}
```

<br>



### SpockConfig.groovy

프로젝트 또는 하위 모듈 내의 src/test/resources 디렉터리 내에 아래의 내용을 작성해주자.

groovy 파일이기에 확장자를 `.groovy` 로 지정해서 저장하면 된다.

예를 들면 아래와 같이 설정할 수 있다.

`SpockConfig.groovy`

```groovy
runner {
    parallel{
        enabled true
    }
}
```



자세한 옵션의 내용들은 [spock framework - /docs/parallel_execution](https://spockframework.org/spock/docs/2.3/parallel_execution.html) 의 옵션들을 참고해서 수정해주자.

<Br>







