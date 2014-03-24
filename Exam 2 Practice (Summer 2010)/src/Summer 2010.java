import tester.*;



class Registrar {
    ILoC courses;
    ILoSt students;
    
    Registrar(ILoC courses, ILoSt students) {
        this.courses = courses;
        this.students = students;
    }
    
    // register the student to the course
    public Registrar register(String name, int id, String course) {
        return (this.courses.inThisCList(course).equals()
    }
}


interface ILoC { 
    //does that course appear in this list
    public boolean inThisCList(Course that);
}

class MtLoC implements ILoC {
    MtLoC() { }
    
    //does that course appear in this list
    public boolean inThisCList(Course that) {
        return false;
    }
}

class ConsLoC implements ILoC {
    Course first;
    ILoC rest;
    
    ConsLoC(Course first, ILoC rest) {
        this.first = first;
        this.rest = rest;
    }
    
    //does that course appear in this list
    public boolean inThisCList(Course that) {
        return (this.first.equals(that) ||
                this.rest.inThisCList(that));
    }
}

class Course {
    String name;
    int credits;
    ILoSt students;
    
    Course(String name, int credits, ILoSt students) {
        this.name = name;
        this.credits = credits;
        this.students = students;
    }
}



interface ILoSt {
    //does the given student appear in this list
    public boolean inThisSList(Student that);
}

class MtLoSt implements ILoSt {
    MtLoSt() { }
    
    //does the given student appear in this list
    public boolean inThisSList(Student that) {
        return false;
    }
}

class ConsLoSt implements ILoSt {
    Student first;
    ILoSt rest;
    
    ConsLoSt(Student first, ILoSt rest) {
        this.first = first;
        this.rest = rest;
    }
    
    //does the given student appear in this list
    public boolean inThisSList(Student that) {
        return (this.first.equals(that) ||
                this.rest.inThisSList(that));
    }
}

class Student {
    String name;
    int id;
    ILoC courses;
    
    Student(String name, int id, ILoC courses) {
        this.name = name;
        this.id = id;
        this.courses = courses;
    }
}



class Examples {
    ILoC mtloc = new MtLoC();
    ILoSt mtlost = new MtLoSt();
    
    Student jan = new Student("Jan", 123, this.mtloc);
    Student dan = new Student("Dan", 234, this.mtloc);
    Student kim = new Student("Kim", 345, this.mtloc);
    Student pat = new Student("Pat", 567, this.mtloc);
    
    Course math = new Course("Math", 4, this.mtlost);
    Course chem = new Course("Chem", 4, this.mtlost);
    Course engl = new Course("Engl", 4, this.mtlost);
    Course hist = new Course("Hist", 4, this.mtlost);
    Course phys = new Course("Phys", 4, this.mtlost);
    Course comp = new Course("Comp", 4, this.mtlost);
    Course band = new Course("Band", 2, this.mtlost);
    Course swim = new Course("Swim", 2, this.mtlost);
    Course draw = new Course("Draw", 2, this.mtlost);
    
    ILoC allcourses = 
            new ConsLoC(this.math,
                    new ConsLoC(this.chem,
                            new ConsLoC(this.engl,
                                    new ConsLoC(this.hist,
                                            new ConsLoC(this.phys,
                                                    new ConsLoC(this.comp,
                                                            new ConsLoC(this.band,
                                                                    new ConsLoC(this.swim,
                                                                            new ConsLoC(this.draw, this.mtloc)))))))));
    
    ILoSt allstudents = 
            new ConsLoSt(this.jan,
                    new ConsLoSt(this.dan,
                            new ConsLoSt(this.kim,
                                    new ConsLoSt(this.pat, this.mtlost))));
    ILoSt ls1 = new ConsLoSt(this.jan, this.mtlost);
    ILoSt ls2 = new ConsLoSt(this.kim, this.ls1);
    
    ILoC lc1 = new ConsLoC(this.math, this.mtloc);
    ILoC lc2 = new ConsLoC(this.chem, this.lc1);
    
    Registrar regall = new Registrar(this.allcourses, this.allstudents);
    
    
    // test inThisSList
    void testInThisSList(Tester t) {
        t.checkExpect(this.mtlost.inThisSList(this.jan), false);
        t.checkExpect(this.ls1.inThisSList(this.jan), true);
        t.checkExpect(this.ls2.inThisSList(this.jan), true);
    }
            
    // test inThisCList
    void testInThisCList(Tester t) {
        t.checkExpect(this.mtloc.inThisCList(this.chem), false);
        t.checkExpect(this.lc1.inThisCList(this.math), true);
        t.checkExpect(this.lc2.inThisCList(this.math), true);
    }
    
}