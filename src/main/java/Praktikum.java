public class Praktikum {

    /*
         В этом методе заложи логику работы с классом Account.
         Нужно создать экземпляр класса Account: в качестве аргумента передать тестируемое имя
         и вызвать метод, который проверяет, можно ли использовать фамилию и имя для
         печати на банковской карте.
     */

    public static void main(String[] args) {

        String name = "Тимоти Шаламе";
        Account account = new Account(name);

        if (account.checkNameToEmboss()) {
            System.out.println("Имя: [" + name + "] корректно");
        } else {
            System.out.println("Имя: [" + name + "] некорректно");
        }
    }
}
