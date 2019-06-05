package com.leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;

public class No353DesignSnakeGame {
    /**
     * Initialize your data structure here.
     *
     * @param width - screen width
     * @param height - screen height
     * @param food - A list of food positions
     * E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    private final int width, height;
    private final int[][] food;
    private int foodIndex;
    private Deque<Position> snake = new LinkedList<>();

    public No353DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;

        snake.add(new Position(0, 0));
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int[] dir = getDir(direction);
        Position head = snake.peek(), next = new Position(head.x + dir[0], head.y + dir[1]);
        if (next.x < 0 || next.x >= height || next.y < 0 || next.y >= width) return -1;
        if (foodIndex < food.length && next.x == food[foodIndex][0] && next.y == food[foodIndex][1]) {
            snake.offerFirst(next);
            foodIndex++;
            return snake.size() - 1;
        }

        snake.pollLast();
        for (Position p : snake) if (p.equals(next)) return -1;
        snake.offerFirst(next);
        return snake.size() - 1;
    }

    private int[] getDir(String direction) {
        switch (direction) {
            case "U":
                return new int[]{-1, 0};
            case "D":
                return new int[]{1, 0};
            case "L":
                return new int[]{0, -1};
            case "R":
                return new int[]{0, 1};
        }

        return new int[]{0, 0};
    }

    class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private boolean equals(Position that) {
            if (that == null) return false;
            return that.x == this.x && that.y == this.y;
        }
    }
}
