module waterworld {
    requires hanyaeger;
    requires org.jetbrains.annotations;
    requires java.desktop;
    requires kotlin.stdlib;

    exports nl.thijsdewitt.han_bomber_knights;
    exports nl.thijsdewitt.han_bomber_knights.entities.map;

    opens tilemaps;
}
