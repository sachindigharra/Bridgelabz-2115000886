package feb06;

interface Worker {
    void performDuties();
}

class PersonRestaurant { // Renamed to avoid conflict with the school Person class
    String name;
    int id;

    public PersonRestaurant(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends PersonRestaurant implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Cooking delicious food");
    }
}

class Waiter extends PersonRestaurant implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Serving customers");
    }
}
