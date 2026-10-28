# Pseudocode – Sales Analysis

## Main Program

```
START main
    CREATE months array (Jan to Dec)
    CREATE salesChange array (12 values, same order as months)

    CALL findBestPeriod using salesChange
        -> get bestStart and bestEnd

    CALL sumRange using salesChange, bestStart, bestEnd
        -> get bestTotal

    CALL displayResults using months, bestStart, bestEnd, bestTotal
END main
```

## Find the Best Period

```
FUNCTION findBestPeriod(values)
    SET bestStart = 0
    SET bestEnd = 0
    SET bestTotal = values[0]

    FOR start = 0 to last index
        SET runningTotal = 0

        FOR end = start to last index
            ADD values[end] to runningTotal

            IF runningTotal > bestTotal THEN
                SET bestTotal = runningTotal
                SET bestStart = start
                SET bestEnd = end
            END IF
        END FOR
    END FOR

    RETURN bestStart and bestEnd
END FUNCTION
```

## How It Works

- The **outer loop** picks where a stretch of months starts.
- The **inner loop** moves the end forward one month at a time, so every stretch checked is consecutive.
- `runningTotal` goes back to 0 each time a new start is chosen. Each inner step adds one more month.
- After each addition, the total is compared with `bestTotal`. If it is higher, the program saves the total and the current start and end indices.
- The comparison uses `>` and not `>=`, so if two stretches tie, the first one found is kept.
- If all values are negative, the highest single month stays as the best, because adding more negative months only lowers the total.

## Add Up a Range

```
FUNCTION sumRange(values, start, end)
    SET total = 0

    FOR i = start to end
        ADD values[i] to total
    END FOR

    RETURN total
END FUNCTION
```

## Display the Result

```
FUNCTION displayResults(months, startIndex, endIndex, total)
    PRINT "Sales Analysis"
    PRINT a line of dashes
    PRINT "Start Month: " + months[startIndex]
    PRINT "End Month:   " + months[endIndex]
    PRINT "Total Sales Change: " + total + " million"
END FUNCTION
```

## Example (provided data, start = 0)

```
end = 0  -> total = 12
end = 1  -> total = 4
end = 2  -> total = 19   new best
end = 3  -> total = 37   new best
end = 4  -> total = 15
...
end = 9  -> total = 62   new best (Jan to Oct)
end = 10 -> total = 37
end = 11 -> total = 43

No later start beats 62, so the result is Jan to Oct, total 62.
```
