# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 요구사항 정리 ✔

### 도메인
####- 자동차
- 이름이 존재함(출력시 이름이 같이 출력됨) 
- 주어진 횟수 n회 동안 전진/멈춤
- 이동 상태를 출력해주기 위해선 이동상태를 가지고 있어야 함.
  - 이동조건
    - 0 ~ 9 사이에서 Random값 구함
    - 이동시 4 이상의 값일 경우 전진
    - 이동시 3 이하의 값일 경우 멈춤(이동X)
- 여러대가 있을 수 있음(최소 1대 이상이어야 함)

####- 우승자
- 여러대의 자동차 중에 우승자를 결정
- 최종 상태 값으로 우승자 선택함 (동점일 경우 공동 우승)

### UI로직
####- 입력
- 자동차 이름 입력은 쉼표(,)를 기준으로 구분하여 가져옴
- 시도할 횟수 입력 받음

####- 결과
- 출력시 시도 횟수별로 이동상태 보여줌
- 완주 후 누가 우승했는지 알려줌 (우숭자는 한 명 이상일 수 있음)
