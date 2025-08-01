
def bfs(a, b):
    global house_count

    visited[a][b] = 1
    que = [[a,b]]

    while que:
        x, y = que.pop(0)
        for i,j in move:
            if 0<=x+i<n and 0<=y+j<n:
                if graph[x+i][y+j] == 1 and visited[x+i][y+j] == 0:
                    que.append([x+i,y+j])
                    visited[x+i][y+j] = 1
                    house_count+=1

n = int(input())

graph = [[0] * n for _ in range(n)]
visited = [[0] * n for _ in range(n)]
move = [[-1,0],[1,0],[0,-1],[0,1]]
house = 0
cnt = []

for i in range(n):
    temp = list(map(int, input()))
    for j in range(n):
        graph[i][j] = temp[j]

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1 and visited[i][j] == 0:
            house_count = 0
            bfs(i,j)
            house+=1
            cnt.append(house_count)

cnt = sorted(cnt)
print(house)
for i in range(len(cnt)):
    print(cnt[i]+1)

# print(f'테스트 {graph[-1][1]}')