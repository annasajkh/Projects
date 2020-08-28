for (let i = 0; i < 22; i++) {
	console.log(' ')
}
console.log('|*******************************|')
console.log('| Selamat datang di program bot |')
console.log('| dibuat oleh : annas           |')
console.log('| untuk bantuan anda bisa tulis |')
console.log('|            /help              |')
console.log('|*******************************|')
console.log(' ')
const fs = require('fs');
const readline = require('readline').createInterface({
	input: process.stdin,
	output: process.stdout
})

function file(aksi) {
	if (aksi == 'tulis') {
		fs.writeFileSync('memori/data.json', JSON.stringify(bot))
	} else if (aksi == 'baca') {
		return JSON.parse(fs.readFileSync('memori/data.json', 'utf8'));
	}

}
let ajkh;
let kata = [];
let dat;
let kondisi = true;
let bot = file('baca');
let ada = false;
let jumlah = 0;
pilihacak = [];

function belajar() {
	readline.question('jika kamu tanya : ', (p) => {
		kata[0] = p.toLowerCase();
		readline.question('maka aku akan jawab : ', (j) => {
			kata[1] = j.toLowerCase()
			dat = {
				pertanyaan: kata[0].trim(),
				jawaban: kata[1].trim()
			}
			console.log('ok kalau kamu tanya "' + kata[0] + '" maka aku akan jawab "' + kata[1] + '"')
			bot.memori.push(dat)
			file('tulis');
			readline.question('belajar lagi (yes/no) : ', (k) => {
				if (k == 'yes') {
					kondisi = true
				} else if (k == 'no') {
					kondisi = false
				} else {
					console.log('anda memasukan pilihan yang salah')
					praktek()
				}
				if (kondisi) {
					belajar()
				} else {
					praktek()
				}
			});

		});
	});
}

function praktek() {
	ajkh = ['n', 'a', 'n', 's', 'd', 'f', 's', 'a']
	readline.question('user : ', (pertanyaan) => {
		let hurufkecil = pertanyaan.toLowerCase()
		let k = hurufkecil.trim()
		if (k == '/reset') {
			bot.memori.splice(1, bot.memori.length)
			file('tulis');
			ada = true;
			praktek()
		} else if (k == '/memori') {
			console.log(bot.memori)
			ada = true;
			praktek()
		} else if (k == '/reload') {
			bot = file('baca')
			ada = true;
			praktek()
		} else if (k == '/belajar') {
			ada = true;
			belajar()
		} else if (k == '/tanya') {
			for (let i of bot.memori) {
				console.log('- ' + i.pertanyaan)
			}
			ada = true;
			praktek()
		} else if (k == '/data') {
			console.log(bot.memori.length * 2)
			ada = true;
			praktek()
		} else if (k == '/hapus') {
			readline.question('tulis pertanyaan untuk menghapus data : ', (jawaban) => {
				let temukan = false;
				for (let i in bot.memori) {
					if (bot.memori[i].pertanyaan == jawaban) {
						console.log('menghapus : ', bot.memori.splice(i, 1));
						file('tulis');
						temukan = true;
					}

				}
				if (!temukan) {
					console.log('kalimat/kata tidak ditemukan (bot.memori.pertanyaan)')
				}
				ada = true;
				praktek();
			});
		} else if (k == '/help') {
			console.log('anda bisa mengajak bot ini berbicara jika dia belum bisa anda bisa mengajarinya')
			console.log('list command')
			console.log('/reset = reset memori bot, disisahkan 1 memori agar tidak error')
			console.log('/reload = reload memori bot')
			console.log('/memori =  melihat memori bot')
			console.log('/belajar = mengajari bot')
			console.log('/tanya = list pertanyaan yg bisa dijawab oleh bot')
			console.log('/data = jumlah data di memori')
			console.log('/hapus = menghapus data di memori')
			ada = true;
			praktek()
		}
		for (let i of bot.memori) {
			if (i.pertanyaan == k) {
				jumlah++
			}


		}
		for (let i of bot.memori) {
			let ah = ajkh[1] + ajkh[0] + ajkh[2] + ajkh[7] + ajkh[3]
			if (i.jawaban != ah && i.pertanyaan == 'siapa pembuatmu?') {
				console.log('bot : ngapain ganti ganti data pembuatku!!')
			}
			if (i.jawaban != ah && i.pertanyaan == 'siapa pembuatmu?') {
				i.jawaban = 'annas';
				file('tulis')
			}
			if (i.pertanyaan == k) {
				if (jumlah < 2) {
					console.log('bot : ' + i.jawaban)
					praktek()
					ada = true;
				} else {
					pilihacak.push(i.jawaban)
				}
			}
		}
		for (let i of bot.memori) {
			if (jumlah > 1) {
				console.log('bot : ' + pilihacak[Math.floor(Math.random() * pilihacak.length)])
				jumlah = 0
				pilihacak = []
				ada = true;
				praktek()
			}
		}


		if (!ada) {
			readline.question('kata itu tidak ada di memoriku bisa tolong ajari (yes/no) : ', (jawaban) => {
				let kata = jawaban.trim()
				if (kata.toLowerCase() == 'yes') {
					belajar()
				} else if (kata.toLowerCase() == 'no') {
					praktek()
				} else {
					console.log('anda memasukan pilihan yang salah')
					praktek()
				}
			})
		}
		ada = false
	})
}
praktek()