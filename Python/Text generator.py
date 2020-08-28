import random

print('Teks generator dibuat oleh Annas')
subjek = input('siapa namamu : ')
predikat = ['makan','mandi','tidur','bermain','belajar','main game','jalan-jalan','membaca buku','main hp','nonton film','memasak','duduk' ,'nonton tv','menyapu','menggambar','ngising']
subjek2 = ['teman','pacar','saudara','orang gila','adik','kakak','gay']
keterangan = ['rumah','rumah sakit','pinggir jalan','pantai','sekolah','perpustakaan','warnet','kamar','toilet','hotel','gunung','taman','pasar','toko','kolam renang']
while True:
    print(subjek+' '+predikat[random.randrange(0,len(predikat))]+' bersama '+subjek2[random.randrange(0,len(subjek2))]+' di '+keterangan[random.randrange(0,len(keterangan))])
    input()
