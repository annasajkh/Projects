let gelembung = [];

function setup() {
    createCanvas(500, 500);
    for (let i = 0; i < 100; i++) {
        gelembung[i] = new gel(random(30, 470), random(30, 470),
            random(1, 255), random(1, 255), random(1, 255));
    }
}

function draw() {
    background('gray');
    for (let i = 0; i < gelembung.length; i++) {
        gelembung[i].cetak();
        gelembung[i].jalan();
    }
}


class gel {
    constructor(x, y, warna1, warna2, warna3) {
        this.x = x;
        this.y = y;
        this.warna1 = warna1;
        this.warna2 = warna2;
        this.warna3 = warna3;
        this.cetak = function () {
            noStroke();
            fill(this.warna1, this.warna2, this.warna3);
            ellipse(this.x, this.y, 30, 30);
        };
        this.jalan = function () {
            this.x += random(-1, 1);
            this.y += random(-1, 1);
        };
    }
}