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
public class Item {
  String name;
  int health;
  public Item(String name, int health)
  {
    this.name = name;
    this.health = health;
  }
  //gets name of item
  public String getName()
  {
    return name;
  }
  //gets the health property of the item
  public int getHealth()
  {
    return health;
  }
}
