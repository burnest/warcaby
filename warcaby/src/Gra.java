import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Gra{
    private Plansza p;
    private JFrame f;
    private Turn gracz1;
    private Turn gracz2;
    private int wacthdog;
    private int mouseX;
    private int mouseY;

    public Gra() {
        wacthdog=0;
        p=new Plansza();
        p.postawPioniki();
        gracz1=new Turn(p,0);   //gra białymi
        gracz2=new Turn(p,1);   //gra czarnymi
    }



    public void play()
    {
        f = new JFrame();
        f.setSize(900,900);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                mouseX=mouseEvent.getX();
                mouseY=mouseEvent.getY();
                int testX=mouseX/100;
                int testY=mouseY/100;
                if(wacthdog%2==0)
                {   if(p.getPole(testX,testY).getFrame()==0)
                {
                    gracz1.undoFrames();
                    gracz1.woborPionka(testX,testY);
                }
                else if(p.getPole(testX,testY).getFrame()==1)
                {
                    gracz1.ruchPionk(testX,testY);
                    gracz1.undoFrames();
                    wacthdog++;
                }
                }
                else
                {
                    if(p.getPole(testX,testY).getFrame()==0)
                    {
                        gracz2.undoFrames();
                        gracz2.woborPionka(testX,testY);
                    }
                    else if(p.getPole(testX,testY).getFrame()==1)
                    {
                        gracz2.ruchPionk(testX,testY);
                        gracz2.undoFrames();
                        wacthdog++;
                    }
                }

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        f.setVisible(true);
        while (true) {

            f.repaint();

        }
    }
}
