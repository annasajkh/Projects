let blocks = []
let block = []

function setup() {
    createCanvas(400, 600);
    border();
    rectMode(CENTER)
    blocks.push(new Block(8, -2, [
        [
            ['#', '#', '#'],
            [' ', '#', ' '],
            [' ', '#', ' ']
        ],
        [
            [' ', ' ', '#'],
            ['#', '#', '#'],
            [' ', ' ', '#']
        ],
        [
            [' ', '#', ' '],
            [' ', '#', ' '],
            ['#', '#', '#']
        ],
        [
            ['#', ' ', ' '],
            ['#', '#', '#'],
            ['#', ' ', ' ']
        ]
    ]))

    blocks.push(new Block(8, -2, [
        [
            [' ', '#', ' '],
            [' ', '#', ' '],
            [' ', '#', ' ']
        ],
        [
            [' ', ' ', ' '],
            ['#', '#', '#'],
            [' ', ' ', ' ']
        ]
    ]))

    blocks.push(new Block(8, -2, [
        [
            [' ', '#', ' '],
            [' ', '#', ' '],
            ['#', '#', ' ']
        ],
        [
            ['#', ' ', ' '],
            ['#', '#', '#'],
            [' ', ' ', ' ']
        ],
        [
            [' ', '#', '#'],
            [' ', '#', ' '],
            [' ', '#', ' ']
        ],
        [
            [' ', ' ', ' '],
            ['#', '#', '#'],
            [' ', ' ', '#']
        ]
    ]))

    blocks.push(new Block(8, -2, [
        [
            ['#', '#', '#'],
            [' ', '#', ' '],
            [' ', ' ', ' ']
        ],
        [
            [' ', ' ', '#'],
            [' ', '#', '#'],
            [' ', ' ', '#']
        ],
        [
            [' ', ' ', ' '],
            [' ', '#', ' '],
            ['#', '#', '#']
        ],
        [
            ['#', ' ', ' '],
            ['#', '#', ' '],
            ['#', ' ', ' ']
        ]
    ]))
    blocks.push(new Block(8, -2, [
        [
            [' ', '#', ' '],
            ['#', '#', '#'],
            [' ', '#', ' ']
        ]
    ]))

    blocks.push(new Block(8, -2, [
        [
            ['#', '#', '#'],
            ['#', '#', '#'],
            ['#', '#', '#']
        ]
    ]))
    block.push(blocks[floor(random(blocks.length))])
}

function draw() {
    background(255);
    for (let i of block) {
        i.cetak()
    }
}

setInterval(() => {
    for (let i in block) {
        for (let j in block) {
            if (block[i].aktif) {
                if (block[i].tempatY >= 587.5) {
                    block.push(blocks[floor(random(blocks.length))])
                    block[i].aktif = false
                }
                if (i != j && block[i].tempatY == block[j].tempatY - 25) {
                    block.push(blocks[floor(random(blocks.length))])
                    block[i].aktif = false

                }
            }
        }
    }
})

setInterval(() => {
    for (let i of block) {
        if (i.aktif) {
            i.y++
        }
    }
}, 500)

setInterval(() => {
    for (let i of block) {
        if (i.aktif)
            i.kontrol()
    }
}, 150)