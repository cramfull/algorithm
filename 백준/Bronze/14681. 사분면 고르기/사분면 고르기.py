X = int(input())
Y = int(input())
if X > 0 and Y > 0:
    quadrant = 1
elif X > 0 and Y < 0:
    quadrant = 4
elif X < 0 and Y > 0:
    quadrant = 2
elif X < 0 and Y < 0:
    quadrant = 3
print(quadrant)