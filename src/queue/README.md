# Queue
![](https://media.geeksforgeeks.org/wp-content/uploads/Circular-queue.png)
* Ring Buffer 로 큐를 만든 모습이다.
* `front 와 rear 값이 같음` 으로는 큐의 상태가 비어 있는지, 아닌지 구분 불가하다.
* 그래서 num 과 max 값의 존재가 필요하다.
* 기본적으로 큐를 구현할 때 `max, front, rear, num` 이 4가지가 필요하다.
