class Player {
    constructor() {
        this.y = 475
        this.x = 100
        this.gravity = 0.5
        this.force = 0
        this.angle = 0
        this.dir = 0
    }
    update() {
        this.y += this.force
        if (this.y < 475) {
            this.force += this.gravity
        } else {
            this.force = 0
            this.angle = 0
        }
        if (this.y != 475) {
            rotate(player.angle)
            this.angle += 0.03 * player.dir
        }
        this.x += this.dir * 4
        if (keyIsDown(68) && player.x < 675) {
            this.dir = 1
        } else if (keyIsDown(65) && player.x > 25) {
            this.dir = -1
        } else {
            this.dir = 0
        }
    }
    cetak() {
        noStroke()
        fill('blue')
        rect(0, 0, 50, 50)
        if (skor > 59 && skor < 80) {
            fill('red')
            circle(0, 0, 7)
        }
    }
}

class Particle {
    constructor(x, y, warna, ukuran, arahX, arahY, angle) {
        this.x = x
        this.y = y
        this.warna = warna
        this.ukuran = ukuran
        this.arahX = arahX
        this.arahY = arahY
        this.angle = angle
    }

    cetak() {
        push()
        translate(this.x, this.y)
        rotate(this.angle)
        fill(this.warna)
        rect(0, 0, this.ukuran, this.ukuran)
        this.x += this.arahX
        this.y += this.arahY
        pop()
    }
}


class Tembok {
    constructor(kecepatan) {
        this.x = random(random(800, 1500), random(2500, 3000))
        this.kecepatan = kecepatan
        this.warna = color(random(255), random(255), random(255))
    }
    update() {
        this.x -= this.kecepatan
    }
    cetak() {
        fill(this.warna)
        rect(this.x, 470, 50, 70)
    }
    ditabrak() {
        return (this.x - player.x < 50 && this.x - player.x > -50 && 470 - player.y < 60 && 470 - player.y > -60)
    }
}

let kecepatan = 4
let player
let tembok = []
let percikan = []
let force = -13
let gameOver = false
let skor = 0
let warnaBG = 255
let ran = 0

function setup() {
    createCanvas(700, 500);
    border('green');
    rectMode(CENTER)
    player = new Player()
    for (let i = 0; i < 3; i++) {
        tembok.push(new Tembok(kecepatan + ran))
    }
}

function draw() {
    background(warnaBG);
    push()
    translate(player.x, player.y)
    if (!gameOver) {
        player.update()
        if (keyIsDown(32) && player.y == 475) {
            player.force = force
        }
    }
    player.cetak()
    pop()
    if (player.y == 475 && !gameOver && player.dir != 0) {
        percikan.push(new Particle(player.x - player.dir * 25, 500, 'blue', random(5, 10) * player.dir * player.dir, random(-1, -5) * player.dir, random(-1, -1.5), random(45)))
    }
    for (let i = percikan.length - 1; i >= 0; i--) {
        percikan[i].cetak()
        percikan[i].ukuran -= 0.5
        if (percikan[i].ukuran < 0) {
            percikan.splice(i, 1)
        }

    }
    for (let i = tembok.length - 1; i >= 0; i--) {
        tembok[i].cetak()
        if (!gameOver) {
            tembok[i].update()
        }
        if (tembok[i].x < -25) {
            tembok.splice(i, 1)
            tembok.push(new Tembok(kecepatan + ran))
            if (skor > 78) {
                warnaBG = random(255)
            }
            kecepatan += 0.01
            skor++
        }
        if (skor > 19 && skor < 40) {
            ran = random(-1, 1)
        }
        if (skor > 39 && skor < 60) {
            ran = random(-2, 2)
            warnaBG = 0
        }
        if (skor > 59 && skor < 80) {
            warnaBG = 'blue'
        }
        if (tembok[i].ditabrak()) {
            gameOver = true
            fill('red')
            text('Game Over', width / 2, height / 2)
            textSize(15)
            text('(Click untuk Restart)', width / 2, height / 2 + 17)
        }
        fill('green')
        textAlign(CENTER, CENTER)
        textSize(30)
        text(skor, width / 2, 20)
    }
    textSize(20)
    fill('blue')
    text('Game by Annas', 80, 20)
}

function mouseClicked() {
    if (gameOver) {
        gameOver = false
        tembok = []
        kecepatan = 4
        skor = 0
        player.dir = 0
        player.x = 100
        warnaBG = 255
        ran = 0
        for (let i = 0; i < 3; i++) {
            tembok.push(new Tembok(kecepatan + ran))
        }
    }
}