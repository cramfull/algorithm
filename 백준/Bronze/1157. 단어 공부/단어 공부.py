alphabet = input().upper()
alphabet_count = {}

for i in alphabet:
    if i in alphabet_count:
        alphabet_count[i] += 1
    else:
        alphabet_count[i] = 1

max_count = max(alphabet_count.values())
most_used = []
for key, value in alphabet_count.items():
    if value == max_count:
        most_used.append(key)

if len(most_used) > 1:
    print('?')
else:
    print(most_used[0])