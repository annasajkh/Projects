function setup() {
    createCanvas(400, 500);
}

let kolom = [
    [' ', ' ', ' '],
    [' ', ' ', ' '],
    [' ', ' ', ' '],
    [' ', ' ', ' '],
    [' ', ' ', ' ']
]

let persentase = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

let kemungkinan = [
    [' ', ' ', '#', [1],
        [1, 2, 3, 7],
        [1, 7],
        [1, 3, 4, 5, 7, 9],
        [1, 4, 7]
    ],
    ['#', ' ', ' ', [],
        [5, 6],
        [],
        [2],
        []
    ],
    ['#', ' ', '#', [4],
        [0, 4, 8, 9],
        [0],
        [0, 8, 6],
        []
    ],
    ['#', '#', '#', [0, 2, 3, 5, 6, 7, 8, 9],
        [],
        [2, 3, 4, 5, 6, 8, 9],
        [],
        [0, 2, 3, 5, 6, 8, 9]
    ]
]

function drawBorder() {
    push()
    noFill()
    rect(0, 0, 300, 500)
    pop()
    for (let i = 1; i < 5; i++) {
        line(0, 100 * i, 300, 100 * i);
    }
    for (let i = 1; i < 3; i++) {
        line(100 * i, 0, 100 * i, 500);
    }
}

function renderKolom() {
    for (let i in kolom) {
        for (let j in kolom[i]) {
            let lokasiKolom = {
                x: 100 * j,
                y: 100 * i
            }
            if (kolom[i][j] == '#') {
                fill(0)
                rect(lokasiKolom.x, lokasiKolom.y, 100, 100)
            }

        }
    }
}

function collideRectPoint(px, py, rx, ry, rw, rh) {
    return (px >= rx && px <= rx + rw && py >= ry && py <= ry + rh)
}

function mouseMenyentuhKolom() {
    for (let i in kolom) {
        for (let j in kolom[i]) {
            let lokasiKolom = {
                x: 100 * j,
                y: 100 * i
            }
            if (collideRectPoint(mouseX, mouseY, lokasiKolom.x, lokasiKolom.y, 100, 100)) {
                kolom[i][j] = '#'
            }
        }
    }
}

function cekKemungkinan() {
    for (let i in kolom) {
        for (let j in kemungkinan) {
            if (i == 0) {
                if (kolom[i][0] == kemungkinan[j][0] && kolom[i][1] == kemungkinan[j][1] && kolom[i][2] == kemungkinan[j][2]) {
                    for (let k of kemungkinan[j][3]) {
                        persentase[k] += 10
                        persentase[k] += 10
                        persentase[k] += 10
                    }
                }
            } else if (i == 1) {
                if (kolom[i][0] == kemungkinan[j][0] && kolom[i][1] == kemungkinan[j][1] && kolom[i][2] == kemungkinan[j][2]) {
                    for (let k of kemungkinan[j][4]) {
                        persentase[k] += 10
                        persentase[k] += 10
                        persentase[k] += 10
                    }
                }
            } else if (i == 2) {
                if (kolom[i][0] == kemungkinan[j][0] && kolom[i][1] == kemungkinan[j][1] && kolom[i][2] == kemungkinan[j][2]) {
                    for (let k of kemungkinan[j][5]) {
                        persentase[k] += 10
                        persentase[k] += 10
                        persentase[k] += 10
                    }
                }
            } else if (i == 3) {
                if (kolom[i][0] == kemungkinan[j][0] && kolom[i][1] == kemungkinan[j][1] && kolom[i][2] == kemungkinan[j][2]) {
                    for (let k of kemungkinan[j][6]) {
                        persentase[k] += 10
                        persentase[k] += 10
                        persentase[k] += 10
                    }
                }
            } else {
                if (kolom[i][0] == kemungkinan[j][0] && kolom[i][1] == kemungkinan[j][1] && kolom[i][2] == kemungkinan[j][2]) {
                    for (let k of kemungkinan[j][7]) {
                        persentase[k] += 10
                        persentase[k] += 10
                        persentase[k] += 10
                    }
                }
            }
        }
    }
    drawHasil()
    persentase = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
}

function drawHasil() {
    let mendekati = []
    for (let i in persentase) {
        if (persentase[i] == 150) {
            textAlign(CENTER)
            textSize(20)
            text('Jawaban : ', 355, 20)
            textSize(50)
            text(i, 350, 70)
        } else if (persentase[i] == 120) {
            mendekati.push(i)
        }
    }
    textSize(20)
    textAlign(CENTER)
    text('Mirip : ', 340, 100)
    text(mendekati, 350, 120)
}

function mousePressed() {
    mouseMenyentuhKolom()
}

function clearKolom() {
    if (keyIsDown(67)) {
        kolom = [
            [' ', ' ', ' '],
            [' ', ' ', ' '],
            [' ', ' ', ' '],
            [' ', ' ', ' '],
            [' ', ' ', ' ']
        ]
    }
}

function draw() {
    background(255);
    drawBorder()
    renderKolom()
    cekKemungkinan()
    clearKolom()
}