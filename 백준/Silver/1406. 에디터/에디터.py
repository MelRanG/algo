import sys
s = list(sys.stdin.readline().strip())
n = int(input())
stack = []
for i in range(n):
    x = sys.stdin.readline()
    op = x[0]
    if op == 'L':
        if s:
            stack.append(s.pop())
    elif op == 'D':
        if stack:
            s.append(stack.pop())
    elif op == 'P':
        s.append(x[2])
    elif op == 'B':
        if s:
            s.pop()
print(''.join(s + stack[::-1]))
