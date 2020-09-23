import java.awt.*;
import javax.swing.*;

public class BallGame0 extends JFrame{

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");

    double x = 100;
    double y = 100;
    boolean right = true;//方向

    //画窗口的方法
    public void paint(Graphics g){
        System.out.println("test");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        if(right){
            x = x + 10;
        }else{
            x = x - 10;
        }

        if(x>470){
            right = false;
        }

        if(x<25){
            right = true;
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
        BallGame0 game = new BallGame0();
        game.launchFrame();
    }
}
