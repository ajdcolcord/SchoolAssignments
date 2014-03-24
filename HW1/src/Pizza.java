// assignment 1
// pair xxx
// partner1-colcord-austin
// partner1-ajdcolcord
// partner2-su-jun
// partner2-jacklyso

// Problem 2

import tester.*;

/*
 +--------------+ 
 | IPizza       |<---------------------------------+
 +--------------+                                  |
 |              |----+------------------+          |
 +--------------+    |                  |          |
                     v                  v          |
              +--------------+  +---------------+  |
              |    Plain     |  |    Fancy      |  |
              +--------------+  +---------------+  |
              | String crust |  | IPizza base   |--+
              | String cheese|  | String topping|
              +--------------+  +---------------+
 */

//define interface IPizza
interface IPizza { }

//define Plain
//Plain takes a crust and a cheese
class Plain implements IPizza {
    String crust;
    String cheese;

    Plain(String crust, String cheese) {
        this.crust = crust;
        this.cheese = cheese;
    }
}

//define Fancy
//Fancy takes a base and a topping
class Fancy implements IPizza {
    IPizza base;
    String topping;

    Fancy(IPizza base, String topping) {
        this.base = base;
        this.topping = topping;
    }
}

//----------------------------------------------------------------------------
//Examples
class ExamplesPizza {
    IPizza order1;
    IPizza order2;

    ExamplesPizza() {
        order1 = new Fancy(new Fancy(new Plain(
                "thin crust", "mozarella"), "mushrooms"), "olives");
        order2 = new Fancy(new Fancy(new Plain(
                "deep dish", "mixed"), "pepperoni"), "onions");
    }

    boolean testPizza(Tester t) {
        return t.checkExpect(this.order1, 
                new Fancy(new Fancy(new Plain("thin crust", "mozarella"),
                        "mushrooms"), "olives")) &&
               t.checkExpect(this.order2, 
                new Fancy(new Fancy(new Plain("deep dish", "mixed"), 
                        "pepperoni"), "onions"));
    }
}
