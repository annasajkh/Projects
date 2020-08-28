import random

lagi = True
angka = '01234567890123456789012345'
huruf = 'qwertyuioplkjhgfdsazxcvbnm'
simbol = '!@#$%^&*()_+-=[]{};:/.,<>?'
def tanya():
    jawab = input('lagi? (y/t) : ')
    if jawab == 'y':
        return  True
    elif jawab == 't':
        return  False
    else:
        print('Input salah')
        return  tanya()


while lagi:
    #try:
        jenis_password = []
        jenis = []
        password = []
        print('''
|------------------------------------|
| Simple Password Generator By Annas |
|------------------------------------|
        ''')
        panjang = input('panjang password : ')
        if panjang == '':
            panjang = 8
        else:
            panjang = int(panjang)
        print("jenis password (angka/huruf/simbol/semua)")
        for i in range(0,3):
            j = input('jenis password : ')
            jenis.append(j)
            if j == 'semua':
                jenis = ['semua']
                break
        jenis = list(dict.fromkeys(jenis))
        for i in jenis:
            a = i.strip().lower()
            if a == 'angka':
                jenis_password.extend(angka)
            elif a == 'huruf':
                r = int(random.random())
                if r:
                    jenis_password.extend(huruf.upper())
                else:
                    jenis_password.extend(huruf)
            elif a == 'simbol':
                jenis_password.extend(simbol)
            elif a == 'semua':
                jenis_password.extend(angka)
                r = int(random.random())
                if r:
                    jenis_password.extend(huruf.upper())
                else:
                    jenis_password.extend(huruf)
                jenis_password.extend(simbol)
        while panjang > 0:
            password.append(jenis_password[random.randrange(0,len(jenis_password))])
            panjang -= 1
        strpass = ''
        for n in password:
            strpass += n
        print('password :' , strpass)
        lagi = tanya()
    #except:
        #print('Ada input yang salah ')
print('terimakasih sudah mencoba password generator ini')
input()