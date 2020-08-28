
print('Jurus Naga Kacang')
input()
panjang = 500
jumlah = 2
arah = 1
print('''       
            [][][][][][]>
[][][]       [][][o][]>
 [][][]     [][][][]>
  [][][]   [][][][]>
   [][][][][][][]>
    <[][][][][][][]>
    <[][][][][][][]>''')
while panjang>0:
    jumlah+=arah
    if jumlah == 21:
        arah = -1
    elif jumlah == 0:
        arah = 1
    panjang-=1

    print(' '*jumlah,'[][]"Kacang"[][]')
input()