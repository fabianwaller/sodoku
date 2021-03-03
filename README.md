# Sodoku solver

Based on [this tutorial](https://www.baeldung.com/java-sudoku) 

## Sodoku

Simply put, Sudoku is a combinatorial number placement puzzle with 9 x 9 cell grid partially filled in with numbers from 1 to 9. The goal is to fill remaining, blank fields with the rest of numbers so that each row and column will have only one number of each kind.

What's more, every 3 x 3 subsection of the grid can't have any number duplicated as well. The level of difficulty naturally rises with the number of blank fields in each board.

## What it does

It automatically solves a sodoku game through a simple brute force attack.

**Backtracking algorithm tries to solve the puzzle by testing each cell for a valid solution.**

If there's no violation of constraints, the algorithm moves to the next cell, fills in all potential solutions and repeats all checks.

If there's a violation, then it increments the cell value. Once, the value of the cell reaches 9, and there is still violation then the algorithm moves back to the previous cell and increases the value of that cell. It tries all possible solutions.

## What's the difference with the [original script](https://github.com/eugenp/tutorials/tree/master/algorithms-miscellaneous-2/src/main/java/com/baeldung/algorithms/sudoku)

This is a slightly modified version to learn algorithms and to improve coding for myself. It could be called a playground for some efficency tests.

## How to use

Sodoku solver will get a user input option soon. At the moment you have to clone this repository and change your sodoku in source code directly.