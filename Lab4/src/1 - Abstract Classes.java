import tester.*;

//////////////////////////////////////////////////////////////////////////////
//ABook 
abstract class ABook {
    String title;
    int dayTaken;
    
    ABook(String title, int dayTaken) {
        this.title = title;
        this.dayTaken = dayTaken;
    }
    
    //Reference books can be taken out for two days, 
    //other kinds of books for two weeks. 
    //daysOverdue(int today)
    public abstract int daysOverdue(int today);
    
    //isOverdue(int today)
    public boolean isOverdue(int today) {
        return (this.daysOverdue(today) > 0);
    }
    
    //computeFine(int today)
    public abstract int computeFine(int today);
}

//////////////////////////////////////////////////////////////////////////////

//Book
class Book extends ABook {
    String author;
    
    Book(String author, String title, int dayTaken) {
        super(title, dayTaken);
        this.author = author;
    }
    //daysOverdue() tells how many days the book is overdue
    public int daysOverdue(int today) {
        return today - this.dayTaken - 14;
    }
    
    //computeFine() computes the fine for the book if overdue
    public int computeFine(int today) {
        if (this.isOverdue(today)) {
            return (this.daysOverdue(today) * 10);
        }
        else return 0;
    }
}

//////////////////////////////////////////////////////////////////////////////
//RefBook
class RefBook extends ABook {
    RefBook(String title, int dayTaken) {
        super(title, dayTaken);
    }
    //daysOverdue() tells how many days the book is overdue
    public int daysOverdue(int today) {
        return today - this.dayTaken - 2;
    }

    //computeFine() computes the fine for the book if overdue
    public int computeFine(int today) {
        if (this.isOverdue(today)) {
            return (this.daysOverdue(today) * 10);
        }
        else return 0;
    }
}

//////////////////////////////////////////////////////////////////////////////
//AudioBook
class AudioBook extends ABook {
    String author;

    AudioBook(String author, String title, int dayTaken) {
        super(title, dayTaken);
        this.author = author;
    }
    //daysOverdue() tells how many days the book is overdue
    public int daysOverdue(int today) {
        return today - this.dayTaken - 14;
    }

    //computeFine() computes the fine for the book if overdue
    public int computeFine(int today) {
        if (this.isOverdue(today)) {
            return (this.daysOverdue(today) * 20);
        }
        else return 0;
    }
}

//////////////////////////////////////////////////////////////////////////////
//Examples
class ExamplesBooks {
    ABook book1 = new Book("Harry Potter", "JK Rowling", 400);
    ABook book2 = new Book("Hello", "Yo", 500);
    
    ABook refbook1 = new RefBook("World", 450);
    ABook refbook2 = new RefBook("Mexico", 460);
    
    ABook audio1 = new AudioBook("Talking", "Mary K", 350);
    ABook audio2 = new AudioBook("Speaking", "George E", 400);
    
    
    //examples daysOverdue()
    boolean testDaysOverdue(Tester t) {
        return t.checkExpect(this.book1.daysOverdue(414), 0) &&
               t.checkExpect(this.refbook1.daysOverdue(500), 48) &&
               t.checkExpect(this.audio1.daysOverdue(351), -13);
    }
    
    //examples isOverdue()
    boolean testIsOverdue(Tester t) {
        return t.checkExpect(this.book2.isOverdue(600), true) &&
                t.checkExpect(this.refbook2.isOverdue(462), false) &&
                t.checkExpect(this.audio2.isOverdue(401), false);
    }
    
    //examples computeFine()
    boolean testComputeFine(Tester t) {
        return t.checkExpect(this.book1.computeFine(416), 20) &&
                t.checkExpect(this.refbook2.computeFine(462), 0) &&
                t.checkExpect(this.audio2.computeFine(400), 0);
    }
}