module waterworld {
    requires hanyaeger;
    requires org.jetbrains.annotations;
    requires java.desktop;

    exports nl.thijsdewitt.han_bomber_knights;
    exports nl.thijsdewitt.han_bomber_knights.entities.map;

    opens audio;
    opens sprites;
}
