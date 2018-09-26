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

  /**
   * @param args the command line arguments
   */
  static String choice1, choice2, choice3;
  static Scanner kb = new Scanner(System.in);
  //start

  /**
   *
   * @return
   */
  public static String start() {
    System.out.println("Welcome to a Java: Text Based Game");
    System.out.println("Please enter in the name of your adventurer.");
    String name = kb.nextLine();
    return name;
  }
  
  public static int choice(String choice1, String choice2, String choice3, String x)
  {
    int y = 0;
    if(x.contains(choice1))
      y = 1;
    if(x.contains(choice2))
      y = 2;
    if(x.contains(choice3))
      y = 3;
    System.out.println("You chose: " + x);
    return y;
  }
  
  public static void main(String[] args) {
    String name = start();
    choice1 = "As you approach a mysterious castle, a bunny runs into the forest to your left. ";
    choice2 = "Infront of you lies a dilapidated castle, with a cracked open door with a light inside.";
    choice3 = "Behind the castle you see an object sticking out of the ground with the light reflecting off of it.";
    System.out.println(choice1 + "\n" + choice2 + "\n" + choice3);
    String x = kb.nextLine();
    int y = choice(choice1, choice2, choice3, x);
  }
  
}
