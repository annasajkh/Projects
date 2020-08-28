let k = [];
class kotak {
	constructor() {
		this.x = random(0, 450);
		this.y = random(0, 450);
		this.dx = random(-5, 5);
		this.dy = random(-5, 5);
		this.warna = color(random(255), random(255), random(255))
	}
	cetak() {
		fill(this.warna)
		rect(this.x, this.y, 30, 30)
		this.x += this.dx;
		this.y += this.dy;
	}
	jika() {
		if (this.x >= 470) {
			this.dx = random(-1, -5);
		}
		if (this.x <= 0) {
			this.dx = random(1, 5);
		}
		if (this.y >= 470) {
			this.dy = random(-1, -5);
		}
		if (this.y <= 0) {
			this.dy = random(1, 5);
		}
	}
}

function setup() {
	createCanvas(500, 500);
	border('1px solid');
	alert('membuat objek pencet tombol SPACE,menghapus objek / clear pencet tombol C')
}

function buat(jmlh) {
	for (let i = 0; i < jmlh; i++) {
		k.push(new kotak())
	}

}

function draw() {
	background(255);
	for (let i of k) {
		i.jika();
		i.cetak();
	}
}

function keyPressed() {
	if (keyCode == '32') {
		let j = parseInt(prompt('masukan jumlah kotak'));
		buat(j);
	}
	if (keyCode == '67') {
		k.splice(0, k.length);
	}
}