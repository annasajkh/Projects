let Engine = Matter.Engine,
    Render = Matter.Render,
    World = Matter.World,
    Bodies = Matter.Bodies,
    mBody = Matter.Body;
let engine;
let world;
let tanah = []
let p = 0
let player;
let camera = 0;
let p1 = 0;
let rumput = []

function buatmobil(x, y, diamererban) {
    this.body = World.add(world, Matter.Composites.car(x, y, 100, 25, diamererban));
    this.cetak = () => {
        fill('red');
        push()
        let playerbody1 = this.body.composites[0].bodies[0]
        let playerbody2 = this.body.composites[0].bodies[1]
        let playerbody3 = this.body.composites[0].bodies[2]
        let posrect = playerbody1.position
        let angle = playerbody1.angle
        rectMode(CENTER)
        translate(posrect.x, posrect.y)
        rotate(angle)
        rect(0, 0, 100, 25)
        pop()
        fill('black')
        circle(playerbody2.position.x, playerbody2.position.y, diamererban * 2)
        circle(playerbody3.position.x, playerbody3.position.y, diamererban * 2)

    }
}

function buattanah(x, y, warna) {
    this.body = Bodies.rectangle(x, y, 5, 5, {
        isStatic: true
    });
    World.add(world, this.body);
    this.p = p
    this.cetak = () => {
        fill(warna[0], warna[1], warna[2])
        if (this.body.position.x < width && this.body.position.x > 0) {
            rect(this.body.position.x - 3, this.body.position.y - 3, 4, 500)
        }
        fill('red')
    }
}


function setup() {
    createCanvas(600, 500);
    engine = Engine.create()
    world = engine.world;
    player = new buatmobil(150, 0, 23)
    border();
    for (let i = 0; i < width; i += 3) {
        tanah.push(new buattanah(i, map(noise(p), 0, 1, 200, 400), [134, 89, 45]))
        p += 0.005
    }
}