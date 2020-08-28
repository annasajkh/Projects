function draw() {
    background('white');
    cetak(grass, 0, 230, 0)
    cetak(dirt, 153, 102, 51);
    cetak(stone, 128, 128, 128);
    cetak(bedrock, 51, 51, 51);
    textSize(20);
    fill('blue');
    text('Game by Annas', 0, 20);
    if (mouseIsPressed) {
        if (mouseButton == LEFT) {
            taphapus(grass);
            taphapus(dirt);
            taphapus(stone);
            taphapus(bedrock);
        }
    }
    if (keyIsDown(32)) {
        if (mouseX > 0 && mouseX < 900 && mouseY > 0 && mouseY < 600) {
            if (mouseTidakMenyentuhBlock(grass) && mouseTidakMenyentuhBlock(dirt) && mouseTidakMenyentuhBlock(stone) && mouseTidakMenyentuhBlock(bedrock)) {
                setBlock(floor(mouseX / 30), floor(mouseY / 30), blockPilihan)
            }

        }

    }
}

function keyPressed() {
    setInterval(function () {
        if (t) {
            if (keyCode == '84') {
                cmd();
            } else if (keyCode == '71') {
                generate();
            } else if (keyCode == '82') {
                randomblock();
            } else if (keyCode == '67') {
                clearworld();
            } else if (keyCode == '68') {
                semula();
            } else if (keyCode == '83') {
                stop();
            }
        }
    }, d)
    if (!t) {
        if (keyCode == '84') {
            cmd();
        } else if (keyCode == '71') {
            generate();
        } else if (keyCode == '82') {
            randomblock();
        } else if (keyCode == '67') {
            clearworld();
        } else if (keyCode == '68') {
            semula();
        } else if (keyCode == '69') {
            ulang();
        } else if (keyCode == '80') {
            pilihBlock();
        }
    }
}