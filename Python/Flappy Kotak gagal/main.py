import pygame
import neat
import time
import os
import random

window = pygame.display.set_mode((800, 500))
pygame.display.set_caption("Flappy Kotak")


class Pipa:
    def __init__(self, posx, h):
        self.rect_atas = pygame.Rect(posx, 0, 40, h)
        self.rect_bawah = pygame.Rect(posx, 500, 40, - (500 - h - 120))
        self.x = posx

    def draw(self):
        pygame.draw.rect(window, (0, 255, 0), self.rect_atas)
        pygame.draw.rect(window, (0, 255, 0), self.rect_bawah)
        self.rect_atas.x = int(self.x)
        self.rect_bawah.x = int(self.x)
        self.x += -0.2


class Burung:
    def __init__(self, y):
        self.vel = 0
        self.force = 0
        self.rect = pygame.Rect(100, 400, 40, 40)
        self.y = 400

    def flap(self):
        self.vel = -1

    def draw(self):
        self.rect.y = int(self.y)
        self.y += self.vel
        self.vel += 0.01
        pygame.draw.rect(window, (0, 0, 255), self.rect)


pipa = []
burung = Burung(100)
for i in range(0, 840, 280):
    pipa.append(Pipa(800 + i, random.randint(120, 380)))


def restart():
    pipa.clear()
    for i in range(0, 840, 280):
        pipa.append(Pipa(800 + i, random.randint(120, 380)))


while True:
    window.fill((255, 255, 255))
    burung.draw()
    for i in pipa:
        i.draw()
        if i.rect_atas.colliderect(burung.rect) or i.rect_bawah.colliderect(burung.rect):
            print('aa')
        if i.rect_atas.x < -40:
            pipa.pop(pipa.index(i))
            pipa.append(Pipa(800, random.randint(120, 380)))
    pygame.display.flip()
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            exit(0)
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE:
                burung.flap()
