import java.awt.*;
import java.util.Random;

public class Ball {
    public double x,y;
    public int width,height;
    public double dx, dy;
    public double speed = 1.7;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 4;
        this.height = 4;

        int angle = new Random().nextInt(120 - 45) + 46;
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }

    public void tick() {
        if (
            x + (dx * speed) + width >= Game.WIDTH ||
            x + (dx * speed) + width < 0
        ) {
            dx *= -1;
        }

        if (y >= Game.HEIGHT) {
            //Ponto do inimigo
            System.out.println("Ponto do inimigo!");
            new Game();
            return;
        } else if (y < 0) {
            //Ponto do jogador
            System.out.println("Aeee, ponto do jogador!");
            new Game();
            return;
        }

        Player playerLocal = Game.player;
        Enemy enemyLocal = Game.enemy;
        Rectangle bounds = new Rectangle((int) (x+(dx*speed)), (int) (y+(dy*speed)), width,height);
        Rectangle boundsPlayer = new Rectangle(playerLocal.x, playerLocal.y, playerLocal.width, playerLocal.height);
        Rectangle boundsEnemy = new Rectangle((int) enemyLocal.x, (int) enemyLocal.y, enemyLocal.width, enemyLocal.height);

        if (bounds.intersects(boundsPlayer)) {
            int angle = new Random().nextInt(120 - 45) + 46;
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dy > 0) {
                dy *= -1;
            }
        }
        if (bounds.intersects(boundsEnemy)) {
            int angle = new Random().nextInt(120 - 45) + 46;
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dy < 0) {
                dy *= -1;
            }
        }

        x += dx * speed;
        y += dy * speed;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.yellow);
        graphics.fillRect((int) x, (int) y, width,height);
    }
}
