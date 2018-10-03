/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;
import java.util.*;

/**
 *
 * @author Zachery Soles
 */
public class TextGame {
  static Player hero = new Player(null,10,1);
  static Scanner kb = new Scanner(System.in);
  static boolean pickUp;
  
  public static void dHallway(){
    Level dHallway = new Level("Downstairs Hallway", null, null, null);
    System.out.println("Infront of you is a long dark hallway that leads into a dark room with a single candle.");
    dHallway.setChoice1("1: walk down hallway");
    System.out.println(dHallway.getChoice1());
    String choice = kb.next();
    if(choice.equals("1"))
      livingRoom();
    else{
      System.out.println("Your choice is not valid. Enter in a new choice.");
      choice = kb.next();
      if(choice.equals(1))
        livingRoom();
    }
  }
  
  public static void livingRoom(){
    Item candle = new Item("Candle", 1);
    Enemy dog = new Enemy("Dog", 3, 1);
    Level livingRoom = new Level("Living Room", null, candle, dog);
    livingRoom.setDescription("You enter the living room in the house and you hear faint music being played in the other room."
        + "\n There is a couch behind you with a candle on a side-table.\n"
        + "Infront of you is a dog, sleeping on the floor."
        + "\n To the right of the room, there is a doorway that leads into a brightly lit room and stairs that lead upto the upstairs of the house.");
    System.out.println(livingRoom.getDescription());
    livingRoom.setChoice1("1: Walk upstairs");
    livingRoom.setChoice2("2: Pick up Candle");
    livingRoom.setChoice3("3: Walk into Dining Room");
    livingRoom.setChoice4("4: Attack Dog");
    livingRoom.setChoice5("5: Go back into hallway");
    System.out.println(livingRoom.getChoice1() + "\n" +livingRoom.getChoice2() + "\n" +livingRoom.getChoice3() 
        + "\n" +livingRoom.getChoice4() + "\n" +  livingRoom.getChoice5());
    String choice = kb.next();
    if(choice.equals("2"))
    {
      System.out.println("You pick up the candle");
      hero.addItem(candle);
      livingRoom.pickUpItem();
      System.out.println(livingRoom.getChoice1() + "\n" +livingRoom.getChoice3() + "\n" +  livingRoom.getChoice4() + livingRoom.getChoice5());
      choice = kb.next();
      pickUp = true;
    }
    if(choice.equals("4")){
      System.out.println("You attack the dog.");
      dog.decreaseHealth(hero.getAttack());
    }
    System.out.println("The dog awakens and starts to attack you");
    while(dog.getHealth()!= 0)
    {
      System.out.println("The dog attacks you for 1 health");
      hero.decreaseHealth(1);
      System.out.println("1: Attack Back");
      choice = kb.next();
      if(choice.equals("1")){
        System.out.println("You attack the dog for " + hero.getAttack());
        dog.decreaseHealth(hero.getAttack());
      }
    }
    System.out.println("You killed the dog");
    System.out.println("Pick a new selection");
    System.out.println(livingRoom.getChoice1());
    if(pickUp == false)
      System.out.println(livingRoom.getChoice2());
    System.out.println(livingRoom.getChoice3()+ "\n" +  livingRoom.getChoice5());
    choice = kb.next();
    if(choice.equals("2") && pickUp == false)
    {
      System.out.println("You pick up the candle");
      hero.addItem(candle);
      livingRoom.pickUpItem();
      System.out.println(livingRoom.getChoice1() + "\n" +livingRoom.getChoice3() + "\n" +  livingRoom.getChoice5());
      choice = kb.next();
    }
    if(choice.equals("1"))
      upstairsH();
    if(choice.equals("3"))
      diningRoom();
    if(choice.equals("5"))
      dHallway();
  }
  
