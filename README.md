📘 DoHyun Algorithm Repository – EVA 개인 레포

최소 하루 1문제 · 오답 회차 관리(W1~W3) · Issue & PR 기반 복습 · 코드 리뷰
이 레포는 개인 알고리즘 문제 풀이 및 성장 기록 관리를 위한 공간입니다.

## 📂 디렉토리 구조 및 브랜치 전략 ### 디렉토리 구조 아래 구조는 **백준/프로그래머스 + 오답 회차 + 유형별 정답**까지 관리하기 위한 표준입니다. (개인의 편의를 위해 세부 사항은 조정될 수 있습니다.)

```
solved/
├── boj/
│   ├── wrong-1/
│   ├── wrong-2/
│   ├── wrong-3/
│   └── solved/
│    ├── greedy/
│     ├── bfs/
│     ├── dfs/
│     └── ...
└── programmers/
    ├── wrong-1/
    ├── wrong-2/
    ├── wrong-3/
    └── solved/
      ├── greedy/
      ├── bfs/
      ├── dfs/
      └── ...
```

### 브랜치 전략

- main — 최종 정리본
- solved — 맞춘 문제 관리
- wrong-1 — 첫 번째 오답
- wrong-2 — 두 번째 오답
- wrong-3 — 세 번째 오답

### 문제 단위 작업 브랜치

- BOJ: boj/<문제번호> 예) boj/1123
- Programmers: prog/<문제번호> 예) prog/1103

---

## 문제 풀이 Flow

1. 문제 시도

- boj/1123 브랜치 생성

2. 틀렸다면 → 오답 PR 제출

- 1회차 오답 -> wrong-1 브랜치로 PR
- PR 머지 후 Issue 생성 - ex) [W1] BOJ 1102

3. 일정 기간 후 재도전

4. 재도전에서도 틀렸다면

- wrong-2, wrong-3 순으로 PR 제출
- 각 PR 후 Issue 갱신

5. 정답 맞추면

- solved 브랜치로 PR
- 파일을 유형별 폴더로 이동
