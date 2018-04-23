import java.io.*;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;

//lee solo desde las coordenadas falta ajustar al txt original
public class Points extends JPanel
{
    ArrayList<Integer> xs = new ArrayList<>();
    ArrayList<Integer> ys = new ArrayList<>();
    ArrayList<Character> c = new ArrayList<>();
    
    public void paintComponent(Graphics g){
        graphPoints(g);
        // g.drawLine(100,100,101,101);
        // System.out.println(xs);
        // System.out.println(c);
    }
    
    public void graphPoints(Graphics g){
        for(int i = 0; i < xs.size(); i++){
            char l = c.get(i);
            if(l == 'd')g.setColor(Color.BLACK);
            if(l == 's')g.setColor(Color.RED);
            if(l == 'c')g.setColor(Color.GREEN);
            int x = xs.get(i), y = ys.get(i);
            g.fillOval(x,y,10,10);
            g.setColor(Color.BLACK);
            if(i < xs.size() - 1){
                g.drawLine(x + 5,y + 5,xs.get(i+1) + 5, ys.get(i+1) + 5);
            }
            g.drawString(l + "", x + 5, y - 3);
        }
    }

    Points() throws FileNotFoundException{
        Scanner sc = new Scanner(new File("Pointsxy.txt"));
        String line = sc.nextLine();
        for(int i = 0; i < 344; i++){
            Scanner inLine = new Scanner(line);
            int n = inLine.nextInt();
            String name = inLine.next();
            double x = inLine.nextDouble(), y = inLine.nextDouble();
            Character type = inLine.next().charAt(0);
            int nothing = inLine.nextInt();
            xs.add((int)(x * 10));
            ys.add((int)(y * 10));
            c.add(type);
            // g.drawLine((int)(x * 100),(int)(y * 100),(int)(x * 100),(int)(y * 100));
            line = sc.nextLine();
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        JFrame frame = new JFrame("Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Points());
        frame.setSize(2000, 2000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
