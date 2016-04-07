import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;
import java.awt.Graphics2D;
import java.lang.Math;
import java.util.Timer;
import java.util.TimerTask;  
import java.awt.geom.Arc2D;
/**
 * �� TUT2GAME - ������������������
 * 
 * @����: Episodes (LeCai)
 * @����: 
 */
public class TUT2GAME extends JApplet
{
    // ʵ����� - �����Լ��ı����滻���������
    private int x;
    private double angle=0;
    private double angle2=0.1;
    
    //��ʱ��
    Timer timer = new Timer();  
    int Interval = 500;
    
    
    Graphics bufferGraphics;
    Image offscreen;
    Dimension dim;
    int curX,curY;
    
   
     /**
     * �����������applet viewer���ã�֪ͨ���JApplet���Ѿ���װ��ϵͳ��
     * ��������start������һ�α�����֮ǰ������
     */
    public void init()
    {
      
        JRootPane rootPane = this.getRootPane();    
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
        
        dim = getSize();
        offscreen = createImage(dim.width,dim.height);
        
        bufferGraphics = offscreen.getGraphics();
        
    }
    
    
    

    /**
     * �����������applet viewer���ã�֪ͨ���JApplet��Ӧ�ÿ�ʼִ�С�
     * ��init��������֮���Լ�ÿ��Web��ҳ�����·��ʵ�ʱ�򱻵���
     */
    public void start()
    {
        // �ṩÿ����ҳ������ʱ��������Ҫ�Ĵ���

    }


    public void stop()
    {
        // �ṩ��ҳ�汻��һ��ҳ���滻����JApplet��destroy֮ǰ��Ҫִ�е�
        // ���κη���
    
    }

 
    public void destroy()
    {
        // �ṩJApplet��Ҫ��destroy֮ǰ��Ҫִ�еĴ���
        
    
    }


  
    public String getAppletInfo()
    {
        // ʹ�����Լ�����Ϣ�滻���µĴ���
        return "Title:   \nAuthor:   \nA simple applet example description. ";
    }



    public String[][] getParameterInfo()
    {
        // �ṩ���applet�Ĳ�����Ϣ
        String paramInfo[][] = {
                 {"firstParameter",    "1-10",    "��һ�����������"},
                 {"status", "boolean", "�ڶ������������"},
                 {"images",   "url",     "��������������"}
        };
        return paramInfo;
    }

    /**
     * applet��Paint����
     * 
     * @����  g   ���applet��Graphics����
     */
    //Double Buffing
    
    public void DoubleBuffer(Graphics g)
    {
        GL(g);
    }
    
    public void paint(Graphics g)
    {

        timer.schedule(new TimerTask() {  
              
            @Override  
            public void run() {  
                repaint();
            }  
        }, 0,Interval);         
       
        
        DoubleBuffer(g);
        g.drawImage(offscreen,0,0,this); 
        
    }
    
 
    public void GL(Graphics g)
    {
        bufferGraphics.clearRect(0,0,1000,1000); 
        System.out.println("Ticked Paint");
        Graphics2D g2d = (Graphics2D) bufferGraphics;
        //���任
        int POS[] = CorTransform(0,0);
        drawCenteredCircle(bufferGraphics,POS[0],POS[1],200);
        
    
        angle -= 0.001;
        //angle2 -= 0.0005;
        if(angle > 359) angle = 0;
        bufferGraphics.drawString("ANGLE:"+angle,200,500);
        //if( (0.1-angle2) < 0) timer.cancel();

        
        
  
       
        
        DrawAnimationLine(g2d,angle,POS[0],POS[1]);
        drawArc(g2d,POS[0],POS[1],8);    
        
    }
    
    public void DrawAnimationLine(Graphics2D g2d,double theta,int CX,int CY)
    {
       
        double X = (double) (100 * Math.cos(theta)  +  0 * Math.sin(theta))+CX;
        double Y = (double) (100 *Math.sin(theta)  +  0 * Math.cos(theta))+CY;
        
        g2d.draw(new Line2D.Double(CX,CY, X,Y));
        
        
    }
    
    public int[] CorTransform(int x,int y)
    {
        int NewCor[] = new int[2];
        NewCor[0]= (20 + x)*10;
        NewCor[1]= (20 + y)*10;
        return NewCor;
    }
    
    
    public void drawArc(Graphics2D g2d,double CX,double CY,int pie)
    {
        for (int i = 0; i< pie;i++)
        {
            
            g2d.draw(new Arc2D.Double(100, 100,200, 200,360*i /pie,360/pie,Arc2D.PIE));
        }


    }
    
    
    public void drawCenteredCircle(Graphics g, int x, int y, int r) 
    {
        x = x-(r/2);
        y = y-(r/2);
        g.drawOval(x,y,r,r);
    }
   
    

}
