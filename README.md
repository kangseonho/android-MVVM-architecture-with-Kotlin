commit Title: TDD 마무리

1. Gradle에 androidx.core:core-ktx 라이브러리 버전을 1.6.0으로 추가 시 kotlin 라이브러리 버전도 1.5.x 버전으로 업그레이드 됨, 따라서 해당 프로젝트 plugin은 kotlin 1.4.32이기 때문에 kotlin.collection 사용 중 에러 발생.

- androidx.core:core-ktx 라이브러리 버전을 1.5.0 으로 낮춰서 해결 완료.


-------------------------------------------------------------------------------------------------


commit Title: list update 테스트 추가

1. UnitTest 중, 

java.lang.NullPointerException
at android.arch.core.executor.DefaultTaskExecutor.isMainThread(DefaultTaskExecutor.java:58)
at android.arch.core.executor.ArchTaskExecutor.isMainThread(ArchTaskExecutor.java:116)

해당 에러 발생. 테스트 환경에서 아직 구현되지 않은 MainThread를 호출하려고 해서 발생한듯.

- @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    
다음과 같이 InstantTaskExecutorRule() 메소드로 MainThread 호출을 제거하여 해결 완료.
