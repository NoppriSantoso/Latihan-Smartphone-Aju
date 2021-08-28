
package smartphone;

import java.util.Random;


public class Smartphone 
{
    protected String phoneID;
    protected String phoneName;
    protected int price;
    Random rand = new Random();
    
    //setter getter

    public String getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(String phoneID) {
        this.phoneID = phoneID;
    }


    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    //counstructor

    public Smartphone(String phoneID, String phoneName, int price) 
    {
        this.phoneID = phoneID;
        this.phoneName = phoneName;
        this.price = price;
    }
    
    public String idGenerator()
    {
        return null;
    }
    
}
