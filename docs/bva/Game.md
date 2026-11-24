# Game Boundary Value Analysis

## Methods under test

- `Game()` constructs a game that is already started: it delegates to
  `startNewGame()`, so `getBoard()` and `getActiveColor()` never return `null`.
- `startNewGame()` replaces the board with a new `Board`, calls
  `setupStartingPosition()` on it, and sets the active color to `WHITE`.
- `getBoard()` returns the current board.
- `getActiveColor()` returns the color whose turn it is.

`Color` is a finite enum domain, so numeric boundaries do not apply. There is
no movement or turn-switching API yet, so a game cannot be put into a state
with moved pieces or Black to move. Reset-after-movement cases will be added
when that behavior exists. Exhaustive 64-square checks stay in `BoardTest`;
G05 and G06 check representative squares to catch a missing call from `Game`
to `Board.setupStartingPosition()`.

Representative squares: black rook `(0, 0)`, black king `(0, 4)`, black pawn
`(1, 3)`, empty `(3, 3)`, white pawn `(6, 3)`, white queen `(7, 3)`, white
rook `(7, 7)`.

## Cases and automated test mapping

`Yes` means the corresponding automated test is implemented and passes.
`No` means verification is pending or failing.

| ID | Method(s) under test | State of the system | Expected output | Implemented? | Automated test |
| --- | --- | --- | --- | --- | --- |
| G01 | `Game()`, `getBoard()` | A newly constructed `Game` | Returns a non-null `Board` | No | `GameTest.constructorCreatesBoard` |
| G02 | `Game()`, `getActiveColor()` | A newly constructed `Game` | Returns `Color.WHITE` | No | `GameTest.newGameStartsWithWhite` |
| G03 | `getBoard()` | `getBoard()` called twice with no `startNewGame()` between | Both calls return the same non-null `Board` instance | No | `GameTest.getBoardReturnsSameInstance` |
| G04 | `startNewGame()`, `getBoard()` | `startNewGame()` called on an initialized `Game` | `getBoard()` returns a different `Board` instance than before | No | `GameTest.startNewGameReplacesBoard` |
| G05 | `Game()`, `startNewGame()`, `getBoard()` | A new `Game`, and a `Game` after `startNewGame()` | Board matches the standard starting position at the representative squares | No | `GameTest.constructorSetsUpStartingPosition`, `GameTest.startNewGameSetsUpStartingPosition` |
| G06 | `startNewGame()`, `getBoard()`, `getActiveColor()` | `startNewGame()` called several times in a row | Each call gives a new, initialized `Board`, and `WHITE` is active after each call | No | `GameTest.repeatedStartNewGameResetsEachTime` |
