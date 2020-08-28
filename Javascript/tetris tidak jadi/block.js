class Block {
    constructor(x, y, bentuk) {
        this.x = x
        this.y = y
        this.kon = [1, 1]
        this.bentuk = bentuk
        this.aktif = true
        this.wujud = floor(random(this.bentuk.length))
        this.warna = color(random(255), random(255), random(255))
    }
    cetak() {
        fill(this.warna)
        for (let i in this.bentuk[this.wujud]) {
            for (let j in this.bentuk[this.wujud][i]) {
                if (this.bentuk[this.wujud][i][j] == '#') {
                    this.tempatX = (this.x + (j - 1)) * 25 - 12.5
                    this.tempatY = (this.y + (i - 1)) * 25 + 12.5
                    rect(this.tempatX, this.tempatY, 25, 25)
                    if (this.tempatX < 25) {
                        this.kon[0] = 0
                    } else if (this.tempatX > 375) {
                        this.kon[1] = 0
                    }
                    if (this.tempatX < 12.5) {
                        this.x++
                    }
                    if (this.tempatX > 387.5) {
                        this.x--
                    }
                }
            }
        }
    }
    kontrol() {
        if (keyIsDown(68) && this.kon[1]) {
            this.x++
            this.kon[0] = 1

        } else if (keyIsDown(65) && this.kon[0]) {
            this.x--
            this.kon[1] = 1
        }
        if (mouseIsPressed) {
            this.wujud++
            if (this.wujud == this.bentuk.length) {
                this.wujud = 0
            }
            if (this.tempatX > 25 && this.tempatX < 75) {
                this.x--
            }
            if (this.tempatX > 325) {
                this.x++
            }

        }
    }
}