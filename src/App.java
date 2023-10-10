import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        PhoneBook pb=new PhoneBook();
        Scanner in = new Scanner(System.in);
        String command ="";
        do {
            System.out.println("Доступные команды: \n 1) /add\n 2) /del\n 3) /print\n 4) /q");
            System.out.println("Введите команду:");
            command = in.nextLine();

            if ("/add".equals(command))
            {
                System.out.println("Введите имя: ");
                 String name=in.nextLine();
                System.out.println("Введите телефон: ");
                if (in.hasNextLong())
                {
                    Long phone=in.nextLong();
                   if (pb.addPhone(name, phone))
                   {
                     System.out.println("Номер добавлен");
                   }
                   else {
                    System.out.println("Номер не добавлен. Возможно повтор");
                   }

                }
                else
                {
                    System.out.println("Некорректно введен номер");
                }
                pb.printPhoneBook();
            }
            if ("/del".equals(command))
            {
                System.out.println("Введите имя телефоны которого хотите удалить:");
                String name=in.nextLine();
                if (pb.deletePhone(name))
                {
                    System.out.println("Запись с именем " +name +" удалена");
                }
                else
                {
                    System.out.println("Запись " +name +" не найдена");
                }
                pb.printPhoneBook();
            }
            if ("/print".equals(command))
            {
                pb.printPhoneBook();
            }

        }
        while (!command.equals("/q"));
        in.close();
         
    }
}
