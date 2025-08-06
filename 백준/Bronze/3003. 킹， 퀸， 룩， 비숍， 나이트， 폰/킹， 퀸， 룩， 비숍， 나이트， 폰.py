current = list(map(int, input().split()))
alright = [1, 1, 2, 2, 2, 8]
answer = []
for i in range(len(alright)):
    answer.append(alright[i] - current[i])
print(' '.join(str(i) for i in answer))
