finish = False
flagNum = 1
flagch = "*"
x = 0
y = 0
print("\033[1;37m---------简易五子棋游戏（控制台版）---------\033[0m")

checkerboard = []
for i in range(10):
    checkerboard.append([])
    for j in range(10):
        checkerboard[i].append("+")

while not finish:
    print("   0  1  2  3  4  5  6  7  8  9")
    for i in range(len(checkerboard)):
        print(chr(i + ord("A")) + " ", end = " ")
        for j in range(len(checkerboard[i])):
            print(checkerboard[i][j] + " ", end = " ")
        print()
    
    if flagNum == 1:
        flgch = "*"
        print("\033[1;37m请[*]输入棋子坐标（例如A0）：\033[0m")
    else:
        flagch = 'o'
        print("\033[1;35m请[o]输入棋子坐标（例如A0）：\033[0m")
    
    str = input()
    ch = str[0]
    x = ord(ch) - 65
    y = int(str[1])
    
    if checkerboard[x][y] == "+":
        if flagNum == 1:
            checkerboard[x][y] = "*"
        else:
            checkerboard[x][y] = "o"
    else:
        print("\033[1;31m您输入的位置已经有其他棋子了，请重新输入！\033[0m")
        continue
    
    flagNum *= -1
