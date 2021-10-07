/*
 * Author: Charle Newfield <Charlesn@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.charlesn.kanbansys;

/** */
public class DateField extends Field {
  KanbanDate kd;

  public DateField(String name, Object value) {
    super(name, "string");
    this.kd = (KanbanDate) value;
  }

  @Override
  public Field newField(Object object) {
    return new DateField(super.getName(), object);
  }

  public KanbanDate get() {
    return kd;
  }

  public String toString() {
    return kd.toString();
  }

  public String getTaggedString() {
    return name + ": " + kd.toString();
  }
}