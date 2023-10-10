import java.util.ArrayList;

public class Phones {
    ArrayList<Long> phoneList = new ArrayList<>();

    String name="";

    public Phones(String name) {
        this.name=name;
    }

    public int getSize(){
        return phoneList.size();
    }

    public boolean addPhone(Long phone){
        if (!phoneList.contains(phone))
        {
            phoneList.add(phone);
            return true;
        }
        return false;
    }

    public void deletePhone(Long phone)
    {
        if (phoneList.contains(phone)){
            phoneList.remove(phone);
        }
    }
    @Override
    public String toString() {
        return name+" "+phoneList.toString();
    }
}
