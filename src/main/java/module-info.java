module waterworld {
    requires hanyaeger;
    requires org.jetbrains.annotations;
    requires java.desktop;

    exports nl.thijsdewitt.han_bomber_knights;
    exports nl.thijsdewitt.han_bomber_knights.entities.map;
    exports nl.thijsdewitt.han_bomber_knights.entities.player;

    opens audio;
    opens sprites;
    exports nl.thijsdewitt.han_bomber_knights.entities.map.crate;
}
