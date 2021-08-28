
package smartphone;

import java.util.ArrayList;
import java.util.Scanner;


public class Main
{
    //pemanggilan object
    Smartphone smartphone;
    
    //ArrayList
    ArrayList<Smartphone> smartphoneList = new ArrayList<>();
    
    //deklarasi global
    int menu = 0;
    Scanner scan = new Scanner(System.in);
    String name = "";
    int price = 0;
    int i = -1;
    String merk = "";
    int ram = 0;
    String camera = "";
    boolean search = false;
    int index = 0;

    void menu()
    {
        do
        {
            System.out.println("Menu");
            System.out.println("1. Insert Smartphone");
            System.out.println("2. View Smartphone");
            System.out.println("3. Delete Smartphone");
            System.out.println("4. Search Smartphone");
            System.out.println("5. Update Smartphone");
            System.out.print("Menu = ");menu = scan.nextInt();scan.nextLine();
            switch(menu)
            {
                case 1:
                    insert();
                    System.out.println("");
                    break;
                case 2:
                    view();
                    System.out.println("");
                    break;
                case 3:
                    delete();
                    System.out.println("");
                    break;
                case 4:
                    search();
                    System.out.println("");
                    break;
                case 5:
                    update();
                    System.out.println("");
                    break;
                default:
                    break;
            }
        }while(menu !=0);
    }
    
    void insert()
    {
        do
        {
            System.out.print("Insert Phone name = ");name = scan.nextLine();
            if(name.length()==0)
            {
                System.out.println("Input phone name!");
            }
        }while(name.length()==0);
        do
        {
            System.out.print("Input price = ");price = scan.nextInt();scan.nextLine();
            if(price == 0)
            {
                System.out.println("Input price");
            }
        }while(price == 0);
        do
        {
            System.out.print("Merk [Oppa | Samseng] = ");merk = scan.nextLine();
            
            if(!merk.equalsIgnoreCase("Oppa") && !merk.equalsIgnoreCase("Samseng"))
            {
                System.out.println("Pilih diantara Oppa atau samseng");
            }
            if(merk.equalsIgnoreCase("Oppa"))
            {
                System.out.print("Insert New Camera = ");camera = scan.nextLine();
                smartphone = new Oppa(camera, name, name, price);
                smartphoneList.add(smartphone); 
                menu();
            }
            if(merk.equalsIgnoreCase("Samseng"))
            {
                System.out.print("Insert Ram capacity = ");ram = scan.nextInt();scan.nextLine();
                smartphone = new Samseng(ram, name, name, price);
                smartphoneList.add(smartphone); 
                menu();
            }
        }while(!merk.equalsIgnoreCase("Oppa") && !merk.equalsIgnoreCase("Samseng"));
    }
    void view()
    {
        if(smartphoneList.isEmpty())
        {
            System.out.println("List is empty");
            return;
        }
            System.out.println("menu");
            System.out.println("1. ALL");
            System.out.println("2. Oppa");
            System.out.println("3. Samseng");
            System.out.print("Menu = ");menu = scan.nextInt();scan.nextLine();
            switch(menu)
            {
                case 1:
                    for (Smartphone smartphone : smartphoneList) 
                    {
                        if(smartphone instanceof Oppa)
                        {
                            Oppa oppa = (Oppa)smartphone;
                            System.out.println("Phone ID = "+oppa.idGenerator());
                            System.out.println("Phone name = "+oppa.getPhoneName());
                            System.out.println("Price = "+oppa.getPrice());
                            System.out.println("Camera = "+oppa.getCamera());
                            System.out.println("");
                        }
                        if(smartphone instanceof Samseng)
                        {
                            Samseng samseng = (Samseng)smartphone;
                            System.out.println("Phone ID = "+samseng.idGenerator());
                            System.out.println("Phone name = "+samseng.getPhoneName());
                            System.out.println("Price "+samseng.getPrice());
                            System.out.println("RAM = "+samseng.getRam());
                            System.out.println("");
                        }
                    }
                    break;
                case 2:
                    for (Smartphone smartphone : smartphoneList)
                    {
                        if(smartphone instanceof Oppa)
                        {
                            Oppa oppa = (Oppa)smartphone;
                            System.out.println("Phone ID = "+oppa.idGenerator());
                            System.out.println("Phone name = "+oppa.getPhoneName());
                            System.out.println("Price = "+oppa.getPrice());
                            System.out.println("Camera = "+oppa.getCamera());
                            System.out.println("");
                        }
                    }
                    break;
                case 3:
                    for (Smartphone smartphone : smartphoneList) 
                    {
                        if(smartphone instanceof Samseng)
                        {
                            Samseng samseng = (Samseng)smartphone;
                            System.out.println("Phone ID = "+samseng.idGenerator());
                            System.out.println("Phone name = "+samseng.getPhoneName());
                            System.out.println("Price = "+samseng.getPrice());
                            System.out.println("RAM = "+samseng.getRam());
                            System.out.println("");
                        }
                    }
                    break;
                default:
                    menu();
                    break;
            }
    }
    
