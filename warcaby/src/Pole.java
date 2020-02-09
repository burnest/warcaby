import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Pole {
    private int color;
    private Pionek p;
    private int pos_x;
    private int pos_y;
    private int frame;
    private Pole_hanler test;


    public Pole(int i,int x,int y)
    {
        color=i;
        pos_x=x;
        pos_y=y;
        frame=0;
        test = new Pole_hanler(this);

    }
    public int getPos_x()
    {
        return pos_x;
    }
    public int getPos_y()
    {
        return pos_y;
    }
    public  int getColor()
    {
        return color;
    }
    public void postawPionek(int c)
    {
        p= new Pionek(pos_x,pos_y,c);
    }
    public void zdejminPionek()
    {
        p=null;
    }
    public int ifPionek()
    {
        if(p == null)
            return 0;
        else return 1;
    }
    public int getFrame()
    {
        return frame;
    }
    public void setFrame()
    {
        frame=1;

    }
    public void resetFrame()
    {
        frame=0;

    }
    public int getPionekColor()
    {
        return p.getColor();
    }
    public Pionek getPionek()
    {
        return p;
    }

    public void useListener()
    {
        test.doAction(new PoleEvent(this));
    }

}