  public static void diningRoom(){
    Item healthPotion = new Item("Health Potion", 1);
    Weapon sword = new Weapon("Sword", 5);
    Level diningRoom = new Level("Dining Room", sword, healthPotion, null);
    diningRoom.setDescription("You enter a room that is lit well by a glass chandlier overtop of a huge wood dining room table with a vile of red liquid.\n "
                              + "Across from the table, on a mantle, is a sword. \n"
                              + "There is a room that leads into a kitchen.");
    diningRoom.setChoice1("1: Take the red vile");
    diningRoom.setChoice2("2. Take the sword");
    diningRoom.setChoice3("3: Enter the kitchen");
    diningRoom.setChoice4("4: Go back into the living room");
    System.out.println(diningRoom.getChoice1() + "\n" +diningRoom.getChoice2() + "\n" +diningRoom.getChoice3() + "\n" +diningRoom.getChoice4());
    String choice = kb.next();
    if(choice.equals("1")){
      System.out.println("You pick up the potion. It restores 3 health.");
      hero.addItem(healthPotion);
      System.out.println("Enter in a new choice");
      choice = kb.next();
    }
    if(choice.equals("2")){
      System.out.println("You pick up the sword. It does 5 attack damage.");
      hero.addItem(sword);
      System.out.println("Enter in a new choice");
      choice = kb.next();
    }
    if(choice.equals("3"))
      kitchen();
    if(choice.equals("4"))
      livingRoom();
  }
  
  public static void kitchen(){
    Item bread = new Item("Bread", 1);
    Weapon knife = new Weapon("Knife", 2);
    Enemy robber1 = new Enemy("Robber", 8, 3);
    Level kitchen = new Level("Kitchen", knife, bread, robber1);
    
    kitchen.setDescription("You creep into the kitchen. There is a man searching through the cabinet, you see on his waist that he is carrying a gun."
        + "\n In the middle of the kitchen, there is a cutting board with a knife laying on top with a loaf of bread next to the cutting board.");
    kitchen.setChoice1("1: Attack the robber");
    kitchen.setChoice2("2. Pick up the knife");
    kitchen.setChoice3("3: Pick up the bread");
    kitchen.setChoice4("4: Go back into the living room");
    System.out.println(kitchen.getChoice1() + "\n" +kitchen.getChoice2() + "\n" +kitchen.getChoice3() + "\n" +kitchen.getChoice4());
    String choice = kb.next();
    if(choice.equals("1")){
      System.out.println("You attack the robber.");
      robber1.decreaseHealth(hero.getAttack());
    }
    if(choice.equals("2")){
      System.out.println("You pick up the knife. It does 2 damage.");
      hero.addItem(knife);
      System.out.println("Enter in a new choice");
      choice = kb.next();
    }
    if(choice.equals("3")){
      System.out.println("You pick up the bread. It restores 2 health.");
      hero.addItem(bread);
      System.out.println("Enter in a new choice");
      choice = kb.next();
    }
    System.out.println("The robber hears you, and start to attack you");
    while(robber1.getHealth()!= 0 && hero.getHealth()!=0)
    {
      System.out.println("The robber attacks you for 3 health");
      hero.decreaseHealth(3);
      System.out.println("1: Attack Back");
      if(hero.containsHealth())
        System.out.println("2: Regenerate Health");
      choice = kb.next();
      if(choice.equals("1")){
        System.out.println("You attack the man for " + hero.getAttack());
        robber1.decreaseHealth(hero.getAttack());
      }
      if(choice.equals("2")){
        System.out.println("You regenerate " + bread.getHealth() + "health");
        hero.increaseHealth(bread.getHealth());
      }
      System.out.println("The robber has died" + "\nPick a new choice");
      
    }
    if(choice.equals("4"))
      livingRoom();
    System.out.println(kitchen.getChoice1() + "\n" +kitchen.getChoice2() + "\n" +kitchen.getChoice3() + "\n" +kitchen.getChoice4());
  }
  
  public static void upstairsH(){
    
  }
  
  public static void main(String[] args) {
    System.out.println("Welcome to a Choose Your Own Adventure Game");
    System.out.println("After every description is given, reply with what you want to do to control the game.\n");
    System.out.println("Enter in the name of your hero: ");
    String name = kb.next();
    hero.setName(name);
    dHallway();
  }
  
}
