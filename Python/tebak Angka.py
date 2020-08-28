import random
print('selamat datang di game tebak angka kamu punya 6 nyawa tebaklah angka dengan benar!')
ulang = True
komputer = random.randint(0,15)
nyawa = 6 
def sisaNyawa():
    if nyawa > 0:
        print('kamu memiliki sisa nyawa ', nyawa)
def tanya():
    lagi = input('mau main lagi(y/n) : ')
    if lagi == 'y':
        komputer = random.randint(0,15)
        nyawa = 6
        return True
    elif  lagi == 'n':
        return False
    else:
        print('kamu salah memasukan jawaban')
        tanya()
while ulang:
    try:
        player = int(input('menurutmu angkanya berapa : '))
        if player == komputer:
            print('selamat kamu menang')
            ulang = tanya()
        elif player < komputer:
            print('jawabanmu terlalu kecil')
            nyawa -= 1
            sisaNyawa()
        elif player > komputer:
            print('jawabanmu terlalu besar')
            nyawa -= 1
            sisaNyawa()
        else:
            print('kamu menulis jawaban yang salah')
            nyawa -= 1
            sisaNyawa()
        if nyawa == 0:
            print('kamu kalah dan jawabanya adalah ', komputer)
            ulang = tanya()
    except:
        print('input yang kamu masukan salah harus angka')

print('terimakasih sudah bermain')
input()
