import java.awt.*;

public class Player {
    public boolean right, left;
    public int x,y, width, height;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 5;
    }

    public void tick() {
        if (right) {
            x++;
        } else if (left) {
            x--;
        }

        if (x + width > Game.WIDTH) {
            x = Game.WIDTH - width;
        } else if (x < 0) {
            x = 0;
        }
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillRect(x, y,width, height);
    }
}
