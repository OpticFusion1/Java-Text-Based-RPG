/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

import java.util.ArrayList;

/**
 *
 * @author Zachery Soles
 */
public class Level{
  Object item, weapon, enemy;
  String name, description;
  ArrayList choices = new ArrayList<>();
  
  public Level(String name, Object weapon, Object item, Object enemy)
  {
    this.name = name;
    this.weapon = weapon;
    this.item = item;
    this.enemy = enemy;
  }
  //sets descrition for level
  public void setDescription(String description){
    this.description = description;
  }
  //adds choices to arraylist for the level
  public void addChoice(String choice){
    choices.add(choice);
  }
  //clears all the choices
  public void clearChoices(){
    choices.clear();
  }
  //prints the choices
  public void getChoices(){
    System.out.println(choices);
  }
  //return the number of choices
  public int getNumChoices(){
    return choices.size();
  }
  //return the name of the level
  public String getName(){
    return name;
  }
  //prints the description of the level
  public void getDescription(){
    System.out.println(description);
  }
  //removes a given choice from the array list
  public void removeChoice(int choice){
    choices.remove(choice-1);
  }
  //return the item in the level
  public Object getItem(){
    return item;
  }
  //returns the weapon in the level
  public Object getWeapon(){
    return weapon;
  }
  //returns the enemy in the level
  public Object getEnemy(){
    return enemy;
  }
  //picks up item
  public void pickUpItem(){
    item = null;
  }
  //picks up weaoon
  public void pickUpWeapon(){
    weapon = null;
  }
  //kills enemy
  public void killEnemy(){
    enemy = null;
  }
}
