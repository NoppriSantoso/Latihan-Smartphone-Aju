
package smartphone;

import java.util.Random;


public class Samseng extends Smartphone
{
    private int ram;

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public Samseng(int ram, String phoneID, String phoneName, int price)
    {
        super(phoneID, phoneName, price);
        this.ram = ram;
    }

    @Override
    public String idGenerator() {
        Random rand = new Random();
        int x= 100+rand.nextInt(500);
        return "SS"+x;
    }


}
