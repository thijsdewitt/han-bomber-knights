package nl.thijsdewitt.han_bomber_knights.entities.map.crate;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import nl.thijsdewitt.han_bomber_knights.entities.HUD.PowerUp;
import nl.thijsdewitt.han_bomber_knights.entities.map.CollidedTile;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.AbstractPowerUp;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.BiggerExplosionPowerUp;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.HealthPowerUp;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.SpeedUpPowerUp;

public class CrateEntity extends CompositeEntity implements MouseButtonPressedListener{
    Crate crate;
    AbstractPowerUp powerUp;
    Coordinate2D location;
    Size size;

    public CrateEntity(Coordinate2D location, Size size) {
        super(location);
        this.location = location;
        this.size = size;
    }

    public void destroy() {
        crate.remove();
        if(powerUp != null) {
            powerUp.setVisible(true);
        }
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        destroy();
    }

    @Override
    protected void setupEntities() {
        Coordinate2D center = new Coordinate2D();
        crate = new Crate(location, size);
        addEntity(crate);
        int random = (int) (Math.random() * 6);
        switch (random) {
            case 0:
                powerUp = new BiggerExplosionPowerUp(size);
                addEntity(powerUp);
                powerUp.setVisible(false);
                break;
                case 1:
                    powerUp = new HealthPowerUp(size);
                    addEntity(powerUp);
                    powerUp.setVisible(false);
                    break;
                    case 2:
                        powerUp = new SpeedUpPowerUp(size);
                        addEntity(powerUp);
                        powerUp.setVisible(false);
                        break;
                        default:
                            break;

        }


    }
}
