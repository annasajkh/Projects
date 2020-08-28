import numpy as np
from PIL import ImageGrab
import pyautogui
import time


time.sleep(2)
pyautogui.PAUSE = 0
kecepatan = 0
pyautogui.press('space')

while True:
    img = np.array(ImageGrab.grab(bbox=(484, 207, 530 + kecepatan, 215)))
    if np.unique(img).size > 1:
        pyautogui.keyDown('space')
    if kecepatan < 170:
        kecepatan += 0.084
