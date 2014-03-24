
// assignment 6
// partner1-Colcord-Austin
// partner1-acolcord
// partner2-Su-Jun
// partner2-jacklyso


/**
 * Interactions driver for the Eliza game.
 * 
 * @since 16 October 2013 
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Interactions{
  
  /**
   * Run the program - starting with the <code>eliza</code>
   * method.
   * 
   * @param args unused
   */
  public static void main(String[] args) {   
    
    Interactions i = new Interactions();
    i.eliza();
  }
  
  

  
  /**
   * Run the Eliza game
   */ 
  public void eliza(){
  
    BufferedReader input =
      new BufferedReader(new InputStreamReader(System.in));
    
    // define data you need to play the game ... REPLACE THIS WITH YOUR CODE !!!
    // ...
    
    System.out.println("Ask me a question. \n:>");
    try{
      String s = input.readLine();
      this.reset();
      Eliza eli = ez;
      while (!(s == null) && s.length() > 0){
    	  s = eli.answer(s);
    	  

    	  
    	  
      
        // mock code: echo every line
        System.out.println(s);
        
        // REPLACE THIS WITH YOUR CODE !!!
                                 // that finds out the reply to the question s
                                 // and prints the reply
        
        System.out.println(":>");
        s = input.readLine();
        if (s == null || s.length() == 0){
          System.out.println("Goodbye");
        }
      }
    }
    catch(IOException e){
        System.out.println("Goodbye");
    }  
  }

  Reply why = new Reply("Why", 
          new ArrayList<String>(Arrays.asList("Because I said so...",
                  "The reason is...", 
                  "I dont think you will figure that out...")));
  Reply who = new Reply("Who",
          new ArrayList<String>(Arrays.asList("A doctor...",
                  "Me...", 
                  "It is you...")));
  Reply how = new Reply("How", 
          new ArrayList<String>(Arrays.asList("You should ask...",
                  "It is gonna be...", 
                  "You will be fine...")));
  Reply where = new Reply("Where",
          new ArrayList<String>(Arrays.asList("Right here...",
                  "10 miles away...", 
                  "Some where you know...")));
  Reply when = new Reply("When",
          new ArrayList<String>(Arrays.asList("In 10 years...",
                  "Today...", 
                  "Never...")));
  Reply what = new Reply("What",
          new ArrayList<String>(Arrays.asList("Nothing...",
                  "It doesn't matter...", 
                  "I don't care...")));
	
	Eliza ez;
	ArrayList<Reply> eList;
	
	void reset() {
		eList = new ArrayList<Reply>();
		eList.add(why);
		eList.add(who);
		eList.add(where);
		eList.add(when);
		eList.add(how);
		eList.add(what);
		ez = new Eliza(eList);	
	}
}
