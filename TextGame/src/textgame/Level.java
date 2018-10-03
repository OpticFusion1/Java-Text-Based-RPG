/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;

/**
 *
 * @author Zachery Soles
 */
public class Level{
  Object item, weapon, enemy;
  String name, description, choice1, choice2, choice3, choice4, choice5;
  
  public Level(String name, Object weapon, Object item, Object enemy)
  {
    this.name = name;
    this.weapon = weapon;
    this.item = item;
    this.enemy = enemy;
  }
  public void setDescription(String description){
    this.description = description;
  }
  public void setChoice1(String choice1){
    this.choice1 = choice1;
  }
  public void setChoice2(String choice2){
    this.choice2 = choice2;
  }
  public void setChoice3(String choice3){
    this.choice3 = choice3;
  }
  public void setChoice4(String choice4){
    this.choice4 = choice4;
  }
   public void setChoice5(String choice5){
    this.choice5 = choice5;
  }
  public String getChoice5(){
    return choice5;
  }
  public String getChoice1(){
    return choice1;
  }
  public String getChoice2(){
    return choice2;
  }
  public String getChoice3(){
    return choice3;
  }
  public String getChoice4(){
    return choice4;
  }
  public String getName(){
    return name;
  }
  public String getDescription(){
    return description;
  }
  
  public Object getItem(){
    return item;
  }
  public Object getWeapon(){
    return weapon;
  }
  public Object getEnemy(){
    return enemy;
  }
  public void pickUpItem(){
    item = null;
  }
  public void pickUpWeapon(){
    weapon = null;
  }
  public void killEnemy(){
    enemy = null;
  }
}
