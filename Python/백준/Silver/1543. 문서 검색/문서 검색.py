import sys

input = sys.stdin.readline


import sys

document = sys.stdin.readline().rstrip()
word = sys.stdin.readline().rstrip()

count = 0
start_index = 0
word_len = len(word)
doc_len = len(document)

while True:
    found_index = document.find(word, start_index)

    if found_index == -1:
        break

    count += 1
    start_index = found_index + word_len

print(count)
