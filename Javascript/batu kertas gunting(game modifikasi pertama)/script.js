function dpilihancomputer(c) {
	var c = Math.random();
	if (c <= 0.33) return 'batu';
	if (c <= 0.66) return 'kertas';
	return 'gunting';
}

function dhasil(c, p) {
	if (c == p) return 'SERI'
	if (p == 'batu' && c == 'gunting' || p == 'gunting' && c == 'kertas' || p == 'kertas' && c == 'batu') return 'MENANG'
	if (p == 'batu' && c == 'kertas' || p == 'gunting' && c == 'batu' || p == 'kertas' && c == 'gunting') return 'KALAH'

}

function putar() {
	const gc = document.querySelector('.img-computer');
	const gambar = ['batu', 'kertas', 'gunting'];
	let i = 0;
	const waktuawal = new Date().getTime();
	setInterval(function () {
		if (new Date().getTime() - waktuawal > 1000) {
			clearInterval;
			return
		}
		gc.setAttribute('src', 'img/' + gambar[i++] + '.png')
		if (i == gambar.length) {
			i = 0
		}
	}, 100)

}
const skorplayer = document.querySelector('.skorplayer');
const skorcomputer = document.querySelector('.skorcomputer');
const pilih = document.querySelectorAll('li img');
let sc = 0
let sp = 0
pilih.forEach(function (pil) {
	pil.addEventListener('click', function () {
		const pilihancomputer = dpilihancomputer();
		const pilihanplayer = pil.className;
		const hasil = dhasil(pilihancomputer, pilihanplayer);

		putar();
		setTimeout(function () {
			const gc = document.querySelector('.img-computer');
			gc.setAttribute('src', 'img/' + pilihancomputer + '.png');
			const a = document.querySelector('.info');
			a.innerHTML = hasil
			if (hasil == 'MENANG') {
				sp += 1
				skorplayer.innerHTML = sp
			} else if (hasil == 'KALAH') {
				sc += 1
				skorcomputer.innerHTML = sc
			}

		}, 1000)
	})
})