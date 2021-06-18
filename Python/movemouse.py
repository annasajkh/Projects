import pyautogui
import random
import time

pyautogui.FAILSAFE = False

while True:
    time.sleep(random.uniform(5,15))
    pyautogui.moveTo(random.randrange(0,1000),random.randrange(0,600),random.uniform(0.6, 2.7), [pyautogui.easeOutQuad,pyautogui.easeOutBack,pyautogui.easeInOutQuad][random.randrange(0,2)])
