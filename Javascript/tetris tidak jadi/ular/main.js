class Makanan {
    constructor(x, y) {
        this.x = x
        this.y = y
        this.warna = color(random(255), random(255), random(255))
    }
    cetak() {
        noStroke()
        fill(this.warna)
        circle(this.x + 12.5, this.y + 12.5, 25)
    }
}
class Ular {
    constructor(x, y, xd, yd, kepala = false) {
        this.x = x
        this.y = y
        this.xd = xd
        this.yd = yd
        this.kepala = kepala
        if (!this.kepala && ular.length == 1) {
            warnaUlar = color(random(255), random(255), random(255))
        }
        if (this.kepala) {
            warnaUlar = 'red'
        }
        this.warna = warnaUlar
    }
    cetak() {
        noStroke()
        fill(this.warna)
        rect(this.x, this.y, 25, 25);
        if (this.x > 500) {
            this.x = 0
        }
        if (this.x < 0) {
            this.x = 500
        }
        if (this.y > 500) {
            this.y = 0
        }
        if (this.y < 0) {
            this.y = 500
        }
    }
}
let ular = []
let skor = 0
let makanan;
let kalah = false;
let warnaUlar = null

function render() {
    for (let i = ular.length - 1; i > -1; i--) {
        ular[i].cetak()
    }
    makanan.cetak()
}
setInterval(() => {
    if (!kalah) {
        for (let i = ular.length - 1; i > -1; i--) {
            ular[i].x += ular[i].xd
            ular[i].y += ular[i].yd
            if (i != 0) {
                ular[i].xd = ular[i - 1].xd
                ular[i].yd = ular[i - 1].yd
            }
        }

    }
}, 150)

function kontrolUlar() {
    if (keyIsDown(65) && ular[0].xd != 25) {
        ular[0].yd = 0
        ular[0].xd = -25
    }
    if (keyIsDown(87) && ular[0].yd != 25) {
        ular[0].xd = 0
        ular[0].yd = -25
    }
    if (keyIsDown(68) && ular[0].xd != -25) {
        ular[0].yd = 0
        ular[0].xd = 25
    }
    if (keyIsDown(83) && ular[0].yd != -25) {
        ular[0].xd = 0
        ular[0].yd = 25
    }
}

function buatMakanan() {
    makanan = new Makanan(floor(random(10)) * 25, floor(random(10)) * 25)
}


function menabrak() {
    for (let i in ular) {
        if (i != 0) {
            if (ular[0].x == ular[i].x && ular[0].y == ular[i].y) {
                kalah = true
            }
        }

    }
    if (makanan.x == ular[0].x && makanan.y == ular[0].y) {
        ular.push(new Ular(ular[ular.length - 1].x - ular[ular.length - 1].xd, ular[ular.length - 1].y - ular[ular.length - 1].yd, ular[ular.length - 1].xd, ular[ular.length - 1].yd))
        skor += 1
        buatMakanan()
    }

}

function Ulang() {
    ular = []
    ular.push(new Ular(250, 250, 25, 0, true))
    ular.push(new Ular(ular[ular.length - 1].x - ular[ular.length - 1].xd, ular[ular.length - 1].y - ular[ular.length - 1].yd, ular[ular.length - 1].xd, ular[ular.length - 1].yd))
    skor = 0
    kalah = false
    ular[0].kepala = true
}

function setup() {
    textAlign(CENTER)
    createCanvas(500, 500);
    border();
    buatMakanan()
    ular.push(new Ular(250, 250, 25, 0, true))
    ular.push(new Ular(ular[ular.length - 1].x - ular[ular.length - 1].xd, ular[ular.length - 1].y - ular[ular.length - 1].yd, ular[ular.length - 1].xd, ular[ular.length - 1].yd))
}

function draw() {
    background(255);
    render()
    menabrak()
    fill('black')
    textSize(25)
    text(skor, 250, 25)
    if (kalah) {
        fill('red')
        textSize(25)
        text('Kamu Kalah Pencet Untuk Mengulang', 250, 250)
    }
    if (mouseIsPressed && kalah) {
        Ulang()
    }
    textSize(20)
    text('Game by Annas', 75, 495)
    kontrolUlar()
}