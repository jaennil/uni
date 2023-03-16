import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    private final Field field;
    private Timer timer;
    private boolean checkEnd = false;
    public Game(Field field) {
        this.field = field;
        createGameLoopTimer();
        startGameControlsHandler();
    }
    private void startGameControlsHandler() {
        while (true) {
            System.out.println("type \"stop\" to stop game, \"resume\" to resume game,\nincrease to increase cell size , decrease to decrease cell size, check to enable game end check");
            String input = scanner.nextLine();
            switch (input) {
                case "stop" -> timer.cancel();
                case "resume" -> createGameLoopTimer();
                case "increase" -> Cell.SIZE += 1;
                case "decrease" -> Cell.SIZE -= 1;
                case "check" -> checkEnd = !checkEnd;
                default -> System.out.println("wrong command");
            }
        }
    }
    public void createGameLoopTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                gameLoop();
            }
        }, 0, 1);
    }

    private void checkEndGame() {
        if (field.allCellsDead()) {
            System.out.println("game end! all cells dead");
            timer.cancel();
        }
        if (field.stateNotChanged()) {
            System.out.println("game end! state not changed");
            timer.cancel();
        }
    }
    public void gameLoop() {
        Cell[][] state = field.clone(field.cells);
        for (int i = 0; i < field.rows; i++) {
            for (int j = 0; j < field.columns; j++) {
                Cell cell = state[i][j];
                ArrayList<Cell> neighbors = field.getNeighbors(cell, state);
                ArrayList<Cell> aliveNeighbors = field.getAliveNeighbors(neighbors);
                Cell newCell = field.cells[i][j];
                if (cell.isAlive()) {
                    if (aliveNeighbors.size() < 2 || aliveNeighbors.size() > 3) {
                        newCell.setDead();
                    }
                } else {
                    if (aliveNeighbors.size() == 3) {
                        newCell.setAlive();
                    }
                }
            }
        }
        field.states.add(state);
        if (checkEnd) checkEndGame();
    }
}
