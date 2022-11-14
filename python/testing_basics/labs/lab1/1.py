class Task1:
    def __init__(self):
        with open("test.txt") as f:
            self.inp = [i for i in f.readline().split()]
            self.houses_amount = self.inp[0]
            self.moves = self.inp[1:]

        if self.validate_input():
            self.houses = [[], []]
            for i in range(1, self.houses_amount+1):
                self.houses[i % 2].append(i)
            print(self.do_task())

    def validate_input(self):
        try:
            self.houses_amount = int(self.houses_amount)
        except:
            return print("Format error. Wrong input format")

        for move_index, move in enumerate(self.moves):
            try:
                move = int(move)
            except:
                return print("Format error. Wrong input format")
            else:
                self.moves[move_index] = int(self.moves[move_index])

                if move > self.houses_amount:
                    return print("Input error. House number can't be bigger than amount of houses")

                if move <= 0:
                    return print("Input error. House number can't be less or equal to 0")

        return True

    def calculate_move(self, start, end):
        if start == end:
            return 0
        start_index = self.houses[start % 2].index(start)
        end_index = self.houses[end % 2].index(end)

        if start_index == end_index:
            return 1
        else:
            return abs(start_index - end_index)

    def do_task(self):
        current_pos = 1
        time = 0

        for move in self.moves:
            time += self.calculate_move(current_pos, move)
            current_pos = move
        time += self.calculate_move(current_pos, 1)
        return time


def main():
    task1 = Task1()


if __name__ == "__main__":
    main()
