let sells = []
let berjalan = true;

function collidePointRect(pointX, pointY, rectX, rectY, rectW, rectH) {
    return (pointX > rectX && pointX < rectX + rectW && pointY > rectY && pointY < rectY + rectH)
}
class Sell {
    constructor(x, y, hidup, tetanggaYangHidup) {
        this.x = x
        this.y = y
        this.hidup = hidup
        this.tetanggaYangHidup = tetanggaYangHidup
    }
    cetak() {
        if (this.hidup) {
            fill('green')
        } else {
            fill('white')
        }
        rect(this.x, this.y, 25, 25)
    }
}

function setupSell() {
    for (let i = 0; i < 25; i++) {
        sells.push([])
        for (let j = 0; j < 40; j++) {
            sells[i].push(new Sell(j * 25, i * 25, random([true, false]), [0, 0, 0, 0, 0, 0, 0, 0]))
        }
    }
    alert('klik "space" untuk menghentikan dan pencet lagi untuk menjalankan klik kiri untuk menambah sell dan menghapus sell klik "k" untuk mematikan semua sell')
}

function cekTetanggaSell() {
    for (let i = 0; i < sells.length; i++) {
        for (let j = 0; j < sells[i].length; j++) {
            let indexSell = sells[i][j]
            if (j != 0) {
                if (sells[i][j - 1].hidup) {
                    indexSell.tetanggaYangHidup[0] = 1
                } else {
                    if (indexSell.tetanggaYangHidup.length != 0) {
                        indexSell.tetanggaYangHidup[0] = 0
                    }
                }
            }
            if (j != 39) {
                if (sells[i][j + 1].hidup) {
                    indexSell.tetanggaYangHidup[1] = 1
                } else {
                    if (indexSell.tetanggaYangHidup.length != 0) {
                        indexSell.tetanggaYangHidup[1] = 0
                    }
                }
            }
            if (i != 0) {
                if (sells[i - 1][j].hidup) {
                    indexSell.tetanggaYangHidup[2] = 1
                } else {
                    if (indexSell.tetanggaYangHidup.length != 0) {
                        indexSell.tetanggaYangHidup[2] = 0
                    }
                }
            }
            if (i != 24) {
                if (sells[i + 1][j].hidup) {
                    indexSell.tetanggaYangHidup[3] = 1
                } else {
                    if (indexSell.tetanggaYangHidup.length != 0) {
                        indexSell.tetanggaYangHidup[3] = 0
                    }
                }
            }
            if (i != 0 && j != 0) {
                if (sells[i - 1][j - 1].hidup) {
                    indexSell.tetanggaYangHidup[4] = 1
                } else {
                    if (indexSell.tetanggaYangHidup.length != 0) {
                        indexSell.tetanggaYangHidup[4] = 0
                    }
                }
            }
            if (i != 0 && j != 39) {
                if (sells[i - 1][j + 1].hidup) {
                    indexSell.tetanggaYangHidup[5] = 1
                } else {
                    if (indexSell.tetanggaYangHidup.length != 0) {
                        indexSell.tetanggaYangHidup[5] = 0
                    }
                }
            }
            if (i != 24 && j != 0) {
                if (sells[i + 1][j - 1].hidup) {
                    indexSell.tetanggaYangHidup[6] = 1
                } else {
                    if (indexSell.tetanggaYangHidup.length != 0) {
                        indexSell.tetanggaYangHidup[6] = 0
                    }
                }
            }
            if (i != 24 && j != 39) {
                if (sells[i + 1][j + 1].hidup) {
                    indexSell.tetanggaYangHidup[7] = 1
                } else {
                    if (indexSell.tetanggaYangHidup.length != 0) {
                        indexSell.tetanggaYangHidup[7] = 0
                    }
                }
            }
        }

    }
}

function peraturanSell() {
    cekTetanggaSell()
    for (let i in sells) {
        for (let j in sells[i]) {
            let indexSell = sells[i][j]
            let cekBanyakTetangga = 0
            for (let k of indexSell.tetanggaYangHidup) {
                if (k == 1) {
                    cekBanyakTetangga += 1
                }
            }
            if (indexSell.hidup) {
                if (cekBanyakTetangga < 2) {
                    indexSell.hidup = false
                }
                if (cekBanyakTetangga > 3) {
                    indexSell.hidup = false
                }
            } else {
                if (cekBanyakTetangga == 3) {
                    indexSell.hidup = true
                }
            }
        }
    }

}

function setup() {
    createCanvas(1000, 625);
    border();
    setupSell()
}

function renderSell() {
    for (let i in sells) {
        for (let j in sells[i]) {
            sells[i][j].cetak()
        }

    }
}

function mousePressed() {
    for (let i in sells) {
        for (let j in sells[i]) {
            let indexSell = sells[i][j]
            if (collidePointRect(mouseX, mouseY, indexSell.x, indexSell.y, 25, 25)) {
                if (indexSell.hidup) {
                    indexSell.hidup = false
                } else {
                    indexSell.hidup = true
                }
            }
        }
    }
}

function keyPressed() {
    if (keyCode == 32) {
        if (berjalan) {
            berjalan = false
        } else {
            berjalan = true
        }
    }
    if (keyCode == 75) {
        for (let i in sells) {
            for (let j of sells[i]) {
                j.hidup = false
            }
        }
    }
}

function draw() {
    background(255);
    renderSell()
    if (berjalan) {
        peraturanSell()
    }
}