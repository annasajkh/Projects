function draw() {
    background(102, 179, 255);
    noStroke()
    for (let i in tanah) {
        if (tanah[0].body.position.x < 0) {
            tanah.push(new buattanah(tanah[tanah.length - 1].body.position.x + 3, map(noise(p), 0, 1, 200, 400), [134, 89, 45]))
            World.remove(world, tanah[0].body)
            tanah.shift()
            p += 0.005
            p1 += 0.005
        }
        if (tanah[tanah.length - 1].body.position.x > width) {
            tanah.unshift(new buattanah(tanah[0].body.position.x - 3, map(noise(p1), 0, 1, 200, 400), [134, 89, 45]))
            World.remove(world, tanah[tanah.length - 1].body)
            tanah.pop()
            p1 -= 0.005
            p -= 0.005
        }
    }
    camera = 150 - player.body.composites[0].bodies[0].position.x
    playerkontrol()
    Engine.update(engine)
    for (let i in tanah) {
        tanah[i].cetak()
        mBody.translate(tanah[i].body, {
            x: camera,
            y: 0
        })
    }
}