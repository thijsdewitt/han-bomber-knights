module bomber_knights {
    requires hanyaeger;
    requires org.jetbrains.annotations;
    requires java.desktop;

    exports nl.thijsdewitt.han_bomber_knights;
    exports nl.thijsdewitt.han_bomber_knights.entities.bomb;
    exports nl.thijsdewitt.han_bomber_knights.entities.map;
    exports nl.thijsdewitt.han_bomber_knights.entities.player;
    exports nl.thijsdewitt.han_bomber_knights.entities.powerups;
    exports nl.thijsdewitt.han_bomber_knights.entities.HUD;

    opens audio;
    opens sprites;
    exports nl.thijsdewitt.han_bomber_knights.entities.map.crate;
}
