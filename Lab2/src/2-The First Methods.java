
// to represent a pet owner
class Person {
    String name;
    Pet pet;
    int age;
 
    Person(String name, Pet pet, int age) {
        this.name = name;
        this.pet = pet;
        this.age = age;
    }
    
  //is this person older than the given person?
    boolean isOlder(Person other) {
        return ((this.age - other.age) > 0);
    }
    
 // does the name of this person's pet match the given name?
    boolean sameNamePet(Person name) {
        return this.pet.name.equals(name);
    }

}


// to represent a pet
interface Pet {
    boolean isCat();
    boolean isDog();
    
    String petName();
}
 
// to represent a pet cat
class Cat implements Pet {
    String name;
    String kind;
    boolean longhaired;
 
    Cat(String name, String kind, boolean longhaired) {
        this.name = name;
        this.kind = kind;
        this.longhaired = longhaired;
    }
    public boolean isCat() {
        return true;
    }
    public boolean isDog() {
        return false;
    }
    public String petName() {
        return this.name;
    }
}
 

// to represent a pet dog
class Dog implements Pet {
    String name;
    String kind;
    boolean male;
 
    Dog(String name, String kind, boolean male) {
        this.name = name;
        this.kind = kind;
        this.male = male;
    }
    public boolean isCat() {
        return false;
    }
    public boolean isDog() {
        return true;
    }
    public String petName() {
        return this.name;
    }
}

//Examples
class ExamplesPerson {
    Pet fluffy = new Cat("fluffy", "Alaskan Cat", false);
    Pet skippy = new Dog("Spiky", "Terrier", true);
    
    Person chad = new Person("Chad", fluffy, 25);
    Person mary = new Person("Mary", fluffy, 21);
    Person joe = new Person("Joe", skippy, 45);
    Person angela = new Person("Angela", skippy, 82); 
}


