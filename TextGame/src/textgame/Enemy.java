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
public class Enemy {
  ArrayList<Object> items = new ArrayList<>();
  String name;
  int health, attack;
  
  public Enemy(String name, int health, int attack){
    this.name = name;
    this.health = health;
    this.attack = attack;
  }
  //input validation
  public boolean inputValid(int input){
    if(input != 0)
      return true;
    else{
      System.out.println("The int you are trying to input is 0");
      return false;
    }
  }
  //decreases health of enemy
  public int decreaseHealth(int attackDamage)
  {
    if(inputValid(attackDamage))
      health -= attackDamage;
    return health;
  }
  //---Returns the name of the player
  public String getName()
  {
    return name;
  }
  //---Returns the health of the player
  public int getHealth()
  {
    return health;
  }
  //---Returns the attack damage of the player
  public int getAttack()
  {
    return attack;
  }
}
