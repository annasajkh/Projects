let angle
let slider

function setup() {
    createCanvas(500, 500);
    border();
    slider = createSlider(0, PI, PI / 4, 0.005)
}

function draw() {
    background(255);
    angle = slider.value()
    translate(250, 500)
    tangkai(150)
}

function tangkai(panjang) {
    line(0, 0, 0, -panjang)
    translate(0, -panjang)
    if (panjang > 4) {
        push()
        rotate(angle)
        tangkai(panjang * 0.67)
        pop()
        push()
        rotate(-angle)
        tangkai(panjang * 0.67)
        pop()
    }
}