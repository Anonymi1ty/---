package GUI.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 每个格子长25

public class GamePanel extends JPanel implements KeyListener,ActionListener{//继承1为了键盘监听 继承2为了监听事件
    // 定义蛇的数据结构
    int length;//蛇的长度
    int[] snakeX=new int[100];//存储蛇X坐标
    int[] snakeY=new int[100];//存储蛇Y坐标
    String Direction;//方向

    int foodX;//食物的x坐标
    int foodY;//食物的y坐标

    boolean isStart=false;//默认游戏状态 默认是不开始
    Timer timer;    // 定时器
    Random random=new Random();

    // 构造器   被创造对象时就可以执行的功能
    public GamePanel() {
        init();

        // 获得焦点和键盘事件   
        this.setFocusable(true);//获得焦点事件  只有焦点事件添加后 监听才会聚焦到该栏目
        this.addKeyListener(this);//获得键盘监听事件
        timer.start();//游戏一开始就启动
    }

    // 初始化方法
    public void init(){
        // 初始长3节
        length=3;
        snakeX[0]=100;snakeY[0]=100;//脑袋的坐标是4，4
        snakeX[1]=75;snakeY[1]=100;//第一个身体
        snakeX[2]=50;snakeY[2]=100;//第二个身体
        Direction= "R";//初始方向向右
        timer=new Timer(100, this);//定时器 100ms执行一次

        // 将食物随机分布到页面
        foodX=25+25*random.nextInt(34);//随机生成食物x变量
        foodY=25+25*random.nextInt(24);//随机生成食物x变量
    }




    @Override
    protected void paintComponent(Graphics g) {
        // 画笔 游戏中的所有画面都由此绘画
        super.paintComponent(g);//父类有清屏效果
        // 绘制静态面板
        g.fillRect(25, 25, 850, 650);//默认的游戏界面

        // 把小蛇头画上去   需要通过方向来判断
        if(Direction=="R"){
            data.right.paintIcon(this, g, snakeX[0], snakeY[0]);//头画到这个面板上，用g画笔，x画在.,y画在
        }else if(Direction=="L"){
            data.left.paintIcon(this, g, snakeX[0], snakeY[0]);//头画到这个面板上，用g画笔，x画在.,y画在
        }else if(Direction=="U"){
            data.up.paintIcon(this, g, snakeX[0], snakeY[0]);//头画到这个面板上，用g画笔，x画在.,y画在
        }else if(Direction=="D"){
            data.down.paintIcon(this, g, snakeX[0], snakeY[0]);//头画到这个面板上，用g画笔，x画在.,y画在
        }
        
        // 将食物画上去
        data.eat.paintIcon(this, g, foodX, foodY);

        // 身子
        for (int i = 1; i < length; i++) {
            data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }
        // 游戏状态
        if(isStart==false){
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("按下空格开始游戏", 300, 300);//设置字体内容
        }
        
    }

    // 键盘监听事件
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();// 获得键盘按键

        //游戏暂停  如果按下空格
        if (keyCode==KeyEvent.VK_SPACE) {
            isStart=!isStart;//取反

            repaint();//更新状态后重新绘制
        }

        // 小蛇移动
        if (keyCode==KeyEvent.VK_UP) {
            Direction="U";
        }else if (keyCode==KeyEvent.VK_DOWN) {
            Direction="D";
        }else if (keyCode==KeyEvent.VK_LEFT) {
            Direction="L";
        }else if (keyCode==KeyEvent.VK_RIGHT) {
            Direction="R";
        }

    }


    //事件监听 判断isStart的运行条件  需要通过固定时间刷新：1s10次
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart) {//如果游戏是开始状态就让蛇东动起来
            // 吃食物判断
            if (snakeX[0]==foodX&&snakeY[0]==foodY) {
                length++;//长度+1
                
                // 再次随机食物
                foodX=25+25*random.nextInt(34);
                foodY=25+25*random.nextInt(24);
            }
            //身子动 依次向前挪动一格
            for (int i = snakeX.length-1; i >0; i--) {
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            //头移动一格
            if(Direction.equals("R")){
                snakeX[0]=snakeX[0]+25;//向右移动的话 头向右动
                if (snakeX[0]>850) {snakeX[0]=25;}//边界判断
            }else if(Direction.equals("L")){
                snakeX[0]=snakeX[0]-25;
                if (snakeX[0]<25) {snakeX[0]=850;}//边界判断
            }else if(Direction.equals("U")){
                snakeY[0]=snakeY[0]-25;
                if (snakeY[0]<25) {snakeY[0]=650;}//边界判断
            }else if(Direction.equals("D")){
                snakeY[0]=snakeY[0]+25;
                if (snakeY[0]>650) {snakeY[0]=25;}//边界判断
            }

            repaint();//重画页面
        }
        timer.start();//定时器开启
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}
