
package commons;

import java.awt.Point;
import java.io.Serializable;


public class MouseDetails implements Serializable{
    
    
    public MouseDetails(Point p){
        this.mouseCoordinates = p;
    }
    
    
    public MouseDetails(Point p, int button){
        this.mouseCoordinates = p;
        this.button = button;
    }
    
    
    public Point getMouseCoordinates(){
        return mouseCoordinates;
    }
    
    /**
     * This method returns the button value.
     * @return the button value to be returned
     */
    public int getButton(){
        return button;
    }
    
    /*----------------------------------End of Methods----------------------------------*/
    
    //Variable declarations
    private Point mouseCoordinates = null;
    private int button = -1;
    //ENd of variable declarations
}
