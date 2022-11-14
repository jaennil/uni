import tkinter
import time


def createGrid(cellSize, padding):
    for y in range(3):
        grid.append([])
        for x in range(3):
            grid[y].append(
                canvas.create_rectangle(
                    x * cellSize + x * padding,
                    y * cellSize + y * padding,
                    x * cellSize + x * padding + cellSize,
                    y * cellSize + y * padding + cellSize,
                )
            )


def getScreenResolution(tkinterTkWindow):
    return tkinterTkWindow.winfo_screenwidth(), tkinterTkWindow.winfo_screenheight()


def outputTwoDimensionalArray(array):
    for i in array:
        for j in i:
            print(j, end=" ")
        print()
    print("---")


def createCrossAtCoords(x, y, size):
    canvas.create_line(x - 50, y - 50, x + 50, y + 50, tags="lines")
    canvas.create_line(x - 50, y + 50, x + 50, y - 50, tags="lines")


def createOvalAtCoords(x, y, size):

    canvas.create_oval(x - 50, y - 50, x + 50, y + 50, tags="lines")
    canvas.create_oval(x - 50, y + 50, x + 50, y - 50, tags="lines")


class PatchedCanvas(tkinter.Canvas):
    def unbind(self, sequence, funcid=None):
        '''
        See:
            http://stackoverflow.com/questions/6433369/
            deleting-and-changing-a-tkinter-event-binding-in-python
        '''

        if not funcid:
            self.tk.call('bind', self._w, sequence, '')
            return
        func_callbacks = self.tk.call(
            'bind', self._w, sequence, None).split('\n')
        new_callbacks = [
            l for l in func_callbacks if l[6:6 + len(funcid)] != funcid]
        self.tk.call('bind', self._w, sequence, '\n'.join(new_callbacks))
        self.deletecommand(funcid)


def mouseClickHandle(event):
    global move
    global movesCnt
    x, y = clickToCellCoords(event.x, event.y)
    if moves[y][x] is None:
        movesCnt += 1
        moves[y][x] = move
        if move:
            createOvalAtCoords((x + 1) * 100 - 50, (y + 1) * 100 - 50, ...)
        else:
            createCrossAtCoords((x + 1) * 100 - 50, (y + 1) * 100 - 50, ...)
        outputTwoDimensionalArray(moves)
        if checkWinCondition():
            if move:
                print("zero wins")
            else:
                print("cross wins")
            canvas.unbind("<Button-1>")
            print("restart after 3 second")
            canvas.after(3000, restartGame)
        if movesCnt == 9:
            print("nichya")
            print("restart after 3 seconds")
            canvas.bind("<Button-1>")
            canvas.after(3000, restartGame)

        move = not move
    else:
        print("cell filled")


def restartGame():
    moves.clear()
    for i in range(3):
        moves.append([])
        for j in range(3):
            moves[i].append(None)
    canvas.delete("lines")
    canvas.bind("<Button-1>", mouseClickHandle)


def clickToCellCoords(x, y):
    return x // 100, y // 100


def checkWinCondition():
    for y in range(3):
        if moves[y][0] is None or moves[y][1] is None or moves[y][2] is None:
            continue
        if moves[y][0] == moves[y][1] and moves[y][1] == moves[y][2]:
            return True

    for x in range(3):
        if moves[0][x] is None or moves[1][x] is None or moves[2][x] is None:
            continue
        if moves[0][x] == moves[1][x] and moves[1][x] == moves[2][x]:
            return True
    if (
        moves[0][0] is not None
        and moves[1][1] is not None
        and moves[2][2] is not None
        and moves[0][0] == moves[1][1]
        and moves[1][1] == moves[2][2]
    ):
        return True

    if (
        moves[2][0] is not None
        and moves[1][1] is not None
        and moves[0][2] is not None
        and moves[2][0] == moves[1][1]
        and moves[1][1] == moves[0][2]
    ):
        return True
    return False


grid = []
moves = [[None for _ in range(3)] for z in range(3)]
move = False
movesCnt = 0
window = tkinter.Tk()
window.bind("<Button-1>", mouseClickHandle)
screenWidth, screenHeight = getScreenResolution(tkinterTkWindow=window)
windowWidth = screenWidth // 3
windowHeight = screenHeight // 3
screenWidthCenter = screenWidth // 2
screenHeightCenter = screenHeight // 2
window.geometry(
    f"{windowWidth}x{windowHeight}+{screenWidthCenter}+{screenHeightCenter}"
)
window.title("tic tac toe")
canvas = PatchedCanvas(width=windowWidth, height=windowHeight, bg="pink")
canvas.grid()
createGrid(cellSize=100, padding=0)
window.mainloop()
