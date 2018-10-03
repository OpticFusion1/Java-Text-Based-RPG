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
public class Player 
{
  ArrayList<Object> items = new ArrayList<>();
  String name;
  int health, attack;
  //---Initializes all of the required variables for the player
  public Player(String name, int health, int attack){
    this.name = name;
    this.health = health;
    this.attack = attack;
  }
  //---Input validation to see if the passed int is 0 or not
  public boolean inputValid(int input)
  {
    if(input != 0)
      return true;
    else
    {
      System.out.println("The int you are trying to input is 0");
      return false;
    }
      
  }
  public void setName(String name){
    this.name = name;
  }
  public void addItem(Object item)
  {
    items.add(item);
  }
  public void removeItem(Object item)
  {
    items.remove(item);
  }
  public boolean containsHealth(){
    if(items.contains(health))
      return true;
    return false;
  }
  //--Increases the attack of the player if a weapon is equiped
  public int increaseAttack(int newAttack)
  {
    if(inputValid(newAttack))
      attack = newAttack;
    return attack;
  }
  //---Increases the health of the player if a potion or food is used
  public int increaseHealth(int itemHealth)
  {
    if(inputValid(itemHealth))
      health += itemHealth;
    return health;
  }
  //---Decreases the health of the player is damage from an enemy is taken
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
