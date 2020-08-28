function createblackhole(x,y,d){
	return{
		x,
		y,
		d,

		cetak(){
			fill('black')
			circle(x,y,d)
		}
	}
}
function benda(x,w,h,a,w1,w2,w3){
	return{
		x,
		w,
		h,
		a,
		w1,
		w2,
		w3,
		cetak(){
			push()
			translate(blackhole.x,blackhole.y)
			rotate(this.a)
			fill(this.w1,this.w2,this.w3)
			rect(this.x,this.x,this.w,this.h);
			this.a += 0.075
			this.x -= 1
			pop()
		}	
	}

}
let blackhole = createblackhole(250,250,60)
let bendas = []
	
function setup() {
	rectMode(CENTER)
    createCanvas(500, 500);
    border();
}

function draw() {
	background('white');
	blackhole.cetak()
	if(mouseIsPressed){
		bendas.push(benda(200,random(10,50),random(10,50),0,random(0,255),random(0,255),random(0,255)))
	}
		for(let i in bendas){
			bendas[i].cetak()		
			if(bendas[i].x < 0.1){
				bendas.splice(i,1)
			}					
		}	
}