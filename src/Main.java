import java.awt.*;

import javax.swing.*;

public class Main extends JFrame {

    int x, y, trigFunc;
    enum TrigonometricFunctions {
        SIN,
        COS,
        TAN,
        COSEC,
        SEC,
        COT
    }
    TrigonometricFunctions trigFunction;

    public Main() {
        setTitle("Trigonometric Functions Graph");
        setSize(1365,740);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x = 0;
        y = 300;
        trigFunction = TrigonometricFunctions.SIN;
        trigFunc = 0;
    }

    public void paint(Graphics g) {

        g.drawLine(687, 0, 687, 740);
        g.drawLine(0, 373, 1365, 373);

        if(trigFunction == TrigonometricFunctions.SIN) {
            g.setColor(Color.YELLOW);
        }else if(trigFunction == TrigonometricFunctions.COS) {
            g.setColor(Color.GRAY);
        }else if(trigFunction == TrigonometricFunctions.TAN) {
            g.setColor(Color.GREEN);
        }else if(trigFunction == TrigonometricFunctions.COSEC) {
            g.setColor(Color.RED);
        }else if(trigFunction == TrigonometricFunctions.SEC) {
            g.setColor(Color.BLACK);
        }else if(trigFunction == TrigonometricFunctions.COT) {
            g.setColor(Color.BLUE);
        }

        g.fillOval(x,y,5,5);
        run();
        repaint();

    }

    public void run() {
        try {

            Thread.sleep(5);
            int ax,by;

            ax = x-685;
            by = y-373;

            if(trigFunction == TrigonometricFunctions.SIN) {
                by = (int) (150*Math.sin(0.2*ax/5));
            }else if(trigFunction == TrigonometricFunctions.COS) {
                by = (int) (150*Math.cos(0.2*ax/5));
            }else if(trigFunction == TrigonometricFunctions.TAN) {
                by = (int) (150*Math.tan(0.2*ax/10));
            }else if(trigFunction == TrigonometricFunctions.COSEC) {
                by = (int) (150*(1/Math.sin(0.2*ax/5)));
            }else if(trigFunction == TrigonometricFunctions.SEC) {
                by = (int) (150*(1/Math.cos(0.2*ax/5)));
            }else if(trigFunction == TrigonometricFunctions.COT) {
                by = (int) (150*(1/Math.tan(0.2*ax/10)));
            }

            x = ax+685;
            y = 373-by;

            if(x == 1365 && trigFunc < 5) {
                trigFunc++;

                if(trigFunc == 1){
                    trigFunction = TrigonometricFunctions.COS;
                }else if(trigFunc == 2){
                    trigFunction = TrigonometricFunctions.TAN;
                }else if(trigFunc == 3){
                    trigFunction = TrigonometricFunctions.COSEC;
                }else if(trigFunc == 4){
                    trigFunction = TrigonometricFunctions.SEC;
                }else if(trigFunc == 5){
                    trigFunction = TrigonometricFunctions.COT;
                }

                x = 0;
                y = 300;
            }

            do {
                x++;
            }while(x > 1365);

        }catch(Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}