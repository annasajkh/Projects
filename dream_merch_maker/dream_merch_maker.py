from os import X_OK
from PIL import Image, ImageDraw
import random

image = Image.open(random.choice(["template/1.jpg","template/2.jpg"]))

draw = ImageDraw.Draw(image)

size = 3
x = 70
y = 58
x1 = x + 20
y1 = y

draw.ellipse([(x,y),(x + size,y + size)],"black")
draw.ellipse([(x1,y1),(x1 + size,y1 + size)],"black")
draw.arc([(x - 5,y + 5),(x1 + 10,y + 20)],0,180,"black",4)

image.show()