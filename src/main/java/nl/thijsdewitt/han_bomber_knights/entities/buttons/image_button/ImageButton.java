package nl.thijsdewitt.han_bomber_knights.entities.buttons.image_button;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;

public class ImageButton extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private OnClickCallback onClickCallback;

    public ImageButton(Coordinate2D initialLocation, String imagePath, int width, int height) {
        super(imagePath, initialLocation, new Size(width, height));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        onClickCallback.onClick();
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }

    public void onClick(OnClickCallback callback) {
        onClickCallback = callback;
    }

    public interface OnClickCallback {
        void onClick();
    }
}
