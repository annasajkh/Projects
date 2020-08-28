#include <SFML/Graphics.hpp>

using namespace sf;

int main()
{
    RenderWindow game(VideoMode(800, 600), "Annas");
    RectangleShape kotak;
    kotak.setSize(Vector2f(50, 50));
    kotak.setPosition(400,300);
    while (game.isOpen()){
        Event event;
        while (game.pollEvent(event)){
            if (event.type == Event::Closed)
                game.close();
        }
        game.clear(Color::White);
        kotak.setFillColor(Color::Red);
        game.draw(kotak);
        game.display();
    }

    return 0;
}
