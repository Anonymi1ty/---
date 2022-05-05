package GUI.snake;

import javax.swing.JFrame;

import javax.swing.WindowConstants;
public class StartGame {
    public static void main(String[] args) {
        // 设置启动栏
        JFrame jFrame = new JFrame();

        jFrame.setBounds(200, 200, 900, 720);//待会计算修改
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // 将写的函数插入
        jFrame.add(new GamePanel());
        
        jFrame.setVisible(true);
    }
}
