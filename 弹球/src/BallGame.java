import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");

    double x = 100;
    double y = 100;

    double degree = 3.14/3; //弧度，此处是60度

    //画窗口的方法
    public void paint(Graphics g){
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        x = x + 10*Math.cos(degree);
        y = y + 10*Math.sin(degree);

        if(y>225||y<30){
            degree = -degree;
        }

        if(x>470||x<25){
            degree = 3.14 - degree;
        }

    }

    //窗口加载
    void launchFrame(){
        setSize(525,290);
        setLocation(500,50);
        setVisible(true);

        //重画窗口,1s画25次
        while(true){
            repaint();
            try{
                Thread.sleep(40);//40ms,1s=1000ms
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        BallGame game = new BallGame();
        game.launchFrame();
    }
}

