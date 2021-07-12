# 트리
* [트리](#트리)
  * [트리 관련 용어](#트리-관련-용어)
  * [트리는 재귀적 자료구조](#트리는-재귀적-자료구조)
  * [트리를 저장하려면 코드로 어떻게 표현해야 할까?](#트리를-저장하려면-코드로-어떻게-표현해야-할까?)
  * [트리의 용도](#트리의-용도)
* [이진 탐색 트리](#이진-탐색-트리)
  * [이진 트리 ➜ 이진 탐색 트리](#이진-트리-➜-이진-탐색-트리)
  * [BST 탐색](#BST-탐색)
  * [BST 삽입 방법](#BST-삽입-방법)
  * [BST 삭제 방법](#BST-삭제-방법)
* [트리 순회](#트리-순회)

# 트리
## 트리 관련 용어

* 노드(node): 실제로 저장하는 데이터
* 루트(root) 노드: 최상위에 위치한 데이터
* 리프(leaf) 노드: 마지막에 위치한 데이터들
* 부모-자식: 연결된 노드들 간의 상대적 관계
* 깊이(depth): 노드 ➜ 루트 경로의 길이
    * 9는 깊이가 2이다. 4는 깊이가 0이다.
<img src="./images/image-20210707054314951.png" alt="image-20210707054314951" width="400"/>

* 높이(height): 노드 ➜ 리프 경로의 최대 길이
    * 노드 5의 높이는 2이다.
    * 어떤 노드의 높이가 아닌, 트리의 높이를 물어보면 루트 노드의 높이를 물어보는 것과 같다.

<img src="./images/image-20210707054643385.png" alt="image-20210707054643385"  width="400" />

* 하위 트리(subtree): 어떤 노드 아래의 모든 것을 포함하는 트리
    * 하위 트리 그 자체가 트리 ➜ 트리가 **재귀적으로 작동하기 좋은 자료구조**라는 걸 알 수 있다.

<img src="./images/image-20210707060619519.png" alt="image-20210707060619519"  width="400"/>



## 트리는 재귀적 자료구조

<img src="./images/image-20210707061413288.png" alt="image-20210707061413288"  width="400" />

* 4 + 왼쪽 subtree 의 총합 + 오른쪽 subtree의 총합 .. ➜ 이렇게 재귀적으로 더해나갈 수 있다.



## 트리를 저장하려면 코드로 어떻게 표현해야 할까?

### 1) 일반적인 트리

```java
public class Node {
  public int data;
  public ArrayList<Node> children; // hashMap 으로 구현해도 되고.. 마음대로
}
```

### 2) 이진 트리

```java
public class Node {
  public int data;
  public Node left;
  public Node right;
}
```

### 3) 자식이 최대 하나인 트리

```java
public class Node {
  public int data;
  public Node child;
}
```

➜ 자식이 최대 하나인 트리는 연결 리스트이다. 연결 리스트는 결국 트리에서 좀 더 제약을 가한 자료구조이다. 
<img src="./images/image-20210707063053466.png" alt="image-20210707063053466"  height="200" width="400" />
<br/>

## 트리의 용도

* 계층적 데이터를 표현
    * HTML 이나 XML 의 문서 개체 모델(DOM) 을 표현
    * JSON 이나 YAML 처리 시 계층 관계를 표현
    * 프로그래밍 언어를 표현하는 추상 구문 트리(abstract syntax tree)
    * 인간 언어를 표현하는 파싱 트리(parsing tree)
* 검색 트리를 통해 효율적인 검색 알고리듬 구현 가능
* 그 외 다수

# 이진 탐색 트리
## 이진 트리 ➜ 이진 탐색 트리

* 자식이 최대 둘
  * 왼쪽/오른쪽 자식
* 이진트리는 무언가 계층적(재귀적)으로 이분해 나갈 때 적합
* 그 무언가를 이분하는 기준을 만든다면 어떨까?
  * 그 기준에 따라 특화된 이진 트리를 만들 수 있음
  * 그에 따라 보다 효율적인 알고리듬 고안 가능
  * 이에 따라 이진 탐색 트리(BST) 가 등장함



## 이진 탐색 트리(BST)

* 이진 트리에 이분하는 규칙을 추가
  * 왼쪽 자식은 언제나 부모보다 작다
  * 오른쪽 자식은 언제나 부모보다 크다

* BST는 "정렬된 트리"이다.
  * why? 재귀적으로 읽는 순서만 지키면 된다.
  * 정렬된 자료구조의 이점 - 정렬된 자료구조에 특화된 효율적인 알고리듬 사용 가능



## 순서대로 BST 읽기

* 루트 노드부터 시작
* 다음 단계를 재귀적으로 실행 (중위 순회법)
  * 왼쪽 하위 트리의 노드를 나열
  * 내 노드를 나열
  * 오른쪽 하위 트리의 노드를 나열

<img src="./images/image-20210707065604502.png" alt="image-20210707065604502"  width="400"/>



## BST 탐색

* 재귀적으로 분할 정복해 나가기 때문에, 기본적으로 이진 탐색과 동일
* 이진 탐색과의 차이점
  * 각 노드마다 두 하위 트리로 이분됨
* 하위 트리로 내려갈 때마다 검색 공간이 절반씩 줄어듦
  * *O(log n)*
* 최악의 경우는, 사실상 연결 리스트 모양.
  * *O(n)*

<img src="./images/image-20210708041423917.png" alt="image-20210708041423917"  width="400"/>



## BST 탐색 코드

```java
// 이진 탐색 코드와 굉장히 유사한 걸 알 수 있다.
public static Node getNodeOrNull(Node node, int data) {
  if (node == null) {
    return null;
  }
  if (node.data == data) {
    return node;
  }
  if (data < node.data) {
    return getNodeOrNull(node.left, data);
  }
  return getNodeOrNull(node.right, data);
}
```



## BST 삽입 방법

1. 새로운 노드를 받아줄 수 있는 부모 노드를 찾음
  * 트리를 내려가는 방법은 탐색과 같음
  * 새로운 노드를 받아줄 수 있는 부모란?
    * 오른쪽 하위 트리로 내려가야 하는데 오른쪽 자식이 없는 부모
    * 왼쪽 하위 트리로 내려가야 하는데 왼쪽 자식이 없는 부모
2. 그 후, 거기에 자식으로 추가

➜ 시간복잡도: *O(Log n)*



## BST 삭제 방법

* BST 는 정렬된 배열과 개념상 같다고 했음
  * 중위 순회를 하면 정렬된 배열이 나옴
* 따라서 노드를 삭제한 뒤에도 올바른 BST를 유지하려면?
  * 정렬된 배열에서 값을 하나 삭제하듯이 처리
* 트리에서 뭔가를 지울 때 언제나 리프를 지움 ⇢ 실세계에서 나무를 정리할 때도 가지부터 치는 것과 마찬가지 원리

### 여기서 10을 지우려면?

* 오른쪽 하위 트리에서 최솟값 (제일 왼쪽 리프)  "in-order successor"
* 왼쪽 하위 트리에서 최댓값 (제일 오른쪽 리프)  "in-order predecessor"

<img src="./images/image-20210708052337963.png" alt="image-20210708052337963"  width="400"/>



### BST 노드 삭제 전략

1. 지울 값을 가지고 있는 노드를 찾음
2. 그 바로 전 값을 가진 노드를 찾음
  * 왼쪽 하위 트리의 제일 오른쪽 리프
3. 두 값을 교환
4. 리프 노드를 삭제

![image-20210708052753532](./images/image-20210708052753532.png)






# 트리 순회(tree traversal)
> 대표적인 3가지 트리 순회법
>
> * 전위 순회
> * 중위 순회
> * 후위 순회



## 1. 대표적인 3가지 트리 순회법

### 1-1. 전위순회 (Preorder Traversal)

방문순서 : `root → left → right`<br/>
<img src="./images/preorder.jpeg" alt="preorder"  width="400" /> <br/>
`1 → 2 → 4 → 5 → 3`
<br/><br/><br/>

### 1-2. 중위순회 (Inorder Traversal)

방문순서 : `left → root → right`<br/>
<img src="./images/inorder.jpeg" alt="preorder"  width="400" /> <br/>
`4 → 2 → 5 → 1 → 3`
<br/><br/><br/>

### 1-3. 후위순회 (Postorder Traversal)

방문순서 : `left → right → root`<br/>
<img src="./images/postorder.jpeg" alt="preorder"  width="400" /> <br/>
`4 → 5 → 2 → 3 → 1`
<br/><br/><br/>

### 중위 순회 코드를 간단히 살펴보자.

```java
// 재귀적으로 확실히 깔끔하게 구현 가능
public static void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.left);
        System.out.println(node.data);
        traverseInOrder(node.right);
    }
```



## 2. 전위 순회의 용도

### 2-1. 트리를 복사하는 경우

* 부모가 있어야 자식도 추가할 수 있음, 따라서 전위 순회가 적합
* 다른 순회는 부모가 중간 혹은 마지막에 오므로 트리를 복사한다고 생각했을 때, 직관적이지 않음 (물론 다른 순회로도 복사는 가능하다)

### 2-2. 수식의 전위 표기법

* 수식은 보통 *중위 표기법*을 사용한다.
    * 괄호로 우선 순위를 정해줄 수 있음
    * 아래 그림의 트리를 중위 순회하면 다음과 같은 수식이 나온다.
        * *A X (B-C) - (D+E)*

<img src="./images/image-20210706070606036.png" alt="image-20210706070606036"  width="400" />

* 전위 표기법 (prefix notation)
    * 폴란드 표기법 (Polish notation) 이라고도 불림
    * 연산자/괄호의 우선 순위가 없음 (읽는 순서대로)
    * 따라서 컴퓨터로 계산하기 좀 더 편함

* 위 예는 후위 순회로 더 쉽게 구현이 가능하다.

    * 앞에서부터 읽으면서 스택에 집어넣으면 된다

      ​	<a href="https://www.codecogs.com/eqnedit.php?latex=\bg_white&space;-\times&space;A-BC-&plus;DE" target="_blank"><img src="https://latex.codecogs.com/gif.latex?\bg_white&space;-\times&space;A-BC-&plus;DE" title="-\times A-BC-+DE" /></a>

* 후위 표기법 (postfix notation) 이라고 한다.

    * 역 폴란드 표기법 (reverse Polish notation)

      <img src="https://latex.codecogs.com/gif.latex?\bg_white&space;ABC&space;-&space;\times&space;DE&space;&plus;-" title="ABC - \times DE +-" />



## 3. 전위/중위/후위 순회 - 간단한 가이드

* 앞에서 본 예 외에도 알고리듬에 따라 셋 중 하나를 사용한다.
* 간단한 가이드
    * 리프보다 루트를 먼저 봐야 한다면 전위 순회
    * 리프를 다 본 다음에 다른 노드를 봐야 한다면 후위 순회
    * 순서대로 봐야 한다면 중위 순회













