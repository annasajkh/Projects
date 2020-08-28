const canvas = document.getElementById('cnv')
canvas.style.border = '1px solid'
const ctx = canvas.getContext('2d')

let snake = []
let food = new Food()
snake.push(new Head())
snake.push(new Tail(snake[0].x - snake[0].dir.x, snake[0].y - snake[0].dir.y, snake[0].dir.x, snake[0].dir.y))


function lose() {
    snake = []
    snake.push(new Head())
    snake.push(new Tail(snake[0].x - snake[0].dir.x, snake[0].y - snake[0].dir.y, snake[0].dir.x, snake[0].dir.y))
}

setInterval(() => {
    for (let i = 1; i < snake.length; i++)
        if (snake[0].x == snake[i].x && snake[0].y == snake[i].y)
            lose()
    if (snake[0].x == 800)
        lose()
    else if (snake[0].x < 0)
        lose()
    else if (snake[0].y == 600)
        lose()
    else if (snake[0].y < 0)
        lose()
    ctx.clearRect(0, 0, 800, 600)
    for (let i = snake.length - 1; i > -1; i--) {
        snake[i].drawUpdate()
        if (i != 0) {
            snake[i].dir.x = snake[i - 1].dir.x
            snake[i].dir.y = snake[i - 1].dir.y
        }
    }
    food.drawUpdate()
    ctx.restore()
}, 150)

window.addEventListener('keypress', (e) => {
    if (e.key == 'a' && snake[0].dir.x != 20) {
        snake[0].dir.x = -20
        snake[0].dir.y = 0
    } else if (e.key == 'd' && snake[0].dir.x != -20) {
        snake[0].dir.x = 20
        snake[0].dir.y = 0
    } else if (e.key == 'w' && snake[0].dir.y != 20) {
        snake[0].dir.y = -20
        snake[0].dir.x = 0
    } else if (e.key == 's' && snake[0].dir.y != -20) {
        snake[0].dir.y = 20
        snake[0].dir.x = 0
    }
})