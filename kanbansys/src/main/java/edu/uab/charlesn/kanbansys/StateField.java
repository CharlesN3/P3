/*
 * Author: Charle Newfield <Charlesn@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.charlesn.kanbansys;

/** */
public class StateField extends Field {

  private String[] states;

  public StateField(String name, String[] list, String state) {
    super(name, "state");
    boolean found = false;
    for (String item : list) {
      if (item.equals(state)) {
        found = true;
        break;
      }
    }

    this.states = list;
  }

  @Override
  public Field newField(Object object) {
    return new StateField(getName(), this.states, get().toString());
  }

  public String toString() {
    return states.toString();
  }

  public String get() {
    return states.toString();
  }

  public String getTaggedString() {
    return name + ": " + states.toString();
  }
}
