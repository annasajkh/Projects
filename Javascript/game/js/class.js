class LubangHitam {
    constructor(x, y) {
        this.pos = createVector(x, y)
        this.r = int(40 + Math.random() * 100)
        this.jangkauanSedotan = this.r * 8
        this.kekuatanSedotan = this.r / 20
        this.rObjek
    }
    cetak() {
        fill(0, 0, 0, 150)
        circle(this.pos.x, this.pos.y, this.jangkauanSedotan)
        fill(0)
        circle(this.pos.x, this.pos.y, this.r * 2)
    }
    menyedot(objek) {
        let d = p5.Vector.dist(this.pos, objek.pos)
        this.rObjek = objek.r
        return (d < this.rObjek + this.r * 4)
    }
    memakan(objek) {
        let d = p5.Vector.dist(this.pos, objek.pos)
        return (d < this.r + objek.r)
    }
}

class LubangMerah {
    constructor(x, y) {
        this.pos = createVector(x, y)
        this.r = int(30 + Math.random() * 100)
        this.jangkauanSedotan = this.r * 8
        this.kecepatan = 300 / this.r
        this.rObjek
    }
    cetak() {
        fill(255, 0, 0, 150)
        circle(this.pos.x, this.pos.y, this.jangkauanSedotan)
        fill(255, 0, 0)
        circle(this.pos.x, this.pos.y, this.r * 2)
    }
    menyentuh(objek) {
        let d = p5.Vector.dist(this.pos, objek.pos)
        this.rObjek = objek.r
        if (d < this.rObjek + this.r * 4) {
            this.vel = createVector(objek.pos.x, objek.pos.y)
            this.vel.sub(this.pos)
            this.vel.setMag(this.kecepatan)
            this.pos.add(this.vel)
        }

    }

    memakan(objek) {
        let d = p5.Vector.dist(this.pos, objek.pos)
        return (d < this.r + objek.r)
    }
}

class LubangHijau {
    constructor(x, y) {
        this.pos = createVector(x, y)
        this.r = 50
    }
    cetak() {
        fill(0, 255, 0)
        circle(this.pos.x, this.pos.y, this.r * 2)
    }

    menyentuh(objek) {
        let d = p5.Vector.dist(this.pos, objek.pos)
        return (d < this.r + objek.r)
    }
}

class Makanan {
    constructor(x, y) {
        this.pos = createVector(x, y)
        this.warna = color(Math.random() * 255, Math.random() * 255, Math.random() * 255)
        this.disedot = false
        this.r = 10
    }
    tersedot(ke) {
        this.vel = createVector(ke.pos.x, ke.pos.y)
        this.vel.sub(this.pos)
        this.vel.setMag(ke.kekuatanSedotan)
        this.pos.add(this.vel)
        this.disedot = true
    }
    cetak() {
        fill(this.warna)
        circle(this.pos.x, this.pos.y, this.r * 2)
    }
}
class Player {
    constructor(x, y) {
        this.pos = createVector(0, 0)
        this.kecepatan = 3
        this.r = 50;
        this.jangkauanSedotan = 40
        this.kekuatanSedotan = 1
        this.xp = 0
        this.nama
    }
    update() {
        fill(0)
        textSize(this.r / 3)
        text(this.xp + '/' + 1000, this.pos.x, this.pos.y)
        text(this.nama, this.pos.x, this.pos.y + this.r * 1.5)
        this.vel = createVector(mouseX - width / 2, mouseY - height / 2)
        this.vel.setMag(this.kecepatan)
        this.pos.add(this.vel)
        if (this.r < (this.jangkauanSedotan / 10) + 50) {
            this.r += 0.5
        }
    }

    tersedot(ke) {
        this.vel = createVector(ke.pos.x, ke.pos.y)
        this.vel.sub(this.pos)
        this.vel.setMag(ke.kekuatanSedotan)
        this.pos.add(this.vel)
    }

    menyedot(makanan) {
        let d = p5.Vector.dist(this.pos, makanan.pos)

        return (d < this.r + this.r + this.jangkauanSedotan)
    }
    memakan(objek) {
        let d = p5.Vector.dist(this.pos, objek.pos)
        return (d < this.r - objek.r)
    }

    cetak() {
        fill('blue')
        circle(this.pos.x, this.pos.y, this.r * 2)
    }

    constrain() {
        this.pos.x = constrain(this.pos.x, -10000, 10000)
        this.pos.y = constrain(this.pos.y, -10000, 10000)
    }
}