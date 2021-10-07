/*
 * Author: Charle Newfield <Charlesn@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.charlesn.kanbansys;

/** */
public class StringField extends Field {

  Object value;

  public StringField(String name, Object value) {
    super(name, "string");
    this.value = value;
  }

  @Override
  public Field newField(Object object) {
    return new StringField(super.getName(), object);
  }

  public String get() {
    return value.toString();
  }

  public String toString() {
    return value.toString();
  }

  public String getTaggedString() {
    return name + ": " + value.toString();
  }
}