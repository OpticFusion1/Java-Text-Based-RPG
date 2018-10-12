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
  static String name;
  //Checks the input and makes sure that is a valid input
  public static int inputValid(int input, Level room){
    if(!(input > 0 && input <= room.getNumChoices()))
    {
      System.out.println("The choice you inserted was not correct. "
          + "\nEnter in a new choice.");
      room.getChoices();
      int newInput = kb.nextInt();
      return inputValid(newInput, room);
    }
    return input;
  }
  //Method for the hallway level
  public static void dHallway(){
    Level dHallway = new Level("Downstairs Hallway", null, null, null);
    dHallway.setDescription("You are a detective, that is investigating a "
        + "house alarm.\n");
    dHallway.getDescription();
    dHallway.addChoice("Walk down hallway");
    dHallway.getChoices();
    int choice = kb.nextInt();
    choice = inputValid(choice, dHallway);
    if(choice == 1)
      livingRoom();
  }
  //method for living room
  public static void livingRoom(){
    Item candle = new Item("Candle", 1);
    Enemy dog = new Enemy("Dog", 3, 1);
    Level livingRoom = new Level("Living Room", null, candle, dog);
    
    livingRoom.setDescription("\nYou enter the living room in the house and "
        + "you hear faint music being played in the other room."
        + "\nThere is a couch behind you with a candle on a side-table.\n"
        + "Infront of you is a dog, sleeping on the floor."
        + "\nTo the right of the room, there is a doorway that leads into a "
        + "brightly lit room and stairs that lead upto the upstairs "
        + "of the house.\n");
    livingRoom.addChoice("Pick up Candle");
    livingRoom.addChoice("Walk into Dining Room");
    livingRoom.addChoice("Attack Dog");
    livingRoom.addChoice("Go back into hallway");
    
    livingRoom.getDescription();
    livingRoom.getChoices();
    
    int choice = kb.nextInt();
    choice = inputValid(choice, livingRoom);
    //if choice is one, adds candle to hero
    if(choice == 1)
    {
      System.out.println("You pick up the candle");
      hero.addItem(candle);
      livingRoom.pickUpItem();
      System.out.println("Pick a new choice");
      livingRoom.removeChoice(choice);
      livingRoom.getChoices();
      choice = kb.nextInt();
      pickUp = true;
    }
    //if choice == 3, you attack the dog
    if(choice == 3){
      System.out.println("You attack the dog.");
      dog.decreaseHealth(hero.getAttack());
    }
    System.out.println("The dog awakens and starts to attack you");
    //Loop of enemy attacking the player
    while(dog.getHealth()!= 0)
    {
      System.out.println("The dog attacks you for 1 health");
      hero.decreaseHealth(1);
      livingRoom.clearChoices();
      livingRoom.addChoice("Attack Back");
      livingRoom.getChoices();
      choice = kb.nextInt();
      choice = inputValid(choice, livingRoom);
      if(choice == 1){
        System.out.println("You attack the dog for " + hero.getAttack());
        dog.decreaseHealth(hero.getAttack());
      }
    }
    System.out.println("You killed the dog");
    livingRoom.clearChoices();
    System.out.println("\nPick a new selection");
    if(pickUp == false)
      livingRoom.addChoice("Pick up Candle");
    livingRoom.addChoice("Walk into Dining Room");
    livingRoom.addChoice("Go back into hallway");
    
    livingRoom.getChoices();
    choice = kb.nextInt();
    choice = inputValid(choice, livingRoom);
    //if choice = 1, then adds candle to hero
    if(choice == 1 && pickUp == false)
    {
      System.out.println("You pick up the candle");
      hero.addItem(candle);
      livingRoom.pickUpItem();
      System.out.println("Select a new choice");
      livingRoom.removeChoice(choice);
      livingRoom.getChoices();
      choice = kb.nextInt();
      choice = inputValid(choice, livingRoom);
      pickUp = true;
    }
    //goes to a certain room depending on input
    if((choice == 1 && pickUp)|| choice == 3)
      diningRoom();
    if((choice == 2 && pickUp)|| choice == 4)
      dHallway();
  }
  //Method for dining room
  public static void diningRoom(){
    Item healthPotion = new Item("Health Potion", 1);
    Weapon sword = new Weapon("Sword", 5);
    boolean pickUp1 = false;
    boolean pickUp2 = false;
    Level diningRoom = new Level("Dining Room", sword, healthPotion, null);
    diningRoom.setDescription("\nYou enter a room that is lit well by a glass"
        + "chandlier overtop of a huge wood "
        + "dining room table with a vile of red liquid.\n"
        + "Across from the table, on a mantle, is a sword.\n"
        + "There is a room that leads into a kitchen.\n");
    diningRoom.addChoice("Take the red vile");
    diningRoom.addChoice("Take the sword");
    diningRoom.addChoice("Enter the kitchen");
    diningRoom.addChoice("Go back into the living room");
   
    diningRoom.getDescription();
    diningRoom.getChoices();
    int choice = kb.nextInt();
    choice = inputValid(choice, diningRoom);
    //if choice == 1, then adds potion to hero
    if(choice == 1){
      System.out.println("You pick up the potion. It restores 3 health.");
      hero.addItem(healthPotion);
      diningRoom.removeChoice(choice);
      diningRoom.getChoices();
      System.out.println("Enter in a new choice");
      choice = kb.nextInt();
      choice = inputValid(choice, diningRoom);
      pickUp1 = true;
    }
    //if choice == 2 or 1 depeding on potion is picked up
    //adds sword to hero
    if(choice == 2 || (choice == 1 && pickUp1 == true)){
      System.out.println("You pick up the sword. It does 5 attack damage.");
      hero.setAttack(sword.getDamage());
      diningRoom.removeChoice(choice);
      diningRoom.getChoices();
      System.out.println("Enter in a new choice");
      choice = kb.nextInt();
      choice = inputValid(choice, diningRoom);
      pickUp2 = true;
    }
    //goes to a certain room depending on the input and if the other items were
    //picked up in the room
    if(choice == 3 || (choice == 2 && pickUp1) || (choice == 1 && pickUp1 && pickUp2))
      kitchen();
    if(choice == 4 || (choice == 3 && pickUp1) || (choice == 2 && pickUp1 && pickUp2))
      livingRoom();
  }
  //method for kitchen
  public static void kitchen(){
    Item bread = new Item("Bread", 1);
    Weapon knife = new Weapon("Knife", 2);
    Enemy robber1 = new Enemy("Robber", 8, 3);
    Level kitchen = new Level("Kitchen", knife, bread, robber1);
    boolean pickUp1 = false;
    boolean pickUp2 = false;
    kitchen.setDescription("You creep into the kitchen. There is a man "
        + "searching through the cabinet, you see on his waist that he is "
        + "carrying a gun."
        + "\n In the middle of the kitchen, there is a cutting board with a "
        + "knife laying on top with a loaf of bread next to the "
        + "cutting board.\n");
    kitchen.addChoice("Attack the robber");
    kitchen.addChoice("Pick up the knife");
    kitchen.addChoice("Pick up the bread");
    kitchen.addChoice("Go back into the living room");
    
    kitchen.getDescription();
    kitchen.getChoices();
    int choice = kb.nextInt();
    choice = inputValid(choice, kitchen);
    //if choice == 2 or 1 if bread was picked up, then adds knife to player
    if(choice == 2 || (choice == 1 && pickUp2)){
      System.out.println("You pick up the knife. It does 2 damage.");
      hero.setAttack(knife.getDamage());
      kitchen.removeChoice(choice);
      System.out.println("Enter in a new choice");
      kitchen.getChoices();
      choice = kb.nextInt();
      choice = inputValid(choice, kitchen);
      pickUp1 = true;
    }
    //if choice == 3 or 2 if knife was picked up, then adds bread to player
    if(choice == 3 || (choice == 2 && pickUp1)){
      System.out.println("You pick up the bread. It restores 2 health.");
      hero.addItem(bread);
      System.out.println("Enter in a new choice");
      kitchen.getChoices();
      choice = kb.nextInt();
      choice = inputValid(choice, kitchen);
      pickUp2 = true;
    }
    if(choice == 1){
      System.out.println("You attack the robber.");
      robber1.decreaseHealth(hero.getAttack());
      kitchen.removeChoice(choice);
    }
    //robber starts loop to attack player
    System.out.println("The robber hears you, and start to attack you");
    while(robber1.getHealth()!= 0)
    {
      System.out.println("The robber attacks you for 3 health");
      hero.decreaseHealth(3);
      kitchen.clearChoices();
      kitchen.addChoice("Attack Back");
      if(hero.containsHealth())
        kitchen.addChoice("Regenerate Health");
      kitchen.getChoices();
      choice = kb.nextInt();
      choice = inputValid(choice, kitchen);
      if(choice == 1){
        System.out.println("You attack the man for " + hero.getAttack());
        robber1.decreaseHealth(hero.getAttack());
      }
      if(choice == 2 && hero.containsHealth()){
        System.out.println("You regenerate " + bread.getHealth() + "health");
        hero.increaseHealth(bread.getHealth());
      }
      //completes the game if the robber was killed
      System.out.println("The robber has died. Congratulatoins,"+ name + " You have beat the game.");
      System.exit(0);
    }
  }
  public static void main(String[] args) {
    System.out.println("Welcome to a Choose Your Own Adventure Game");
    System.out.println("After every description is given, reply with "
        + "what you want to do to control the game.\n");
    System.out.println("Enter in the name of your hero: ");
    name = kb.next();
    hero.setName(name);
    dHallway();
  }
  
}
