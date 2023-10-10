import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;




public class PhoneBook {

    private HashMap<String,Phones> phoneBookStorage;
    

    public PhoneBook() {
            phoneBookStorage=new HashMap<>();
            this.addPhone("Alex", 79311215555L);
            this.addPhone("Mery", 79501213322L);
            this.addPhone("Mery", 79501213332L);
            this.addPhone("Mery", 79501213321L);
            this.addPhone("Mery", 79501213325L);
            this.addPhone("Dude", 79081213311L);
            this.addPhone("Dude", 79081213312L);
            this.addPhone("Dude", 79081213322L);
           
    }

    //Добавить номер по имени, если номер в списке, то просто не добавит
    //Номера храним в переменной типа Long в формате 79998883333
    public boolean addPhone(String name, Long phoneNumber)
    {
        if (!phoneBookStorage.containsKey(name)) {
            phoneBookStorage.put(name, new Phones(name));
        }
        Phones phones=phoneBookStorage.get(name);
        boolean result=phones.addPhone(phoneNumber);
        return result;
    }
    
    public void printPhoneBook()
    {
       var list = new ArrayList<>(phoneBookStorage.values());
       Collections.sort(list, phoneCounComparator);
       for (var item : list) {
        System.out.println(item);
       }
     
    }

    public boolean deletePhone(String name)
    {
        if (phoneBookStorage.containsKey(name))
        {
            phoneBookStorage.remove(name);
            return true;
        }
        return false;
    }

    public static Comparator<Phones> phoneCounComparator = new Comparator<Phones>(){
         
        @Override
        public int compare(Phones c1, Phones c2) {
            return (int) (c2.getSize() - c1.getSize());
        }
    };

    
}
