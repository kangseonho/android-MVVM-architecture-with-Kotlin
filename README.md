메모

commit 내용: TDD 마무리

1. Gradle에 androidx.core:core-ktx 라이브러리 버전을 1.6.0으로 추가 시 kotlin 라이브러리 버전도 1.5.x 버전으로 업그레이드 됨, 따라서 해당 프로젝트 plugin은 kotlin 1.4.32이기 때문에 kotlin.collection 사용 중 에러 발생.

- androidx.core:core-ktx 라이브러리 버전을 1.5.0 으로 낮춰서 해결 완료.
