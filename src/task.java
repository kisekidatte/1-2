import java.util.*;
import static java.lang.Math.*;

/*Разработать класс для хранения информации о футбольных командах:
Название, город, место_в_лиге, количество_побед
и реализовать алгоритм работы с массивом данных объектов, в котором
требуется:
– определить команду с самым большим количеством побед;
– определить команды с количеством побед больше среднего;
– упорядочить массив по убыванию мест в лиге;
– организовать поиск по названию команды, исправление одного из полей
и вывод полной информации о команде после редактирования.*/

class Team {
    String name;
    String city;
    int place;
    int wins;

    public void printTeam() {
        System.out.println(this.name + " " + this.city + " " + this.place + " " + this.wins);
    }

}

class TeamInfo {
    static Scanner sc;

    public static Team[] fillArray(int count) {
        Team[] teams = new Team[count];
        for (int i = 0; i < count; i++) {
            teams[i] = new Team();
            System.out.println("Введите название: ");
            teams[i].name = sc.nextLine();
            System.out.println("Введите город: ");
            teams[i].city = sc.nextLine();
            System.out.println("Введите место в лиге: ");
            teams[i].place = sc.nextInt();
            System.out.println("Введите количество побед: ");
            teams[i].wins = sc.nextInt();
            sc.nextLine();
        }
        return teams;
    }

    public static void printTeams(Team[] teams){
        for (int i = 0; i < teams.length; i++){
            teams[i].printTeam();
        }
    }

    public static Team findBest(Team[] teams){
        int max = teams[0].wins;
        int indexMax = 0;
        for (int i = 0; i < teams.length; i++){
            if(teams[i].wins>max){
                max = teams[i].wins;
                indexMax = i;
            }
        }
        return teams[indexMax];
    }

    public static double winsAvg(Team[] teams){
        double avgWins = 0;
        for(int i = 0; i < teams.length; i++){
            avgWins += teams[i].wins;
        }
        return (avgWins / teams.length);
    }

    public static void printAvg(Team[] teams, double avgW){
        for (int i = 0; i < teams.length; i++){
            if (teams[i].wins > avgW){
                teams[i].printTeam();
            }
        }
    }

    public static Team[] findAvg(Team[] teams, double avgW){
        int countAvg = 0;
        for (int i = 0; i < teams.length; i++){
            if (teams[i].wins > avgW){
                countAvg++;
            }
        }
        Team[] teamAvg = new Team[countAvg];
        int a = 0;
        for (int i = 0; i < teams.length; i++){
            if(teams[i].wins > avgW){
                teamAvg[a] = teams[i];
                a++;
            }
        }
        return teamAvg;
    }
    public static int findTeam(Team[] teams, String name){
        int index = -1;
        for (int i = 0; i<teams.length; i++){
            if(name.equals(teams[i].name)){
                index = i;
            }
        }
        return index;
    }

    public static void sortPlace(Team[] teams){
        boolean sorted = false;
        int rab;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < teams.length-1; i++) {
                if (teams[i].place > teams[i+1].place) {
                    sorted = false;
                    rab = teams[i].place;
                    teams[i].place = teams[i+1].place;
                    teams[i+1].place = rab;
                }
            }
        }
    }

    public static void editTeam(Team team){
        System.out.println("Изменение поля:");
        System.out.println("name, city, place, wins");
        String editQuery = sc.nextLine();
        switch (editQuery){
            case "name": {
                System.out.println("Новое имя:");
                String newName = sc.nextLine();
                team.name = newName;
                break;
            }
            case "city": {
                System.out.println("Новый город:");
                String newCity = sc.nextLine();
                team.name = newCity;
                break;
            }
            case "place": {
                System.out.println("Новое место в лиге:");
                String newPlace = sc.nextLine();
                team.name = newPlace;
                break;
            }
            case "wins": {
                System.out.println("Новое количество побед:");
                String newWins = sc.nextLine();
                team.name = newWins;
                break;
            }
            default: {
                System.out.println("Поле ввода не существует");
            }
        }

    }
    public static void main(String[] args){
        Team team = new Team();

        sc = new Scanner(System.in);
        System.out.println("Введите количество команд: ");
        int count = sc.nextInt();
        sc.nextLine();
        Team[] teams = fillArray(count);
        printTeams(teams);
        Team teamB = findBest(teams);
        System.out.println("Наибольшее количетсво побед:");
        teamB.printTeam();
        double avgW = winsAvg(teams);
        System.out.println("Среднее количество побед: " + avgW);
        System.out.println("Команды с количеством побед выше среднего:");
        printAvg(teams, avgW);
        System.out.println("Сортировка массива:");
        sortPlace(teams);
        printTeams(teams);

        System.out.println("Введите искомое имя:");
        String nameFind = sc.nextLine();
        int indexF = findTeam(teams, nameFind);
        if (indexF != -1){
            System.out.println("Найдена запись!");
            System.out.println(teams[indexF]);
            editTeam(teams[indexF]);
        } else{
            System.out.println("Ничего не найдено!");
        }
        printTeams(teams);
    }
}