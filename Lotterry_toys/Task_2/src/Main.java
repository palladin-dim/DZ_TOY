import global.MyFileWriter;

import model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static global.Vars.allToys;
import static global.Vars.winsToys;

public class Main {

    public static void main(String[] args) {
        //Сначала создаем произвольные игрушки
        Toy toy1 = new Toy(1, "кукла", 10, 20);
        Toy toy2= new Toy(2, "машинка", 3, 5);
        Toy toy3 = new Toy(3, "мяч", 4, 10);
        Toy toy4 = new Toy(4, "медведь", 15, 30);
        Toy toy5 = new Toy(5, "собака", 6, 25);
        Toy toy6 = new Toy(6, "юла", 5, 8);

        //добавляем созданные игрушки в список (в обычный непризовой) с новым весом
        addToListWithNewWeight(toy1, 8);
        addToListWithNewWeight(toy2, 10);
        addToListWithNewWeight(toy3, 15);
        addToListWithNewWeight(toy4, 6);
        addToListWithNewWeight(toy5, 20);
        addToListWithNewWeight(toy6, 30);

        //показываем что у нас в общем списке игрушек
        System.out.println("Игрушек на прилавке: ");
        showNewList(allToys);

        //формируем список призовых игрушек (пусть это будут с весом от 20)
        List<Toy> addedWinners = selectToyByMinWeight(allToys, 20);
        winsToys.addAll(addedWinners);

        //отображаем призовые игрушки
        System.out.println("призовые игрушки: ");
        showNewList(winsToys);

        //выбираем призовую игрушку на выдачу из призового списка (пусть случайным образом)
        Toy givedWinner = selectRandomToy(winsToys);
        //удаляем выданную игрушку из списка к выдаче
        winsToys.remove(givedWinner);

        //отображаем инфо о призовой игрушке на выдачу
        System.out.println("Вы выиграли игрушку!: " + givedWinner.info());

        //пишем инфо в текстовый файл
        MyFileWriter.writeToy(givedWinner);

    }

    private static List<Toy> selectToyByMinWeight(ArrayList<Toy> allToys, int minWeight) {
        List<Toy> result = new ArrayList<>();
        for (Toy currentToy : allToys) {
            if (currentToy.getWeight() <= minWeight) {
                result.add(currentToy);
            }
        }
        return result;
    }

    private static Toy selectRandomToy(ArrayList<Toy> winsToys) {
        Random rand = new Random();
        int winnerElement = rand.nextInt(winsToys.size());
        return winsToys.get(winnerElement);
    }

    private static void addToListWithNewWeight(Toy newToy, int newWeight) {
        newToy.setWeight(newWeight);
        allToys.add(newToy);
    }

    private static void showNewList(ArrayList<Toy> myList) {
        int winListSize = myList.size();
        for (int i = 1; i < winListSize; i++) {
            System.out.print("игрушка - " + i + ": " + myList.get(i).getName() + ", ");
        }
        System.out.println("");
    }
}