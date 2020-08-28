function setup() {
    createCanvas(500, 500);
}
let gameover = false;
let hg = 0;
let peluru = [];
let player = {
    x: 250,
    y: 440,
    cetak() {
        fill('green');
        rect(player.x, player.y, 30, 30);
    },
    kontrol() {
        if (!gameover) {
            if (mouseX > 15 && mouseX < 485) {
                player.x = mouseX - 15;
            }
            if (mouseY > 15 && mouseY < 485) {
                player.y = mouseY - 15;
            }
        }
    }
}
let k;
let skor = 0;
let musuh = [];
setInterval(function () {
    if (!gameover) {
        peluru.push({
            x: player.x + 15,
            y: player.y,
            aktif: true
        })
    }
}, 150);
setInterval(function () {
    if (!gameover) {
        musuh.push({
            x: random(30, 470),
            y: random(-100, 0),
            kondisi: random(-1, 1),
            darah: 5,
        })
    }
}, 1000);

function collideCircleRect(CircleX, CircleY, CircleRadius, RectX, RectY, RectHeight, RectWidth) {
    let DeltaX = CircleX - Math.max(RectX, Math.min(CircleX, RectX + RectWidth));
    let DeltaY = CircleY - Math.max(RectY, Math.min(CircleY, RectY + RectHeight));
    return (DeltaX * DeltaX + DeltaY * DeltaY) < (CircleRadius * CircleRadius);
}

function Peluru() {
    for (let i = 0; i < peluru.length; i++) {
        let p = peluru[i];
        p.y -= 5;
        fill('blue');
        if (p.aktif) {
            ellipse(p.x, p.y, 10, 10);
        }
        if (peluru[0].y < -10) {
            peluru.shift();
        }
        for (let i = 0; i < musuh.length; i++) {
            let m = musuh[i];
            if (collideCircleRect(p.x, p.y, 5, m.x, m.y, 30, 30)) {
                if (p.aktif) {
                    m.darah -= 1;
                }
                p.aktif = false;
            }
            if (m.darah == 0) {
                musuh.splice(i, 1);
                skor++;
                k += 0.01;
            }
        }
    }

}

function Musuh() {
    k = 1 + skor * 0.05
    for (let i = 0; i < musuh.length; i++) {
        let m = musuh[i];
        if (m.x >= 470) {
            m.kondisi = -k;
        } else if (m.x <= 0) {
            m.kondisi = k;
        }
        if (m.y > 550) {
            musuh.shift();
            skor -= 1
        }
        if (m.kondisi == 0) {
            m.kondisi = 1;
        }
        if (!gameover) {
            m.y += 0.3 + skor * 0.005;
            m.x += m.kondisi;
        }
        fill('red');
        rect(m.x, m.y, 30, 30);
        fill('green')
        textSize(15)
        rect(m.x, m.y - 10, m.darah * 6, 5)
        if (player.x - m.x < 31 && player.x - m.x > -31 && player.y - m.y < 31 && player.y - m.y > -31) {
            gameover = true;
            if (hg < skor) {
                hg = skor
            }
        }
    }
}

function Teks() {
    fill('lightblue');
    textSize(20);
    text('Game by Annas', 80, 490);
    text(skor, 250, 20);
    text('Skor Tertinggi : ' + hg, 250, 50)
    if (gameover) {
        fill('blue')
        textSize(30)
        text('Game Over', 250, 250)
    }
}

function draw() {
    textAlign(CENTER)
    background('black');
    player.cetak();
    player.kontrol();
    Peluru();
    Musuh();
    Teks();
}