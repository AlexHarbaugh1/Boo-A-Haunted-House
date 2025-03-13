package Screen;
import java.awt.*;
import javax.swing.JFrame;


public class Screen {
    
    private GraphicsDevice vc;
    
    public Screen() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = env.getDefaultScreenDevice();
    }
    
    public void setFullscreen(DisplayMode dm, JFrame window) {
        window.setUndecorated(true);
        window.setResizable(false);
        vc.setFullScreenWindow(window);
        
        if(dm != null && vc.isDisplayChangeSupported()) {
            try{
                vc.setDisplayMode(dm);
            }catch(Exception ex) {}
        }
             
    }
    
    public Window getFullScreenWindow() {
        return vc.getFullScreenWindow();
    }
    
    public void restoreScreen() {
        Window w = vc.getFullScreenWindow();
        if(w != null){
            w.dispose();
        }
        vc.setFullScreenWindow(null);
    }
}
class alex extends JFrame {
    public static void main(String[] args) {
        
        DisplayMode dm = new DisplayMode(800,600,16, DisplayMode.REFRESH_RATE_UNKNOWN);
        alex b = new alex();
        b.run(dm);
    }
    
    public void run (DisplayMode dm) {
        setBackground(Color.PINK);
        setForeground(Color.WHITE);
        setFont(new Font("Arial" , Font.PLAIN, 24));
        
        Screen s = new Screen();
        try {
            s.setFullscreen(dm, this);
            try{
                Thread.sleep(5000);
            }catch(Exception ex) {}
        }finally{
            s.restoreScreen();
        }
    }
    
    public void paint(Graphics g) {
        g.drawString("This is gonna be awesome", 200, 200);
    }
}
