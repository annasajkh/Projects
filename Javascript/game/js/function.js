function tampil() {
    player.nama = inputNama.value()
    if (player.nama.length == 0) {
        player.nama = 'Player_' + int(Math.random() * 1000)
    }
    tambahJangkauanSedotan.show()
    tambahKekuatanSedotan.show()
    tambahKecepatan.show()
    jangkauanSedotan.show()
    kekuatanSedotan.show()
    kecepatan.show()
}

function sembunyi() {
    player = new Player(player.pos.x, player.pos.y)
    tambahJangkauanSedotan.hide()
    tambahKekuatanSedotan.hide()
    tambahKecepatan.hide()
    jangkauanSedotan.hide()
    kekuatanSedotan.hide()
    kecepatan.hide()
    tombolOke.show()
    inputNama.show()
}

function ubahTag(obj, tagBaru) {
    obj.elt.innerText = tagBaru
}

function buatTombol(tag, x, y) {
    this.tombol = createButton(tag);
    this.tombol.position(x, y);
    this.tombol.size(160, 50)
    this.tombol.elt.style.color = 'black'
    this.tombol.elt.style.backgroundColor = 'green'
    return this.tombol
}

function buatP(tag, x, y) {
    this.p = createP(tag)
    this.p.position(x, y)
    return this.p
}

function tKekuatanSedotan() {
    if (player.kekuatanSedotan < 30 && player.xp - (40 + tambahHarga[0]) >= 0) {
        player.kekuatanSedotan += 1
        player.xp -= 40 + tambahHarga[0]
        tambahHarga[0] += 20
        ubahTag(tambahKekuatanSedotan, 'Kekuatan Sedotan ' + (40 + tambahHarga[0]) + 'XP')
        ubahTag(kekuatanSedotan, 'Kekuatan Sedotan : ' + player.kekuatanSedotan + ' / ' + 30)
    }
}

function tJangkauanSedotan() {
    if (player.jangkauanSedotan < 1000 && player.xp - (80 + tambahHarga[1]) >= 0) {
        player.jangkauanSedotan += 40
        player.xp -= 80 + tambahHarga[1]
        tambahHarga[1] += 20
        ubahTag(tambahJangkauanSedotan, 'Jangkauan Sedotan ' + (80 + tambahHarga[1]) + 'XP')
        ubahTag(jangkauanSedotan, 'Jangkauan Sedotan : ' + player.jangkauanSedotan + ' / ' + 1000)
    }
}

function tKecepatan() {
    if (player.kecepatan < 10 && player.xp - (40 + tambahHarga[2]) >= 0) {
        player.kecepatan += 0.5
        player.xp -= 40 + tambahHarga[2]
        tambahHarga[2] += 20
        ubahTag(tambahKecepatan, 'kecepatan ' + (40 + tambahHarga[2]) + 'XP')
        ubahTag(kecepatan, 'Kecepatan : ' + player.kecepatan + ' / ' + 10)
    }
}

function tombolOkeTerpencet() {
    player.pos.set(random(-10000, 10000), random(-10000, 10000))
    kalah = false
    tombolOke.hide()
    inputNama.hide()
    tampil()
}