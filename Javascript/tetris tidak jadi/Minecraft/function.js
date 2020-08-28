function hapus(objek) {
    objek.splice(0, objek.length);
}

function cetak(objek, w1, w2, w3) {
    for (i of objek) {
        noStroke();
        fill(w1, w2, w3);
        rect(i.x, i.y, 30, 30);
    }

}

function taphapus(objek) {
    for (let i = 0; i < objek.length; i++) {
        let g = objek[i];
        if (mouseX - g.x < 30 && mouseX - 30 - g.x > -30 && mouseY - g.y < 30 && mouseY - 30 - g.y > -30) {
            objek.splice(i, 1);
        }
    }
}

function mouseTidakMenyentuhBlock(objek) {
    for (let i = 0; i < objek.length; i++) {
        let g = objek[i];
        if (mouseX - g.x < 30 && mouseX - 30 - g.x > -30 && mouseY - g.y < 30 && mouseY - 30 - g.y > -30) {
            return false
        }
    }
    return true
}

function tambah(min, max, objek) {
    let h = random(0, 2100000000)
    if (objek == 'grass') {
        for (let i = 0; i < 30 - min; i++) {
            r.push(floor(noise(h) * 15));
            grass.push({
                x: gridX[i],
                y: gridY[r[i] + max]
            })
            j += 0.01
            h += 0.1
        }
    } else {
        for (let i of grass) {
            for (let j = min; j <= max; j++) {
                objek.push({
                    x: i.x,
                    y: i.y + j * 30
                })
            }
        }
    }
}

function cmd() {
    let c = prompt("Command Prompt , r = random , g = generate , e = repeat , s = stop , d = default,p = pilih block");
    if (c == 'r') {
        p = parseInt(prompt('masukan masing masing jumlah'));
    } else if (c == 'g') {
        x = parseInt(prompt('masukan x (min 0 max 29)'));
        y = parseInt(prompt('masukan y (stabil 13 sampai -5) (min -8 max 13)'));
    } else if (c == '') {
        return
    } else {
        alert('ERROR : (' + c + ') SALAH')
    }
}

function generate() {
    hapus(grass);
    hapus(dirt);
    hapus(stone);
    hapus(bedrock);
    hapus(r);
    tambah(x, y, 'grass');
    tambah(1, 3, dirt);
    tambah(3, 18, stone);

    for (let i = 0; i <= 29; i++) {
        bedrock.push({
            x: i * 30,
            y: 570
        })

    }
}

function randomblock() {
    hapus(grass);
    hapus(dirt);
    hapus(stone);
    hapus(bedrock);
    for (let i = 0; i < p; i++) {
        grass.push({
            x: gridX[floor(random(0, 29))],
            y: gridY[floor(random(0, 19))]
        })
        dirt.push({
            x: gridX[floor(random(0, 29))],
            y: gridY[floor(random(0, 19))]
        })

        stone.push({
            x: gridX[floor(random(0, 29))],
            y: gridY[floor(random(0, 19))]
        });

        bedrock.push({
            x: gridX[floor(random(0, 29))],
            y: gridY[floor(random(0, 19))]
        });
    }

}

function clearworld() {
    hapus(grass);
    hapus(dirt);
    hapus(stone);
    hapus(bedrock);
}

function semula() {
    p = 1;
    x = 0;
    y = 0;
    t = 0;
}

function ulang() {
    d = parseInt(prompt('masukan delay')) * 1000;
    t = 1;
    return
}

function stop() {
    t = 0;
}

function setBlock(x, y, blockName) {
    if (blockName == 'grass') {
        grass.push({
            x: gridX[x],
            y: gridY[y]
        })
    } else if (blockName == 'dirt') {
        dirt.push({
            x: gridX[x],
            y: gridY[y]
        })

    } else if (blockName == 'stone') {
        stone.push({
            x: gridX[x],
            y: gridY[y]
        })
    } else if (blockName == 'bedrock') {
        bedrock.push({
            x: gridX[x],
            y: gridY[y]
        })
    }
}

function pilihBlock() {
    blockPilihan = prompt('masukan nama block')
}