import java.awt.*;
import java.awt.event.MouseEvent;

public class PoleEvent {
    private Pole source;
    public PoleEvent(Pole s) {
        source=s;
    }
    public Pole getSource()
    {
        return source;
    }
}