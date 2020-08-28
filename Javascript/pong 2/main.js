let player = {
    y: 250,
    x: 50,
    cetak() {
        this.y = mouseY
        if (this.y > 450)
            this.y = 450
        else if (this.y < 50)
            this.y = 50
        fill('blue')
        rect(this.x, this.y, 20, 100)
    }
}

let musuh = {
    y: 250,
    x: 650,
    sudahKena: false,
    cetak() {
        if (collideCircleRect(bola.pos.x, bola.pos.y, 10, musuh.x, musuh.y, 100, 20)) {
            this.sudahKena = true
        }
        if (!this.sudahKena) {
            if (bola.pos.x > 350) {
                if (this.y + 40 < bola.pos.y) {
                    this.y += bola.kecepatan + 1
                }
                if (this.y - 40 > bola.pos.y) {
                    this.y -= bola.kecepatan + 1
                }

            }
        }
        if (bola.pos.x < 350) {
            this.sudahKena = false
        }
        if (this.y > 450)
            this.y = 450
        else if (this.y < 50)
            this.y = 50
        fill('red')
        rect(this.x, this.y, 20, 100)

    }
}
let bola
let skor = {
    player: 0,
    musuh: 0,
    cetak() {
        fill('green')
        textSize(30)
        textAlign(CENTER)
        text(this.player, 175, 30)
        text(this.musuh, 525, 30)
    }
}
class Bola {
    constructor() {
        this.pos = createVector(width / 2, height / 2)
        this.dir = createVector(random(-10, 10), random(-10, 10))
        this.kecepatan = 4
    }
    cetak() {
        fill('yellow')
        circle(this.pos.x, this.pos.y, 20)
        this.dir.setMag(this.kecepatan)
        this.pos.add(this.dir)
        if (this.pos.x < 10) {
            this.pos.x = 350
            this.pos.y = 250
            this.dir.x = random(-10, 10)
            this.dir.y = random(-10, 10)
            this.kecepatan = 4
            skor.musuh += 1
        }

        if (this.pos.x > 690) {
            this.pos.x = 350
            this.pos.y = 250
            this.dir.x = random(-10, 10)
            this.dir.y = random(-10, 10)
            this.kecepatan = 4
            skor.player += 1
        }

        if (this.pos.y < 10) {
            this.dir.y = -this.dir.y
            this.kecepatan += 0.05
        }

        if (this.pos.y > 490) {
            this.dir.y = -this.dir.y
            this.kecepatan += 0.05
        }
        if (this.pos.x < 350) {
            if (collideCircleRect(this.pos.x, this.pos.y, 10, player.x, player.y, 100, 20)) {
		this.kecepatan += 0.05
                if (this.pos.x > player.x) {
                    this.dir.y = this.dir.y
                    this.dir.x = -this.dir.x
                } else {
                    this.dir.y = -this.dir.y
                    this.dir.x = this.dir.x
                }
            }
        }
        if (this.pos.x > 350) {
            if (collideCircleRect(this.pos.x, this.pos.y, 10, musuh.x, musuh.y, 100, 20)) {
		this.kecepatan += 0.05
                if (this.pos.x < musuh.x) {
                    this.dir.y = this.dir.y
                    this.dir.x = -this.dir.x
                } else {
                    this.dir.y = -this.dir.y
                    this.dir.x = this.dir.x
                }

            }
        }

    }
}

function collideCircleRect(CircleX, CircleY, CircleRadius, RectX, RectY, RectHeight, RectWidth) {
    let DeltaX = CircleX - max(RectX - RectWidth / 2, min(CircleX, RectX + RectWidth / 2));
    let DeltaY = CircleY - max(RectY - RectHeight / 2, min(CircleY, RectY + RectHeight / 2));
    return (DeltaX * DeltaX + DeltaY * DeltaY) < (CircleRadius * CircleRadius);
}

function setup() {
    rectMode(CENTER)
    createCanvas(700, 500);
    border()
    bola = new Bola()
}

function render() {
    line(350, 0, 350, 500)
    player.cetak()
    musuh.cetak()
    skor.cetak()
    bola.cetak()
}

function draw() {
    background(255);
    render()
}