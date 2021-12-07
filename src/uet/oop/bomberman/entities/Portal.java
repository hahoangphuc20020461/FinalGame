package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.item.FlameUp;
import uet.oop.bomberman.entities.item.Item;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.music.Sound;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.player;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public class Portal extends Item {
    public static boolean isPortal = false;

    public Portal(int x, int y, Image img) {
        super(x, y, img);
    }

    private void intoThePortal() {
        for (Entity entity : stillObjects)
            if (entity instanceof Portal && !this.take)
                if (listKill[entity.getY() / SCALED_SIZE][entity.getX() / SCALED_SIZE] == '4')
                    entity.setImg(Sprite.portal.getFxImage());

        if (!this.take)
            if (Animal.size() == 0) {
                if (player.getX() == this.x && player.getY() == this.y) {
                    this.take = true;
                    isPortal = true;
                    Sound take = new Sound(Sound.takeItem);
                    take.play();
                }
            }
    }

    @Override
    public void update() {
    intoThePortal();
    }
}
