const cells = document.querySelectorAll('.tic-tac-toe-cell');
let currentPlayer = 'X';
const winningCombos = [
    [0, 1, 2], [3, 4, 5], [6, 7, 8], // горизонтальные
    [0, 3, 6], [1, 4, 7], [2, 5, 8], // вертикальные
    [0, 4, 8], [2, 4, 6] // диагональные
];

cells.forEach(cell => {
    cell.addEventListener('click', () => {
        if (!cell.textContent) {
            cell.textContent = currentPlayer;
            if (checkWin(currentPlayer)) {
                alert(`${currentPlayer} wins!`);
                resetBoard();
                return;
            }
            currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
            if (currentPlayer === 'O') {
                makeRobotMove();
            }
        }
    });
});

function checkWin(player) {
    return winningCombos.some(combo =>
        combo.every(index => cells[index].textContent === player)
    );
}

function resetBoard() {
    cells.forEach(cell => cell.textContent = '');
    currentPlayer = 'X';
}

function makeRobotMove() {
    const emptyCells = Array.from(cells).filter(cell => !cell.textContent);
    const randomIndex = Math.floor(Math.random() * emptyCells.length);
    emptyCells[randomIndex].textContent = 'O';
    currentPlayer = 'X';
}