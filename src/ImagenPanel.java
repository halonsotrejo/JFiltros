
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

/**
 *
 * @author Trejo
 */

public class ImagenPanel extends JPanel{

    private Image img;
    private ImageObserver rootPane;

    ImagenPanel(){}
    public void setImagen(Image img){
        this.img = img;
    }
    public Image getImagen(){
        return this.img;
    }
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(img, 0, 0, this);
    }
}
