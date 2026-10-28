# Test Plan – Sales Analysis

Each dataset below was run through the program's `findBestPeriod` method. The start index, end index, and total were then compared with the expected values. Indexes start at 0, so index 0 is the first month.

## Test Cases

| # | What is tested | Input data | Expected result | Actual result | Pass/Fail |
|---|---|---|---|---|---|
| 1 | Provided 12-month data | `{12, -8, 15, 18, -22, 10, 14, -5, 20, 8, -25, 6}` | Start 0 (Jan), end 9 (Oct), total 62 | Start 0, end 9, total 62.0 | Pass |
| 2 | Only one month | `{15}` | Start 0, end 0, total 15 | Start 0, end 0, total 15.0 | Pass |
| 3 | Best period is a single month | `{-5, 20, -30, 3}` | Start 1, end 1, total 20 | Start 1, end 1, total 20.0 | Pass |
| 4 | All negative values | `{-8, -3, -10, -6}` | Start 1, end 1, total -3 (highest single value) | Start 1, end 1, total -3.0 | Pass |
| 5 | Best period starts at first element | `{10, 8, -20, 2}` | Start 0, end 1, total 18 | Start 0, end 1, total 18.0 | Pass |
| 6 | Best period ends at last element | `{-20, 4, 6, 10}` | Start 1, end 3, total 20 | Start 1, end 3, total 20.0 | Pass |
| 7 | Tie between two periods | `{4, 1, -10, 5}` | Start 0, end 1, total 5 (first one kept) | Start 0, end 1, total 5.0 | Pass |

**Result: all 7 tests passed.**

## Notes

- **Test 3:** adding the months on either side of the 20 only lowers the total, so the single month is best.
- **Test 4:** every value is negative, so the highest single value (-3) is the best period.
- **Test 7:** indexes 0 to 1 (4 + 1 = 5) and index 3 alone (5) both total 5. The program only replaces the best period when a total is strictly greater, so the first one is kept.

## Failed Tests and Fixes

No tests failed, so no fixes were needed.

## Program Output for the Provided Data

```
Sales Analysis
-------------------------
Start Month: Jan
End Month:   Oct
Total Sales Change: 62.0 million
```
