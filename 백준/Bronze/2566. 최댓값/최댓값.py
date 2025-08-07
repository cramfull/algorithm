box99 = [list(map(int, input().split())) for _ in range(9)]

list99 = []

for i in range(9):
    for j in range(9):
        list99.append(box99[i][j])



max_val = max(list99)
print(max_val)
# row_idx = (list99.index(max_val))  // 9 + 1
# col_idx = (list99.index(max_val)) % 9 + 1

'''
2차원 리스트를 1차원 리스트로 변환하지 않고,
바로 2차원에서 인덱싱을 통해 최댓값 반환하는 코드 by. GPT
for i in range(9):
    for j in range(9):
        if box99[i][j] > max_val:
            max_val = box99[i][j]
            row_idx = i + 1
            col_idx = j + 1
'''
found = False
for i in range(9):
    for j in range(9):
        if box99[i][j] == max_val:
            row_idx = i + 1
            col_idx = j + 1
            found = True
            break
    if found:
        break
    # 내부 for문 에서 볼 일이 끝났을 때, 전체 for 문을 break 하는 방식이 인상적임

print(row_idx, col_idx)
    

'''

Special thanks to:

Chat GPT - 각주 처리된 부분 대신 1차원 리스트로 변환 후 탐색하면서 처음 만난 최댓값을 반환해줌
그리고

문제는, 만약 최댓값이 여러 개일 경우, .index()는 첫 번째로 등장한 위치만 반환합니다.
BOJ는 가장 처음 입력에서 등장한 위치가 아니라, 실제로 순서대로 탐색하면서 처음 만난 최댓값의 위치를 요구합니다.

근데 내 코드하고 이거하고 반환 위치가 다른가?
'''