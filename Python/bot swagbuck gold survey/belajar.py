import pyautogui
import random
from time import sleep
sleep(2)
while True:
    for i in range(random.randrange(350,450), random.randrange(550,650), 3):
        if i > random.randrange(480, 600) and i < random.randrange(548,647):
            pyautogui.click(1188, 300)
        pyautogui.click(1188, i)
