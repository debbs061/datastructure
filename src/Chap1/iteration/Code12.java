import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private boolean[][] visited;
    int n, m, x, y;
    Queue nodes = new LinkedList<>();

    public int solution(int n, int m, int x, int y) {
        visited = new boolean[n + 1][m + 1];
        this.n = n;
        this.m = m;
        this.x = x;
        this.y = y;
        if (x < 0 || y < 0 || x > n || y > m) return -1;
        return start();
    }

    private int start() {
        Node node = new Node(0, 0, 0, 0);
        nodes.add(node);
        visited[0][0] = true;
        while (!nodes.isEmpty()) {
            Node temp = (Node) nodes.poll();
            int nowX = temp.x;
            int nowY = temp.y;
            int direction = temp.direction;
            int order = temp.order;
            if (nowX == x && nowY == y) return temp.order;
            if (act1(nowX, nowY, direction, order)) return order + 1;
            if (act2(nowX, nowY, direction, order)) return order + 1;
            act3(nowX, nowY, direction, order);
        }
        return -1;
    }

    private boolean act1(int nowX, int nowY, int direction, int order) {
        direction = direction % 4;
        int nextX = nowX;
        int nextY = nowY;
        switch (direction) {
            case 0:
                nextX++;
                break;
            case 1:
                nextY--;
                break;
            case 2:
                nextX--;
                break;
            case 3:
                nextY++;
                break;
        }
        return checkAndAdd(direction, order, nextX, nextY);
    }

    private boolean act2(int nowX, int nowY, int direction, int order) {
        direction = direction % 4;
        int nextX = nowX;
        int nextY = nowY;
        switch (direction) { // 오른쪽 회전 후 이동
            case 0:
                nextY--;
                break;
            case 1:
                nextX--;
                break;
            case 2:
                nextY++;
                break;
            case 3:
                nextX++;
                break;
        }
        return checkAndAdd(direction, order, nextX, nextY);
    }

    private boolean checkAndAdd(int direction, int order, int nextX, int nextY) {
        if (check(nextX, nextY)) {
            if (nextX == n && nextY == m) return true;
            nodes.add(new Node(nextX, nextY, direction + 1, order + 1));
            visited[nextX][nextY] = true;
        }
        return false;
    }

    private void act3(int nowX, int nowY, int direction, int order) {
        nodes.add(new Node(nowX, nowY, direction + 1, order + 1));
    }

    private boolean check(int x, int y) {
        if (x < 0 || y < 0 || x > n || y > m || visited[x][y]) return false;
        return true;
    }
}

class Node {
    public int x;
    public int y;
    public int direction; // 0 = 오른쪽, 1 = 아래, 2 = 왼쪽, 3 = 위
    public int order;

    public Node(int x, int y, int direction, int order) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.order = order;
    }
}