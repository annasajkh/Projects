class Food {
    constructor() {
        this.x = parseInt(Math.random() * 40) * 20
        this.y = parseInt(Math.random() * 30) * 20
    }
    drawUpdate() {
        ctx.fillStyle = 'green'
        ctx.fillRect(this.x, this.y, 20, 20)
        if (snake[0].x == this.x && snake[0].y == this.y) {
            snake.push(new Tail(snake[snake.length - 1].x - snake[snake.length - 1].dir.x, snake[snake.length - 1].y - snake[snake.length - 1].dir.y, snake[snake.length - 1].dir.x, snake[snake.length - 1].dir.y))
            this.x = parseInt(Math.random() * 40) * 20
            this.y = parseInt(Math.random() * 30) * 20
        }
    }
}

class Head {
    constructor() {
        this.x = 400
        this.y = 300
        this.dir = {
            x: 20,
            y: 0
        }
    }

    drawUpdate() {
        ctx.fillStyle = 'red'
        ctx.fillRect(this.x, this.y, 20, 20)
        this.x += this.dir.x
        this.y += this.dir.y
    }

}

class Tail {
    constructor(x, y, dx, dy) {
        this.x = x
        this.y = y
        this.dir = {
            x: dx,
            y: dy
        }
    }

    drawUpdate() {
        ctx.fillStyle = 'blue'
        ctx.fillRect(this.x, this.y, 20, 20)
        this.x += this.dir.x
        this.y += this.dir.y
    }
}