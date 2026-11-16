# Board Boundary Value Analysis

Rows and columns use indices `0` through `7`. Row `0` is Black's back
rank, row `7` is White's back rank, and column `0` is the `a` file.

## `getPieceAt(int row, int col)`

Cases B01-B13 use a fresh, empty `Board` before `setupStartingPosition()`
is called. Case B14 calls setup first. To test one coordinate's boundaries, hold the other at `3`.
A valid square returns its piece, or `null` if empty. An out-of-range
row or column throws `IndexOutOfBoundsException`.

| ID | Input `(row, col)` | Expected result | Implemented? |
| --- | --- | --- | --- |
| B01 | `(-1, 3)` | Throws `IndexOutOfBoundsException` | Yes |
| B02 | `(0, 3)` | Returns `null` | Yes |
| B03 | `(1, 3)` | Returns `null` | Yes |
| B04 | `(6, 3)` | Returns `null` | Yes |
| B05 | `(7, 3)` | Returns `null` | Yes |
| B06 | `(8, 3)` | Throws `IndexOutOfBoundsException` | Yes |
| B07 | `(3, -1)` | Throws `IndexOutOfBoundsException` | Yes |
| B08 | `(3, 0)` | Returns `null` | Yes |
| B09 | `(3, 1)` | Returns `null` | Yes |
| B10 | `(3, 6)` | Returns `null` | Yes |
| B11 | `(3, 7)` | Returns `null` | Yes |
| B12 | `(3, 8)` | Throws `IndexOutOfBoundsException` | Yes |
| B13 | `(3, 3)` | Returns `null` | Yes |
| B14 | `(0, 0)` after `setupStartingPosition()` | Returns a black rook | No |

## `setupStartingPosition()`

| ID | State before call | Expected state after call | Implemented? |
| --- | --- | --- | --- |
| B15 | Fresh, empty `Board` | All 64 squares match the layout below | No |
| B16 | Fresh, empty `Board` | After setup, row `1` contains a black pawn in every column | Yes |
| B17 | Fresh, empty `Board` | After setup, row `0` contains a black rook, knight, bishop, queen, king, bishop, knight, rook in columns `0` through `7` | No |
| B18 | Fresh, empty `Board` | After setup, row `7` contains a white rook, knight, bishop, queen, king, bishop, knight, rook in columns `0` through `7` | No |
| B19 | Fresh, empty `Board` | After setup, row `6` contains a white pawn in every column | Yes |
| B20 | Fresh, empty `Board` | After setup, all 32 squares in rows `2` through `5` are empty | No |

`Yes` means the corresponding automated test is implemented and passes.
`No` means verification is pending or failing.

### Automated test mapping

| Cases | `BoardTest` method | Coverage |
| --- | --- | --- |
| B01 | `rejectsRowBelowZero` | Row below the board |
| B06, B07, B12 | `rejectsOutOfBoundsCoordinates` | Other out-of-range boundaries |
| B02-B05, B08-B11, B13 | `returnsNullForEmptySquares` | Valid coordinate boundaries on a fresh board |
| B14, B17, B18 | `placesBackRankPieces` (planned) | All 16 back-rank squares, including the black rook at `(0, 0)` |
| B16 | `placesBlackPawnsOnRowOne` | All 8 black-pawn squares |
| B19 | `placesWhitePawnsOnRowSix` | All 8 white-pawn squares |
| B20 | `leavesMiddleRowsEmptyAfterSetup` (planned) | All 32 middle squares after setup |
| B15 | The two pawn methods, `placesBackRankPieces`, and `leavesMiddleRowsEmptyAfterSetup` | Together verify all 64 squares after setup |

Check the resulting state with `getPieceAt(row, col)`. Pieces in each
back rank are listed from column `0` to column `7`.

| Rows | Expected contents |
| --- | --- |
| `0` | Black rook, knight, bishop, queen, king, bishop, knight, rook |
| `1` | One black pawn in each column |
| `2–5` | Every square is empty |
| `6` | One white pawn in each column |
| `7` | White rook, knight, bishop, queen, king, bishop, knight, rook |
