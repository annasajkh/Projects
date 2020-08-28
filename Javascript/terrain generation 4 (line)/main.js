
let nois;
let xp = 0
function setup() {
    createCanvas(600, 600);
    border();
}

function draw() {
    background(255);
    let p = xp
    for(let x =0;x<width;x++){
        stroke('green');
        let y = map(noise(p),0,1,0,height)
        line(x,600,x,y)
        p+= 0.005;
    }
    xp += 0.05;
}