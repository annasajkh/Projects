function playerkontrol() {
    player.cetak()
    if (keyIsDown(65)) {
        mBody.translate(player.body.composites[0].bodies[1], {
            x: -10,
            y: 0
        })
    } else if (keyIsDown(68)) {
        mBody.translate(player.body.composites[0].bodies[1], {
            x: 10,
            y: 0
        })
    }
    mBody.translate(player.body.composites[0].bodies[1], {
        x: camera,
        y: 0
    })
}