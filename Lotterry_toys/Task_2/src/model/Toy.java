package model;

public class Toy {
    int id;
    String name;
    int kolvo;
    int weight;

    public String info() {
        return "Toy.info : " +
                "id = " + this.getId() +
                " название = " + this.getName() +
                " количество = " + this.getKolvo() +
                " частота выпадания (вес)" + this.getWeight();
    }

    public Toy() {
    }

    public Toy(int id, String name, int kolvo, int weight) {
        this.id = id;
        this.name = name;
        this.kolvo = kolvo;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