    void search()
    {
        if(smartphoneList.isEmpty())
        {
            System.out.println("List is empty");
            return;
        }
        view();
        System.out.print("Search = ");name = scan.nextLine();
        for(i = 0;i<smartphoneList.size();i++)
        {
            if(name.equalsIgnoreCase(smartphoneList.get(i).getPhoneName()))
            {
                search = true;
                index = i;
            }
        }
        if(search == true)
        {
            if(smartphone instanceof Samseng)
            {
                Samseng samseng = (Samseng)smartphone;
                System.out.println("Smartphone Phone Id = "+samseng.idGenerator());
                System.out.println("Smartphone Name = "+smartphoneList.get(index).getPhoneName());
                System.out.println("Smartphone Price = "+smartphoneList.get(index).getPrice());
                System.out.println("Smartphone RAM = "+samseng.getRam());
            }
            if(smartphone instanceof Oppa)
            {
                Oppa oppa = (Oppa)smartphone;
                System.out.println("Smartphone Id = "+oppa.idGenerator());
                System.out.println("Smartphone Name = "+smartphoneList.get(index).getPhoneName());
                System.out.println("Smartphone Price = "+smartphoneList.get(index).getPrice());
                System.out.println("Smartphone Camera = "+oppa.getCamera());
            }
        }
        else
        {
            System.out.println("Tidak ada dalam list");
        }
    }
    void delete()
    {
        if(smartphoneList.isEmpty())
        {
            System.out.println("List is empty");
            return;
        }
        view();
        System.out.print("Search = ");name = scan.nextLine();
        for(i = 0;i<smartphoneList.size();i++)
        {
            if(name.equalsIgnoreCase(smartphoneList.get(i).getPhoneName()))
            {
                search = true;
                index = i;
            }
        }
        if(search == true)
        {
            smartphoneList.remove(index);
        }
        else
        {
            System.out.println("Tidak ada didalam list");
        }
    }
    void update()
    {
        if(smartphoneList.isEmpty())
        {
            System.out.println("List is empty");
            return;
        }
        view();
        System.out.print("Search = ");name = scan.nextLine();
        for(i = 0;i<smartphoneList.size();i++)
        {
            if(name.equalsIgnoreCase(smartphoneList.get(i).getPhoneName()))
            {
                search = true;
                index = i;
            }
        }
        if(search == true)
        {
            do
            {
                System.out.print("Insert Phone name = ");name = scan.nextLine();
                if(name.length()==0)
                {
                    System.out.println("Input phone name!");
                }
            }while(name.length()==0);
            do
            {
                System.out.print("Input price = ");price = scan.nextInt();scan.nextLine();
                if(price == 0)
                {
                    System.out.println("Input price");
                }
                smartphone = new Smartphone(name, name, price);
            }while(price == 0);
            do
            {
                System.out.print("Merk [Oppa | Samseng] = ");merk = scan.nextLine();

                if(!merk.equalsIgnoreCase("Oppa") && !merk.equalsIgnoreCase("Samseng"))
                {
                    System.out.println("Pilih diantara Oppa atau samseng");
                }
                if(merk.equalsIgnoreCase("Oppa"))
                {
                    System.out.print("Insert New Camera = ");camera = scan.nextLine();
                    smartphone = new Oppa(camera, name, name, price);
                    
                }
                if(merk.equalsIgnoreCase("Samseng"))
                {
                    System.out.print("Insert Ram capacity = ");ram = scan.nextInt();scan.nextLine();
                    smartphone = new Samseng(ram, name, name, price);
                }
            }while(!merk.equalsIgnoreCase("Oppa") && !merk.equalsIgnoreCase("Samseng"));
            smartphoneList.set(index, smartphone);
            }
            else
            {
                System.out.println("Tidak ada didalam list");
            }
    }
    public Main()
    {
        menu();
    }
    public static void main(String[] args) 
    {
        new Main();
    }
    
}
