import java.awt.*;

public class Pionek {
    private int color;
    private int pos_x;
    private int pos_y;
    public Pionek(int x,int y,int c)
    {
        color=c;
        pos_x=x;
        pos_y=y;
    }
    public int getColor()
    {
        return color;
    }
    public Point getPos()
    {
        return new Point(pos_x,pos_y);
    }
    public void setPos(int x,int y)
    {
        pos_x=x;
        pos_y=y;
    }

}
