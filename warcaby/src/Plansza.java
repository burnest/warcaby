import javax.swing.*;
import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;

public class Plansza extends JComponent {
    private List<List<Pole>> Plansza = new ArrayList<java.util.List<Pole>>();

    public Plansza() {
        Plansza = new ArrayList<List<Pole>>();
        for (int i = 0; i < 8; i++) {
            List<Pole> tmp = new ArrayList<Pole>();
            for (int j = 0; j < 8; j += 2) {
                if (i % 2 == 0) {
                    tmp.add(new Pole(0, i, j));
                    tmp.add(new Pole(1, i, j + 1));
                } else {
                    tmp.add(new Pole(1, i, j));
                    tmp.add(new Pole(0, i, j + 1));
                }
            }
            Plansza.add(tmp);
        }
    }

    public void postawPioniki() {
        List<Pole> tmp = new ArrayList<Pole>();
        for (int i = 0; i < 8; i++) {
            tmp = Plansza.get(i);
            for (int j = 0; j < 8; j++) {
                if (tmp.get(j).getColor() == 1) {
                    if (j >= 0 && j < 3)
                        tmp.get(j).postawPionek(0);
                    else if (j >= 5 && j < 8)
                        tmp.get(j).postawPionek(1);
                }
            }
        }
    }


    public Pole getPole(int x,int y)
    {
        return Plansza.get(x).get(y);
    }
    public List<List<Pole>> getPlansza()
    {
        return Plansza;
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        List<Pole> tmp;
        for (int i = 0; i < 8; i++) {
            tmp = Plansza.get(i);
            for (int j = 0; j < 8; j++) {
                if (tmp.get(j).getColor() == 0)
                    g2d.setColor(Color.BLACK);
                else g2d.setColor(Color.red);
                g2d.fillRect(100 * tmp.get(j).getPos_x(), 100 * tmp.get(j).getPos_y(), 100, 100);

                if(tmp.get(j).ifPionek()==1)
                {   if(tmp.get(j).getPionekColor()==0)
                {
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(100 * tmp.get(j).getPos_x(), 100 * tmp.get(j).getPos_y(), 100, 100);
                }
                else
                {
                    g2d.setColor(Color.BLACK);
                    g2d.fillOval(100 * tmp.get(j).getPos_x(), 100 * tmp.get(j).getPos_y(), 100, 100);
                }
                }
                if(tmp.get(j).getFrame()==1)
                {
                    g2d.setColor(Color.GREEN);
                g2d.drawOval(100 * tmp.get(j).getPos_x(), 100 * tmp.get(j).getPos_y(), 100, 100);

                }
            }
        }

    }
}
