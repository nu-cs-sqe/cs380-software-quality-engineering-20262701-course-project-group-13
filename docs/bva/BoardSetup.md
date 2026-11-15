# Board Boundary Value Analysis

Rows and columns use indices `0` through `7`. Row `0` is Black's back
rank, row `7` is White's back rank, and column `0` is the `a` file.

## `getPieceAt(int row, int col)`

Each case uses a fresh, empty `Board` before `setupStartingPosition()`
is called. To test one coordinate's boundaries, hold the other at `3`.
A valid square returns its piece, or `null` if empty. An out-of-range
row or column throws `IndexOutOfBoundsException`.

| ID | Input `(row, col)` | Expected result | Implemented? |
| --- | --- | --- | --- |
| B01 | `(-1, 3)` | Throws `IndexOutOfBoundsException` | No |
| B02 | `(0, 3)` | Returns `null` | No |
| B03 | `(1, 3)` | Returns `null` | No |
| B04 | `(6, 3)` | Returns `null` | No |
| B05 | `(7, 3)` | Returns `null` | No |
| B06 | `(8, 3)` | Throws `IndexOutOfBoundsException` | No |
| B07 | `(3, -1)` | Throws `IndexOutOfBoundsException` | No |
| B08 | `(3, 0)` | Returns `null` | No |
| B09 | `(3, 1)` | Returns `null` | No |
| B10 | `(3, 6)` | Returns `null` | No |
| B11 | `(3, 7)` | Returns `null` | No |
| B12 | `(3, 8)` | Throws `IndexOutOfBoundsException` | No |
| B13 | `(3, 3)` | Returns `null` | No |
| B14 | `(0, 0)` after `setupStartingPosition()` | Returns a black rook | No |

## `setupStartingPosition()`

| ID | State before call | Expected state after call | Implemented? |
| --- | --- | --- | --- |
| B15 | Fresh, empty `Board` | All 64 squares match the layout below | No |

Check the resulting state with `getPieceAt(row, col)`. Pieces in each
back rank are listed from column `0` to column `7`.

| Rows | Expected contents |
| --- | --- |
| `0` | Black rook, knight, bishop, queen, king, bishop, knight, rook |
| `1` | One black pawn in each column |
| `2–5` | Every square is empty |
| `6` | One white pawn in each column |
| `7` | White rook, knight, bishop, queen, king, bishop, knight, rook |