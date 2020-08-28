import console_canvas
import random


console_canvas.create_screen(167, 42)
kotak = []


class Kotak:
    def __init__(self):
        self.x = random.randint(7, 150)
        self.y = random.randint(7, 35)

    def draw(self):
        console_canvas.draw_rect(self.x, self.y, 6, 3)


for i in range(0, 10):
    kotak.append(Kotak())

while(True):
    for i in kotak:
        i.draw()
    console_canvas.update()
