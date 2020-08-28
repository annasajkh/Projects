from os import system
from time import sleep

screen = []
frame_rate = 5
width = 0
height = 0


def create_screen(w, h):
    global width
    global height
    width = w
    height = h
    for y in range(0, h):
        screen.append([])
        for x in range(0, w):
            screen[y].append(' ')


def draw_rect(x, y, w, h):
    for rect_h in range(0, h):
        for rect_w in range(0, w):
            screen[y+rect_h][x+rect_w] = '#'


def clear():
    system('cls')


def update():
    global screen
    for y in screen:
        print(''.join(y))
    sleep(1/frame_rate)
    clear()
    screen = []
    for y in range(0, height):
        screen.append([])
        for x in range(0, width):
            screen[y].append(' ')
