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
public class Weapon {
  String name;
  int damage;
  //---Constructor for weapons
  public Weapon(String name,int damage)
  {
    this.name = name;
    this.damage = damage;
  }
  //---Returns the name of the weapon
  public String getName()
  {
    return name;
  }
  //---Returns the amount of damage of the weapon
  public int getDamage()
  {
    return damage;
  }
}
