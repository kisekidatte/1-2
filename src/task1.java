import java.util.*;

class Team {
    String name;
    String city;
    int place;
    int wins;

}

class TeamInfo {
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Введите количество команд: ");
        int count = sc.nextInt();
        Team[] teams = new Team[count];

        for (int i = 0; i < count; i++) {
            teams[i] = new Team();
            sc.nextLine();
            System.out.println("Введите название: ");
            teams[i].name = sc.nextLine();
            System.out.println("Введите город: ");
            teams[i].city = sc.nextLine();
            System.out.println("Введите место в лиге: ");
            teams[i].place = sc.nextInt();
            System.out.println("Введите количество побед: ");
            teams[i].wins = sc.nextInt();

        }
        System.out.println("Введены следующие команды");
        for (int i = 0; i < teams.length; i++) {
            System.out.println(teams[i].name + " " + teams[i].city + " " + teams[i].place + " " + teams[i].wins);
        }

        int max = teams[0].wins;
        int indexMax = 0;
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].wins > max) {
                max = teams[i].wins;
                indexMax = i;
            }
        }
        System.out.println("Наибольшее количетсво побед:");
        System.out.println(teams[indexMax].name + " " + teams[indexMax].city + " " + teams[indexMax].place + " " + teams[indexMax].wins);

        System.out.println("Среднее количество побед: ");
        double avgWins = 0;
        for (int i = 0; i < teams.length; i++) {
            avgWins += teams[i].wins;
        }
        System.out.println("Команды с количеством побед выше среднего:");
        double avgW = avgWins / teams.length;
        System.out.println(avgW);
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].wins > avgW) {
                System.out.println(teams[i].name + " " + teams[i].city + " " + teams[i].place + " " + teams[i].wins);
            }
        }

        System.out.println("Сортировка массива:");
        boolean sorted = false;
        int rab;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < teams.length - 1; i++) {
                if (teams[i].place > teams[i + 1].place) {
                    sorted = false;
                    rab = teams[i].place;
                    teams[i].place = teams[i + 1].place;
                    teams[i + 1].place = rab;
                }
            }
        }
        for (int i = 0; i < teams.length; i++) {
            System.out.println(teams[i].name + " " + teams[i].city + " " + teams[i].place + " " + teams[i].wins);
        }

        sc.nextLine();
        System.out.println("Введите искомое имя:");
        String name = sc.nextLine();
        int index = -1;
        for (int i = 0; i < teams.length; i++) {
            if (name.equals(teams[i].name)) {
                index = i;
            }
        }
        if (index != -1) {
            System.out.println("Найдена запись!");
            System.out.println(teams[index]);
            System.out.println("Изменение поля:");
            System.out.println("name, city, place, wins");
            String editQuery = sc.nextLine();
            switch (editQuery) {
                case "name": {
                    System.out.println("Новое имя:");
                    String newName = sc.nextLine();
                    teams[index].name = newName;
                    break;
                }
                case "city": {
                    System.out.println("Новый город:");
                    String newCity = sc.nextLine();
                    teams[index].name = newCity;
                    break;
                }
                case "place": {
                    System.out.println("Новое место в лиге:");
                    String newPlace = sc.nextLine();
                    teams[index].name = newPlace;
                    break;
                }
                case "wins": {
                    System.out.println("Новое количество побед:");
                    String newWins = sc.nextLine();
                    teams[index].name = newWins;
                    break;
                }
                default: {
                    System.out.println("Поле ввода не существует");
                }
            }
        } else {
            System.out.println("Ничего не найдено!");
        }
        for (int j = 0; j < teams.length; j++) {
            System.out.println(teams[j].name + " " + teams[j].city + " " + teams[j].place + " " + teams[j].wins);
        }
    }
}