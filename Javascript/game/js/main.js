let player
let makanan = []
let lubangHitam = []
let lubangMerah = []
let lubangHijau = []
let tambahKekuatanSedotan, tambahJangkauanSedotan, tambahKecepatan, kekuatanSedotan, jangkauanSedotan, kecepatan, inputNama, tombolOke
let kalah = true
let zoom = 1
let cnv
let makananLength
let tambahHarga = [0, 0, 0]

function setup() {

    noStroke()
    textAlign(CENTER, CENTER)
    cnv = createCanvas(windowWidth, windowHeight)
    player = new Player(random(-10000, 10000), random(-10000, 10000))
    inputNama = createInput('');
    inputNama.position(width / 2 - 86.5, height / 2)
    tombolOke = buatTombol('Oke', width / 2 - 80, height / 1.75)
    tombolOke.mousePressed(tombolOkeTerpencet)
    tambahKekuatanSedotan = buatTombol('Kekuatan Sedotan ' + 40 + 'XP', width - (width / 1.01), height - height / 2 - 100)
    tambahKekuatanSedotan.mousePressed(tKekuatanSedotan)
    tambahJangkauanSedotan = buatTombol('Jangkauan Sedotan ' + 80 + 'XP', width - (width / 1.01), height - height / 2 - 50)
    tambahJangkauanSedotan.mousePressed(tJangkauanSedotan)
    tambahKecepatan = buatTombol('Kecepatan ' + 40 + 'XP', width - (width / 1.01), height - height / 2)
    tambahKecepatan.mousePressed(tKecepatan)
    kekuatanSedotan = buatP('Kekuatan Sedotan : ' + player.kekuatanSedotan + ' / ' + 30, width - (width / 1.01), height - height / 2 + 125)
    jangkauanSedotan = buatP('Jangkauan Sedotan : ' + player.jangkauanSedotan + ' / ' + 1000, width - (width / 1.01), height - height / 2 + 150)
    kecepatan = buatP('Kecepatan : ' + player.kecepatan + ' / ' + 10, width - (width / 1.01), height - height / 2 + 175)
    cnv.canvas.style.marginTop = '-8px'
    cnv.canvas.style.marginLeft = '-8px'
    tambahJangkauanSedotan.hide()
    tambahKekuatanSedotan.hide()
    tambahKecepatan.hide()
    jangkauanSedotan.hide()
    kekuatanSedotan.hide()
    kecepatan.hide()
    for (let i = 0; i < 9000; i++)
        makanan.push(new Makanan(random(-10000, 10000), random(-10000, 10000)))
    for (let i = 0; i < 20; i++) {
        lubangHitam.push(new LubangHitam(random(-10000, 10000), random(-10000, 10000)))
        lubangMerah.push(new LubangMerah(random(-10000, 10000), random(-10000, 10000)))
        lubangHijau.push(new LubangHijau(random(-10000, 10000), random(-10000, 10000)))
    }
    makananLength = makanan.length
}

function tp(x, y) {
    player.pos.x = x
    player.pos.y = y
}


function windowResized() {
    resizeCanvas(windowWidth, windowHeight)
    tombolOke.position(width / 2 - 80, height / 1.75)
    inputNama.position(width / 2 - 86.5, height / 2)
}

function draw() {
    background('aqua')
    translate(width / 2, height / 2)
    zoom = lerp(zoom, 40 / (40 + player.jangkauanSedotan * 0.1), 0.1)
    scale(zoom)
    translate(-player.pos.x, -player.pos.y)
    for (let i = 0; i < makananLength; i++) {
        if (makanan[i].pos.x < player.pos.x + width / 2 + 20 + player.jangkauanSedotan * 2 && makanan[i].pos.x > player.pos.x - width / 2 - 20 - player.jangkauanSedotan * 2 && makanan[i].pos.y < player.pos.y + height / 2 + 20 + player.jangkauanSedotan && makanan[i].pos.y > player.pos.y - height / 2 - 20 - player.jangkauanSedotan) {
            makanan[i].cetak()

            if (!kalah) {
                if (player.xp < 1000) {
                    if (player.menyedot(makanan[i])) {
                        makanan[i].tersedot(player)
                    }
                    if (player.xp < 1000) {
                        if (player.memakan(makanan[i])) {
                            makanan[i] = new Makanan(-10000 + Math.random() * 20000, -10000 + Math.random() * 20000)
                            makananLength = makanan.length
                            player.xp += 2
                        }
                    }
                }
            }
        }
    }
    if (!kalah) {
        player.cetak()
        player.update()
        player.constrain()
        if (player.xp < 0 && player.xp != -Infinity) {
            sembunyi()
            tambahHarga = [0, 0, 0]
            ubahTag(tambahKekuatanSedotan, 'Kekuatan Sedotan ' + 40 + 'XP')
            ubahTag(tambahJangkauanSedotan, 'Jangkauan Sedotan ' + 80 + 'XP')
            ubahTag(tambahKecepatan, 'kecepatan ' + 40 + 'XP')
            kalah = true
        }
    }
    for (let i = 0; i < 20; i++) {
        if (lubangHitam[i].pos.x < player.pos.x + width / 2 + lubangHitam[i].jangkauanSedotan + player.jangkauanSedotan * 2 && lubangHitam[i].pos.x > player.pos.x - width / 2 - lubangHitam[i].jangkauanSedotan - player.jangkauanSedotan * 2 && lubangHitam[i].pos.y < player.pos.y + height / 2 + lubangHitam[i].jangkauanSedotan + player.jangkauanSedotan && lubangHitam[i].pos.y > player.pos.y - height / 2 - lubangHitam[i].jangkauanSedotan - player.jangkauanSedotan) {
            lubangHitam[i].cetak()
            if (!kalah) {
                if (lubangHitam[i].menyedot(player)) {
                    player.tersedot(lubangHitam[i])
                }
                if (lubangHitam[i].memakan(player)) {
                    player.xp -= 4
                }
            }
        }
        if (lubangMerah[i].pos.x < player.pos.x + width / 2 + lubangMerah[i].jangkauanSedotan + player.jangkauanSedotan * 2 && lubangMerah[i].pos.x > player.pos.x - width / 2 - lubangMerah[i].jangkauanSedotan - player.jangkauanSedotan * 2 && lubangMerah[i].pos.y < player.pos.y + height / 2 + lubangMerah[i].jangkauanSedotan + player.jangkauanSedotan && lubangMerah[i].pos.y > player.pos.y - height / 2 - lubangMerah[i].jangkauanSedotan - player.jangkauanSedotan) {
            lubangMerah[i].cetak()
            if (!kalah) {
                lubangMerah[i].menyentuh(player)
                if (lubangMerah[i].memakan(player)) {
                    sembunyi()
                    kalah = true
                }
            }
        }
        if (lubangHijau[i].pos.x < player.pos.x + width / 2 + 200 + player.jangkauanSedotan * 2 && lubangHijau[i].pos.x > player.pos.x - width / 2 - 200 - player.jangkauanSedotan * 2 && lubangHijau[i].pos.y < player.pos.y + height / 2 + 200 + player.jangkauanSedotan && lubangHijau[i].pos.y > player.pos.y - height / 2 - 200 - player.jangkauanSedotan) {
            lubangHijau[i].cetak()
            if (!kalah) {
                if (lubangHijau[i].menyentuh(player)) {
                    player.xp -= 1
                }
            }
        }
    }

}