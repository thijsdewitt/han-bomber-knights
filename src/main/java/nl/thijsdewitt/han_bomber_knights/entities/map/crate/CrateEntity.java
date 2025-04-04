package nl.thijsdewitt.han_bomber_knights.entities.map.crate;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.AbstractPowerUp;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.BiggerExplosionPowerUp;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.HealthPowerUp;
import nl.thijsdewitt.han_bomber_knights.entities.powerups.SpeedUpPowerUp;

public class CrateEntity extends CompositeEntity implements MouseButtonPressedListener {
    private Crate crate;
    private AbstractPowerUp powerUp;
    private final Size size;

    public CrateEntity(Coordinate2D location, Size size) {
        super(location);
        this.size = size;
    }

    public void destroy() {
        crate.remove();
        if (powerUp != null) {
            powerUp.setVisible(true);
        }
    }

    public Size getSize() {
        return size;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        destroy();
    }

    @Override
    protected void setupEntities() {
        crate = new Crate(this);
        addEntity(crate);

        int random = (int) (Math.random() * 6);
        powerUp = switch (random) {
            case 0 -> new BiggerExplosionPowerUp(size);
            case 1 -> new HealthPowerUp(size);
            case 2 -> new SpeedUpPowerUp(size);
            default -> null;
        };

        if (powerUp != null) {
            addEntity(powerUp);
            powerUp.setVisible(false);
        }
    }
}
