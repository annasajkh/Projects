from sys import stdout
from random import randint
from os import system

def word_in_the_index(inp ,word):
    result= []
    if 'jalankan' in inp:
        for i in range(0 ,len(word) -1):
            result.append(word[i] == inp[i])
    else:
        for i in range(0 ,len(inp.strip()) -1):
            result.append(word[i] == inp[i])
    
    return False not in result


while True:
    pointer = 0
    memory = [0] * 10
    index = 0
    loops = []
    jump = False
    loop_return_value = 0
    init_loop_return_value = ''
    is_in_curly_brackeys = False
    is_in_square_brackeys = False
    is_in_vertical_line = False
    is_end_of_vertical_line = False
    memory_length = ''
    pointer_index = ''
    try:
        inp = input('>')
        if word_in_the_index(inp ,'jalankan'):
            inp = inp[9:]
        elif word_in_the_index(inp ,'bersihkan'):
            system('cls')
            continue
        elif word_in_the_index(inp,'bantuan'):
            print('''
    Array Programing Language dibuat oleh Annas
    jalankan : mengeksekusi program (harus ada nama ektensi .apl)
    tentang : informasi program
    clear : membersihkan console
    syntax : + = menambah 1 angka ke sel yang ditunjuk pointer
            
             - = mengurangi 1 angka ke sel yang ditunjuk pointer
            
             > = mengerakan pointer ke kanan 1 sel
            
             < = mengerakan pointer ke kiri 1 sel

             , = menerima input
            
             . = mengeluarkan output karakter sesuai ANSI CHARACTER
             
             # = mengeluarkan output memori
            
             () = perulangan (loop) akan keluar (return) jika isi sel yang
             ditunjuk pointer sama dengan nilai kembali perulangan
            
             {n} = mendefinisikan nilai kembali perulangan dengan isi sel
             yang ditunjuk pointer nilai n adalah angka yang diinginakan
             (defaultnya 0)
            
             |n| = mengubah panjang memori, nilai n adalah angka yang diinginakan (defaultnya 0) 

             [n] = mengubah posisi pointer, nilai n adalah index pointer (index dimulai dari 0)
            
             ^ = mengubah index pointer dengan isi sel yang ditunjuk pointer

             ? = isi sel yang ditunjuk pointer dengan angka acak (0 - 255)
                ''')
            continue
        if '.apl' in inp:
            file = open(inp,'r')
            f = file.read()
            while index < len(f):
                if memory[pointer] > 255:
                    memory[pointer] = 0
                elif memory[pointer] < 0:
                    memory[pointer] = 255
                
                if pointer > len(memory)-1:
                    pointer = 0
                elif pointer < 0:
                    pointer = len(memory)-1
                
                if is_in_curly_brackeys:
                    if f[index] == '}':
                        is_in_curly_brackeys = False
                        loop_return_value = int(init_loop_return_value)
                        init_loop_return_value = ''
                    else:
                        init_loop_return_value += f[index]
                
                if is_in_square_brackeys:
                    if f[index] == ']':
                        is_in_square_brackeys = False
                        pointer = int(pointer_index)
                        pointer_index = ''
                    else:
                        pointer_index += f[index]
                
                if is_in_vertical_line:
                    if f[index] == '|':
                        is_end_of_vertical_line = True
                        is_in_vertical_line = False
                        memory = [0] * int(memory_length)
                        memory_length = ''
                    else:
                        memory_length += f[index]
                
                if not jump:
                    if f[index] == '+':
                        memory[pointer] += 1
                    elif f[index] == '-':
                        memory[pointer] -= 1
                    elif f[index] == '>':
                        pointer += 1
                    elif f[index] == '<':
                        pointer -= 1
                    elif f[index] == '(':
                        if memory[pointer] == loop_return_value:
                            jump = True
                        else:
                            loops.append(index)
                    elif f[index] == ',':
                        memory[pointer] = int(input())
                    elif f[index] == '.':
                        stdout.write(chr(memory[pointer]))
                    elif f[index] == '#':
                        print(memory)
                    elif f[index] == '{':
                        is_in_curly_brackeys = True
                    elif f[index] == '[':
                        is_in_square_brackeys = True
                    elif f[index] == '|' and not is_end_of_vertical_line:
                        is_in_vertical_line = True
                    elif f[index] == '^':
                        pointer = memory[pointer]
                    elif f[index] == '?':
                        memory[pointer] = randint(0,255)
                if f[index] == ')':
                    if not memory[pointer] == loop_return_value:
                        index = loops[len(loops)-1] - 1
                        loops.pop(len(loops)-1)
                    jump = False
                index+=1
                if is_end_of_vertical_line:
                    is_end_of_vertical_line = False
            file.close()
    except Exception as e:
        print(e)