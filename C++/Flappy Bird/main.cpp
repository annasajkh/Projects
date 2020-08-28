#include <windows.h>
#include <stdio.h>
#include <conio.h>

char display[20][20];

int enemys[10][2];
int playerY = 10;
int playerX = 15;
char player = 'O';
char input;
bool gameEnd = false;

void construct(){
    for(int i = 0;i < 10;i++){
        enemys[i][0] = 1;
        enemys[i][1] = rand()% 20;
    }

    for(int x = 0;x < 20;x++)
        for(int y = 0;y < 20;y++)
            display[x][y] = ' ';
}

void draw(){
    for(int x =0;x<20;x++){
        for(int y = 0;y<20;y++)
            printf("%c",display[x][y]);
        printf("%c",'\n');
    }
}

int main(){
    construct();
    while(!gameEnd){
        if(enemys[0][0] == 19)
            construct();
        display[playerX][playerY] = player;

        for(int i = 0;i < 10;i++)
            enemys[i][0]++;
        draw();
        input = getch();

        for(int i = 0;i < 10;i++){
            if(playerY == enemys[i][1] && playerX == enemys[i][0])
                gameEnd = true;
            display[enemys[i][0]-1][enemys[i][1]] = ' ';
            display[enemys[i][0]][enemys[i][1]] = 'X';

            if(playerY == enemys[i][1] && playerX == enemys[i][0])
                gameEnd = true;
        }
        switch(input){
        case 'a':
            playerY-=2;
            display[playerX][playerY+2]= ' ';
        case 'd':
            playerY++;
            display[playerX][playerY-1]= ' ';
        }

        system("cls");
    }
    printf("Kamu kalah pencet enter untuk keluar...");
    getchar();
    return 0;
}
