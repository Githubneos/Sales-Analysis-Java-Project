
# Design – Sales Analysis

## Problem Description

**What problem does the program solve?**
It finds the best stretch of consecutive months for a computer company. "Best" means the stretch with the highest combined sales change compared with last year. A stretch can be one month, several months in a row, or the whole year.

**What data does the program receive?**
Twelve monthly sales-change values (in USD millions) and the month names Jan to Dec. A positive number is an increase and a negative number is a decrease. The data is written directly into the program.

**What result should it produce?**
- The starting month of the best stretch
- The ending month of the best stretch
- The total sales change for that stretch

For the given data, the answer should be **Jan to Oct, total 62**.

## Data Design

**Month names:** stored in a `String[] months` array.

**Sales values:** stored in a `double[] salesChange` array.

**How the arrays connect:** both arrays have 12 items, so the same index points to the same month in each one. For example, index 2 is `months[2]` = "Mar" and `salesChange[2]` = 15.

**Variables:**

| Variable | What it does |
|---|---|
| `start` | where the stretch being checked begins |
| `end` | where the stretch being checked ends |
| `runningTotal` | the total of the stretch from `start` to `end` |
| `bestTotal` | the highest total found so far |
| `bestStart` | the start index of the best stretch so far |
| `bestEnd` | the end index of the best stretch so far |

**Remembering the best start and end:** when `runningTotal` is higher than `bestTotal`, the program saves the current `start` and `end` into `bestStart` and `bestEnd`. At the end, `months[bestStart]` and `months[bestEnd]` give the month names to print.

**Ties:** the program only replaces the best stretch when the new total is strictly greater (`>`). If a later stretch has the same total, it is ignored, so the first one found is kept.

**All negative values:** the best total starts as the first month's value. Adding more negative months only makes the total lower, so the single month closest to zero ends up as the best.

## Program Organization

| Method | What it does |
|---|---|
| `main` | creates the arrays and calls the other methods |
| `findBestPeriod` | checks every consecutive stretch and returns the best start and end |
| `sumRange` | adds up the values from the start index to the end index |
| `displayResults` | prints the start month, end month, and total |

## Program Flow

1. Create the `months` and `salesChange` arrays.
2. Pick a start month.
3. Move the end month forward one at a time, adding each value to the running total.
4. If the running total beats the best total, save the total and the start and end indices.
5. Repeat for every start month.
6. Print the start month, end month, and total.
