n = int(input())

graph = [[0]*n for _ in range(n)]

move = [[-1,0],[1,0],[0,1],[0,-1]]
start, end = 1, 0
safe_zone = []

for i in range(n):
    temp = list(map(int, input().split()))
    for j in range(n):
        graph[i][j] = temp[j]
        start, end = 1, max(end,temp[j])
        
def bfs(a, b):
    global safe
    visited[a][b] = 1
    que = [[a,b]]
    while que:
        x, y = que.pop(0)
        for i,j in move:
            if 0<= i+x <n and 0<= y+j <n:
                if graph[i+x][y+j] >=p and visited[i+x][j+y] == 0:
                    que.append([i+x, y+j])
                    visited[i+x][y+j] = 1

for p in range(start-1, end+1):
    visited = [[0]*n for _ in range(n)]
    safe = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] >= p and visited[i][j] == 0:
                bfs(i,j)
                safe+=1

    safe_zone.append(safe)

print(max(safe_zone))
