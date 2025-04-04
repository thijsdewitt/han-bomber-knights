package nl.thijsdewitt.han_bomber_knights.entities.buttons.text_button;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class TextButton extends CompositeEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final TextButtonTitle textButtonTitle;
    private final TextButtonBox textButtonBox;
    private OnClickCallback onClickCallback;

    public TextButton(Coordinate2D initialLocation, String text) {
        this(initialLocation, text, 90);
    }

    public TextButton(Coordinate2D initialLocation, String text, int width) {
        super(initialLocation);
        textButtonTitle = new TextButtonTitle(new Coordinate2D(0, 0), text);
        textButtonBox = new TextButtonBox(new Coordinate2D(0, 0), width, 40);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        onClickCallback.onClick();
    }

    @Override
    public void onMouseEntered() {
        textButtonTitle.SetFill(Color.GREY);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        textButtonTitle.SetFill(Color.WHITE);
        setCursor(Cursor.DEFAULT);
    }

    public void onClick(OnClickCallback callback) {
        onClickCallback = callback;
    }

    @Override
    protected void setupEntities() {
        addEntity(textButtonBox);
        addEntity(textButtonTitle);
    }

    public interface OnClickCallback {
        void onClick();
    }
}
