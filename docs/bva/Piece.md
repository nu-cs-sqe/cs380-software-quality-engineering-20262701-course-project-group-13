# Piece Boundary Value Analysis

## Methods under test

- `Piece(PieceType type, Color color)` constructs a piece with non-null values,
  or throws `NullPointerException` if either argument is null.
- `getType()` returns the type supplied to the constructor.
- `getColor()` returns the color supplied to the constructor.

Each valid case constructs a new `Piece` and checks both getters. Invalid
cases check that construction throws; no piece is returned and getters are
not called. There is no prior piece state or public mutation.

`PieceType` and `Color` are finite enum domains, so numeric boundaries do not
apply. The cases cover every current non-null type/color combination and the
three null-input combinations. A chess piece requires both a type and a color.

## Cases and automated test mapping

`Yes` means the corresponding automated test is implemented and passes.
The valid-value cases are exercised through `BoardTest`: setup constructs the
pieces and the assertions check each resulting piece's type and color. The
null-input cases are exercised directly in `PieceTest`.

| ID | Constructor input `(type, color)` | Expected `getType()` | Expected `getColor()` | Implemented? | Automated test |
| --- | --- | --- | --- | --- | --- |
| P01 | `(PAWN, BLACK)` | `PAWN` | `BLACK` | Yes | `BoardTest.placesBlackPawnsOnRowOne` |
| P02 | `(PAWN, WHITE)` | `PAWN` | `WHITE` | Yes | `BoardTest.placesWhitePawnsOnRowSix` |
| P03 | `(ROOK, BLACK)` | `ROOK` | `BLACK` | Yes | `BoardTest.placesBackRankPieces`, row `0`, columns `0` and `7` |
| P04 | `(ROOK, WHITE)` | `ROOK` | `WHITE` | Yes | `BoardTest.placesBackRankPieces`, row `7`, columns `0` and `7` |
| P05 | `(KNIGHT, BLACK)` | `KNIGHT` | `BLACK` | Yes | `BoardTest.placesBackRankPieces`, row `0`, columns `1` and `6` |
| P06 | `(KNIGHT, WHITE)` | `KNIGHT` | `WHITE` | Yes | `BoardTest.placesBackRankPieces`, row `7`, columns `1` and `6` |
| P07 | `(BISHOP, BLACK)` | `BISHOP` | `BLACK` | Yes | `BoardTest.placesBackRankPieces`, row `0`, columns `2` and `5` |
| P08 | `(BISHOP, WHITE)` | `BISHOP` | `WHITE` | Yes | `BoardTest.placesBackRankPieces`, row `7`, columns `2` and `5` |
| P09 | `(QUEEN, BLACK)` | `QUEEN` | `BLACK` | Yes | `BoardTest.placesBackRankPieces`, row `0`, column `3` |
| P10 | `(QUEEN, WHITE)` | `QUEEN` | `WHITE` | Yes | `BoardTest.placesBackRankPieces`, row `7`, column `3` |
| P11 | `(KING, BLACK)` | `KING` | `BLACK` | Yes | `BoardTest.placesBackRankPieces`, row `0`, column `4` |
| P12 | `(KING, WHITE)` | `KING` | `WHITE` | Yes | `BoardTest.placesBackRankPieces`, row `7`, column `4` |

### Invalid constructor arguments

| ID | Constructor input `(type, color)` | Expected result | Implemented? | Automated test |
| --- | --- | --- | --- | --- |
| P13 | `(null, BLACK)` | Throws `NullPointerException` | No | `PieceTest.rejectsNullType` |
| P14 | `(PAWN, null)` | Throws `NullPointerException` | No | `PieceTest.rejectsNullColor` |
| P15 | `(null, null)` | Throws `NullPointerException` | No | `PieceTest.rejectsBothNullArguments` |

`No` means verification is pending or failing.

## Development history

The original analysis and null-acceptance tests were added after `Piece` was
implemented. Null rejection is a separate contract change with failing tests
added before validation. This does not establish test-first development for
the original class.
