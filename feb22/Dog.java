package feb22;


public class Dog implements Animal {
    @Override
    public void makeSound(){
        System.out.println("Dog make sound like : "+"woof");
    }
    public static void main(String[] args) {
        Animal obj = new Dog();
        obj.makeSound();
    }
    
}
