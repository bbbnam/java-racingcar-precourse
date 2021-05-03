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
- 여러대가 있을 수 있음(레이싱이 되려면 최소 2대 이상이어야 함)
- name, position은 원시값으로 포장해야 하는 부분
- 예외 : 
> 자동차 이름은 5자 이하만 가능  
> 이동상태 값은 음수가 될 수 없음  

####- 자동차들(자동차의 일급컬렉션 객체)
- 이 컬렉션에 속하는 자동차들을 동시에 같이 시도횟수에 따라 움직일수도 멈출수도 있는 기회를 부여받음
- 자동차들 중에 이동상태가 가장 큰 차를 찾을 수 있음
- 자동차들 중에 같은 이동상태인 차들을 찾을 수 있음
- 예외 : 
> 자동차들 객체는 적어도 2대 이상의 차량을 가지고 있어야 함(그래야 레이싱이 성립)

####- 우승자
- 여러대의 자동차 중에 우승자를 결정
- 최종 상태 값으로 우승자 선택함 (동점일 경우 공동 우승)

####- 게임실행
- 게임 객체는 자동차 이름과 시도 횟수를 받아서 게임을 진행
- 예외 : 
> 자동차 이름은 2개 이상이어야 함  
> 시도 횟수는 음수일 수 없음

### UI로직
####- 입력
- 자동차 이름 입력은 쉼표(,)를 기준으로 구분하여 가져옴
- 시도할 횟수 입력 받음

####- 결과
- 출력시 시도 횟수별로 이동상태 보여줌
- 완주 후 누가 우승했는지 알려줌 (우숭자는 한 명 이상일 수 있음)
