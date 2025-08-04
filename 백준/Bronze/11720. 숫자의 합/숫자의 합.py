N = int(input())
number = input()
list(number)
result = 0
for i in range(N):
    result += int(number[i])
print(result)