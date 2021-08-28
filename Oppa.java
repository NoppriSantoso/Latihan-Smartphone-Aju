
package smartphone;

import java.util.Random;


public class Oppa extends Smartphone
{
    private String Camera;

    public String getCamera() {
        return Camera;
    }

    public void setCamera(String Camera) {
        this.Camera = Camera;
    }

    public Oppa(String Camera, String phoneID, String phoneName, int price)
    {
        super(phoneID, phoneName, price);
        this.Camera = Camera;
    }

    @Override
    public String idGenerator() 
    {
        Random rand = new Random();
        int x= 100+rand.nextInt(500);
        return "OO"+x;
    }


    
    
}
