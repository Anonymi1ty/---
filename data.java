package GUI.snake;

import java.net.URL;

import javax.swing.ImageIcon;

public class data {
    
    public static URL upUrl=data.class.getResource("statics/up.png");
    public static URL downUrl=data.class.getResource("statics/down.png");
    public static URL leftUrl=data.class.getResource("statics/left.png");
    public static URL rightUrl=data.class.getResource("statics/right.png");
    public static URL eatUrl=data.class.getResource("statics/eat.png");
    public static URL bodyUrl=data.class.getResource("statics/body.png");
    public static ImageIcon up =new ImageIcon(upUrl);
    public static ImageIcon down =new ImageIcon(downUrl);
    public static ImageIcon left =new ImageIcon(leftUrl);
    public static ImageIcon right =new ImageIcon(rightUrl);
    public static ImageIcon eat =new ImageIcon(eatUrl);
    public static ImageIcon body =new ImageIcon(bodyUrl);

    public static void main(String[] args) {
        System.out.println(upUrl);
    }
}
