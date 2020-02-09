import javafx.scene.control.skin.CellSkinBase;

import javax.swing.plaf.metal.MetalSliderUI;
import java.awt.*;
import java.util.List;

public class Turn {
    private Plansza plansza;
    private List<List<Pole>> ehh;
    private int color;
    private Pionek tmpPionek;

    public Turn(Plansza p, int c) {
        plansza = p;
        ehh = plansza.getPlansza();
        color = c;
    }

    public void woborPionka(int x, int y) {
        int czyBicie = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                if (color == 0) {
                    if (ehh.get(i).get(j).ifPionek() == 1) {
                        if (ehh.get(i).get(j).getPionek().getColor() == 0)
                            czyBicie += ifbicie(i, j);

                    }
                } else {
                    if (ehh.get(i).get(j).ifPionek() == 1) {
                        if (ehh.get(i).get(j).getPionek().getColor() == 1)
                            czyBicie += ifbicie(i, j);

                    }
                }

        }
        if (ifbicie(x, y) == 1 && czyBicie != 0) {
            if (color == 0 && ehh.get(x).get(y).getPionekColor() == 0) {

                if (!(x == 0 || x == 7 || y == 0 || y == 7)) {
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y + 1) == 1) bicie(x, y, x + 1, y + 1);
                    }
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y - 1) == 1) bicie(x, y, x + 1, y - 1);
                    }
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y + 1) == 1) bicie(x, y, x - 1, y + 1);
                    }
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y - 1) == 1) bicie(x, y, x - 1, y - 1);
                    }

                    tmpPionek = ehh.get(x).get(y).getPionek();
                } else if (x == 0 && y == 0) {
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y + 1) == 1) bicie(x, y, x + 1, y + 1);
                    } else ehh.get(x + 1).get(y + 1).setFrame();
                    tmpPionek = ehh.get(x).get(y).getPionek();
                } else if (x == 7 && y == 0) {
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y + 1) == 1) bicie(x, y, x - 1, y + 1);
                    } else ehh.get(x - 1).get(y + 1).setFrame();
                    tmpPionek = ehh.get(x).get(y).getPionek();
                } else if (y == 0) {
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y + 1) == 1) bicie(x, y, x - 1, y + 1);
                    } else ehh.get(x - 1).get(y + 1).setFrame();
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y + 1) == 1) bicie(x, y, x + 1, y + 1);
                    } else ehh.get(x + 1).get(y + 1).setFrame();
                    tmpPionek = ehh.get(x).get(y).getPionek();
                } else if (x == 0) {
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y + 1) == 1) bicie(x, y, x + 1, y + 1);
                    } else if (ehh.get(x + 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y - 1) == 1) bicie(x, y, x + 1, y - 1);
                    } else ehh.get(x + 1).get(y + 1).setFrame();
                    tmpPionek = ehh.get(x).get(y).getPionek();
                } else if (x == 7) {
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y + 1) == 1) bicie(x, y, x - 1, y + 1);
                    } else ehh.get(x - 1).get(y + 1).setFrame();
                    tmpPionek = ehh.get(x).get(y).getPionek();

                }
            } else if (color == 1 && ehh.get(x).get(y).getPionekColor() == 1) {

                if (!(x == 0 || x == 7 || y == 0 || y == 7)) {
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y + 1) == 1) bicie(x, y, x + 1, y + 1);
                    }
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y - 1) == 1) bicie(x, y, x + 1, y - 1);
                    }
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y + 1) == 1) bicie(x, y, x - 1, y + 1);
                    }
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y - 1) == 1) bicie(x, y, x - 1, y - 1);
                    }
                    if (ifbicie(x, y) == 0) {
                        ehh.get(x - 1).get(y - 1).setFrame();
                        ehh.get(x + 1).get(y - 1).setFrame();
                    }
                    tmpPionek = ehh.get(x).get(y).getPionek();
                } else if (x == 0 && y == 7) {
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y - 1) == 1) bicie(x, y, x + 1, y - 1);
                    } else ehh.get(x + 1).get(y - 1).setFrame();
                    tmpPionek = ehh.get(x).get(y).getPionek();
                } else if (x == 7 && y == 7) {
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y - 1) == 1) bicie(x, y, x - 1, y - 1);
                    } else ehh.get(x - 1).get(y - 1).setFrame();
                    tmpPionek = ehh.get(x).get(y).getPionek();
                } else if (y == 7) {
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y - 1) == 1) bicie(x, y, x - 1, y - 1);
                    }
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y - 1) == 1) bicie(x, y, x + 1, y - 1);
                    }
                    if (czyBicie == 0) {
                        ehh.get(x + 1).get(y - 1).setFrame();
                        ehh.get(x - 1).get(y - 1).setFrame();

                    }
                    tmpPionek = ehh.get(x).get(y).getPionek();
                } else if (x == 0) {
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y - 1) == 1) bicie(x, y, x + 1, y - 1);
                    }
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x + 1, y + 1) == 1) bicie(x, y, x + 1, y + 1);
                    }
                    if (czyBicie == 0) {
                        ehh.get(x + 1).get(y - 1).setFrame();
                        ehh.get(x - 1).get(y - 1).setFrame();
                    }
                    tmpPionek = ehh.get(x).get(y).getPionek();
                } else if (x == 7) {
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y - 1) == 1) bicie(x, y, x - 1, y - 1);
                    }
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 1) {
                        if (checkColor(x, y, x - 1, y + 1) == 1) bicie(x, y, x - 1, y + 1);
                    }

                    tmpPionek = ehh.get(x).get(y).getPionek();
                }

            }
        } else if (ifbicie(x, y) == 0 && czyBicie == 0) {
            if (color == 0 && ehh.get(x).get(y).getPionekColor() == 0) {
                if (!(x == 0 || x == 7 || y == 0 || y == 7)) {
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 0) ehh.get(x + 1).get(y + 1).setFrame();
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 0) ehh.get(x - 1).get(y + 1).setFrame();
                } else if (x == 0 && y == 0) {
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 0) ehh.get(x + 1).get(y + 1).setFrame();
                } else if (x == 0 && y == 7) {
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 0) ehh.get(x - 1).get(y - 1).setFrame();
                } else if (x == 7 && y == 0) {
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 0) ehh.get(x - 1).get(y + 1).setFrame();
                } else if (x == 7 && y == 7) {
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 0) ehh.get(x - 1).get(y - 1).setFrame();
                } else if (x == 0) {
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 0) ehh.get(x + 1).get(y + 1).setFrame();
                } else if (x == 7) {
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 0) ehh.get(x - 1).get(y + 1).setFrame();
                } else if (y == 0) {
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 0) ehh.get(x + 1).get(y + 1).setFrame();
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 0) ehh.get(x - 1).get(y + 1).setFrame();
                } else if (y == 7) {
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 0) ehh.get(x + 1).get(y - 1).setFrame();
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 0) ehh.get(x - 1).get(y - 1).setFrame();
                }

                tmpPionek = ehh.get(x).get(y).getPionek();
            } else if (color == 1 && ehh.get(x).get(y).getPionekColor() == 1) {
                if (!(x == 0 || x == 7 || y == 0 || y == 7)) {
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 0) ehh.get(x + 1).get(y - 1).setFrame();
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 0) ehh.get(x - 1).get(y - 1).setFrame();
                } else if (x == 0 && y == 0) {
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 0) ehh.get(x + 1).get(y + 1).setFrame();
                } else if (x == 0 && y == 7) {
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 0) ehh.get(x - 1).get(y - 1).setFrame();
                } else if (x == 7 && y == 0) {
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 0) ehh.get(x - 1).get(y + 1).setFrame();
                } else if (x == 7 && y == 7) {
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 0) ehh.get(x - 1).get(y - 1).setFrame();
                } else if (x == 0) {
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 0) ehh.get(x + 1).get(y - 1).setFrame();
                } else if (x == 7) {
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 0) ehh.get(x - 1).get(y - 1).setFrame();
                } else if (y == 0) {
                    if (ehh.get(x + 1).get(y + 1).ifPionek() == 0) ehh.get(x + 1).get(y + 1).setFrame();
                    if (ehh.get(x - 1).get(y + 1).ifPionek() == 0) ehh.get(x - 1).get(y + 1).setFrame();
                } else if (y == 7) {
                    if (ehh.get(x + 1).get(y - 1).ifPionek() == 0) ehh.get(x + 1).get(y - 1).setFrame();
                    if (ehh.get(x - 1).get(y - 1).ifPionek() == 0) ehh.get(x - 1).get(y - 1).setFrame();
                }

                tmpPionek = ehh.get(x).get(y).getPionek();


            }
        }

    }

    private int checkColor(int x, int y, int xx, int yy) {
        if (ehh.get(x).get(y).getPionek().getColor() == ehh.get(xx).get(yy).getPionek().getColor()) return 0;
        else return 1;
    }

    private int ifbicie(int x, int y) {
        if (!(x == 0 || x == 7 || y == 0 || y == 7)) {
            if (ehh.get(x + 1).get(y + 1).ifPionek() == 1) {
                if (x + 1 <= 7 && y + 1 <= 7)
                {
                    if (ehh.get(x + 1).get(y + 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor())
                    {
                        if (x + 2 <= 7 && y + 2 <= 7)
                        {
                            if (ehh.get(x + 2).get(y + 2).ifPionek() == 0)
                                return 1;
                        }
                    }
                 }
            }
            if (ehh.get(x - 1).get(y + 1).ifPionek() == 1) {
                if (x - 1 <= 7 && y + 1 <= 7)
                {
                    if (ehh.get(x -1).get(y + 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor())
                    {
                        if (x - 2 >= 0 && y + 2 <= 7)
                        {
                            if (ehh.get(x - 2).get(y + 2).ifPionek() == 0)
                                return 1;
                        }
                    }
                }
            }
            if (ehh.get(x + 1).get(y - 1).ifPionek() == 1) {
                if (x + 1 <= 7 && y - 1 <= 7)
                {
                    if (ehh.get(x + 1).get(y - 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor())
                    {
                        if (x + 2 <= 7 && y - 2 >= 0)
                        {
                            if (ehh.get(x + 2).get(y - 2).ifPionek() == 0)
                                return 1;
                        }
                    }
                }
            }
            if (ehh.get(x - 1).get(y - 1).ifPionek() == 1) {
                if (x - 1 >= 0 && y - 1 >= 0)
                {
                    if (ehh.get(x - 1).get(y - 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor())
                    {
                        if (x - 2 >= 0 && y - 2 >= 0)
                        {
                            if (ehh.get(x - 2).get(y - 2).ifPionek() == 0)
                                return 1;
                        }
                    }
                }
            }
        } else if (y == 0 && x == 0) {
            if (ehh.get(x + 1).get(y + 1).ifPionek() == 1) {
                {
                    if (ehh.get(x + 1).get(y + 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor())
                    {
                        if(ehh.get(x+2).get(y+2).ifPionek()==0)
                            return 1;
                    }

                }
            }
        } else if (y == 7 && x == 0) {
            if (ehh.get(x + 1).get(y - 1).ifPionek() == 1) {
                if (ehh.get(x + 1).get(y - 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if(ehh.get(x+2).get(y-2).ifPionek()==0)
                        return 1;
                }

            }
        } else if (y == 0 && x == 7) {
            if (ehh.get(x - 1).get(y + 1).ifPionek() == 1) {
                if (ehh.get(x - 1).get(y + 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if (ehh.get(x - 2).get(y + 2).ifPionek() == 0)
                        return 1;
                }
            }
        } else if (y == 7 && x == 7) {
            if (ehh.get(x - 1).get(y - 1).ifPionek() == 1) {
                if (ehh.get(x - 1).get(y - 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if(ehh.get(x-2).get(y-2).ifPionek()==0)
                        return 1;
                }

            }
        } else if (y == 0) {
            if (ehh.get(x + 1).get(y + 1).ifPionek() == 1) {
                if (ehh.get(x + 1).get(y + 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if(x+2<7) {
                        if(ehh.get(x+2).get(y+2).ifPionek()==0)
                            return 1;
                    }

                }

            }
            if (ehh.get(x - 1).get(y + 1).ifPionek() == 1) {
                if (ehh.get(x - 1).get(y + 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if(x -2 >0) {
                        if(ehh.get(x-2).get(y+2).ifPionek()==0)
                            return 1;
                    }

                }

            }
        } else if (y == 7) {
            if (ehh.get(x + 1).get(y - 1).ifPionek() == 1) {
                if (ehh.get(x + 1).get(y - 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if(x+2 < 7) {
                        if(ehh.get(x+2).get(y-2).ifPionek()==0)
                            return 1;
                    }

                }

            }
            if (ehh.get(x - 1).get(y - 1).ifPionek() == 1) {
                if (ehh.get(x - 1).get(y - 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if(x-2 > 0) {
                        if(ehh.get(x-2).get(y-2).ifPionek()==0)
                            return 1;
                    }

                }

            }
        } else if (x == 0) {
            if (ehh.get(x + 1).get(y + 1).ifPionek() == 1) {
                if (ehh.get(x + 1).get(y + 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if(y+2 < 7) {
                        if(ehh.get(x+2).get(y+2).ifPionek()==0)
                            return 1;
                    }

                }

            }
            if (ehh.get(x + 1).get(y - 1).ifPionek() == 1) {
                if (ehh.get(x + 1).get(y - 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if(y-2 > 0) {
                        if(ehh.get(x+2).get(y-2).ifPionek()==0)
                            return 1;
                    }

                }

            }
        } else if (x == 7) {
            if (ehh.get(x - 1).get(y + 1).ifPionek() == 1) {
                if (ehh.get(x - 1).get(y + 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if(y+2 < 7) {
                        if(ehh.get(x+2).get(y+2).ifPionek()==0)
                            return 1;
                    }

                }

            }
            if (ehh.get(x - 1).get(y - 1).ifPionek() == 1) {
                if (ehh.get(x - 1).get(y - 1).getPionek().getColor() != ehh.get(x).get(y).getPionek().getColor()) {
                    if(y-2 > 0) {
                        if(ehh.get(x-2).get(y-2).ifPionek()==0)
                            return 1;
                    }

                }
            }
        }
        return 0;

    }

    private void bicie(int x, int y, int xx, int yy) {

        if (x + xx - x > 0 && xx + xx - x < 8 && yy + yy - y > 0 && yy + yy - y < 8) {
            if (ehh.get(xx + xx - x).get(yy + yy - y).ifPionek() == 0) {
                ehh.get(xx + xx - x).get(yy + yy - y).setFrame();

            }


        }

    }

    public void ruchPionk(int x, int y) {
        if (ehh.get(x).get(y).getFrame() == 1) {
            if (Math.abs(tmpPionek.getPos().x - x) > 1) {
                Point xy = tmpPionek.getPos();
                ehh.get(xy.x).get(xy.y).zdejminPionek();
                ehh.get(x - (x - xy.x) / 2).get(y - (y - xy.y) / 2).zdejminPionek();
                tmpPionek.setPos(x, y);
                ehh.get(x).get(y).postawPionek(tmpPionek.getColor());
            } else {
                Point xy = tmpPionek.getPos();
                ehh.get(xy.x).get(xy.y).zdejminPionek();
                tmpPionek.setPos(x, y);
                ehh.get(x).get(y).postawPionek(tmpPionek.getColor());
            }
        }

    }

    public void undoFrames() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                ehh.get(i).get(j).resetFrame();
        }
    }
}



