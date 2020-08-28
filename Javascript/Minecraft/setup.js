let gridX = [],
    gridY = [],
    grass = [],
    dirt = [],
    stone = [],
    bedrock = [],
    r = [],
    x = 0,
    y = 0,
    p = 1,
    t = 0,
    j = 0,
    j1 = 0,
    d = 1000,
    blockPilihan;

for (let i = 0; i < 30; i++) {
    gridX.push(i * 30);
    if (i < 20) {
        gridY.push(i * 30);
    }

}

function setup() {
    let h = 0
    createCanvas(900, 600);
    border('1px solid');
    for (let i = 0; i < 30; i++) {
        r.push(floor(noise(h) * 15));
        grass.push({
            x: gridX[i],
            y: gridY[r[i]]
        })
        j1 += 0.01
        h += 0.1
    }
    tambah(1, 3, dirt);
    tambah(3, 18, stone);

    for (let i = 0; i <= 29; i++) {
        bedrock.push({
            x: i * 30,
            y: 570
        })

    }
}