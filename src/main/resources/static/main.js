const boardArray = new Array(8);
for (let i = 0; i < 8; i++) {
    boardArray[i] = new Array(8);
    for (let j = 0; j < 8; j++) {
        boardArray[i][j] = null;
    }
}
//
// let setBlackPieces = function() {
//     for (int i = 0; i < 8; i++) {
//         Figure pawn = new Pawn(new Position(1, i), BLACK);
//         boardArray[1][i] = pawn;
//     }
//
//     boardArray[0][0] = new Rook(new Position(0, 0), BLACK);
//     boardArray[0][7] = new Rook(new Position(0, 7), BLACK);
//
//     boardArray[0][1] = new Knight(new Position(0, 1), BLACK);
//     boardArray[0][6] = new Knight(new Position(0, 6), BLACK);
//
//     boardArray[0][2] = new Bishop(new Position(0, 2), BLACK);
//     boardArray[0][5] = new Bishop(new Position(0, 5), BLACK);
//
//     boardArray[0][3] = new Queen(new Position(0, 3), BLACK);
//     boardArray[0][4] = new King(new Position(0, 4), BLACK);
// }

const createBoard = function () {
    let board = document.getElementById("ChessBoard");
    let map = [
        9, 11, 10, 8, 7, 10, 11, 9,
        12, 12, 12, 12, 12, 12, 12, 12,
        0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,
        6, 6, 6, 6, 6, 6, 6, 6,
        3, 5, 4, 2, 1, 4, 5, 3,
    ];

    for (let i = 0; i < 64; i++) {
        let tile = document.createElement("div");
        tile.style.backgroundColor = parseInt((i / 8) + i) % 2 == 0 ? 'white' : 'lightgray';
        // tile.innerHTML = !map[i] ? "" : "&#" + (9811 + map[i]) + ";";
        // if(tile.innerHTML !== "") {
        //     tile.setAttribute("id", (9811 + map[i]));
        // }
        board.appendChild(tile);
    }
};

/* 1. Взять рандомно фигуру.
        2. Составить возможные ходы
        3. Выбрать ход и отрисовать новое состояние
    */
function makeMove() {
    for (let i = 0; i < boardArray.length; i++) {
        for (let j = 0; j < boardArray.length; j++) {
            let tile = document.createElement("div");
            tile.style.backgroundColor = parseInt((i / 8) + i) % 2 == 0 ? 'white' : 'lightgray';
            tile.innerHTML
        }
    }


    tile.innerHTML = !map[i] ? "" : "&#" + (9811 + map[i]) + ";";
    if(tile.innerHTML !== "") {
        tile.setAttribute("id", (9811 + map[i]));
        boardArray
    }
    board.appendChild(tile);


}


jQuery(document).ready(function () {
    createBoard();
    console.log("Created Chessboard");
});