/*
 * Author: Charle Newfield <Charlesn@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.charlesn.kanbansys;

/** */
public abstract class Field implements Comparable { // SuperClass

  protected String name;
  protected String type;

  public Field(String name, String type) {
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public boolean isName(String name) {
    if (name == null) {
      return false;
    }
    return this.name.equals(name);
  }

  public abstract Field newField(Object object);

  public abstract Object get();

  public abstract String getTaggedString();

  public String getType() {
    return type;
  }

  @Override
  public int compareTo(Object obj) {
    Field f = (Field) obj;
    return getName().compareTo(f.getName());
  }
}
