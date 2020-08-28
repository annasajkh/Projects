from time import sleep
from os import system

kalimat = "Hallo Namaku Annas                    "
arr = []

for i in kalimat:
    arr.append(i)


def clear():
    system("cls")


while True:
    kata_0 = arr.pop(0)
    arr.append(kata_0)
    print("".join(arr))
    sleep(0.1)
    clear()
