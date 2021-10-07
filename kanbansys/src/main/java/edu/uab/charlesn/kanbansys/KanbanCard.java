/*
 * Author: Charles Newfield <Charlesn@uab.edu>
 * Assignment:  ee333fallp1 - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.charlesn.kanbansys;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/** Model a Kanban Card */
public class KanbanCard {
  private String name;
  private String uid;
  private String state;
  private String createDate;
  private String beginDate;
  private String endDate;
  private String notes;
  private static long count = 1000000000;
  private boolean checkState;
  private List<Field> fields = new ArrayList(); // Implementation of an array list

  HashMap<String, String> Board = new HashMap<>();
  /**
   * Create a Kanban card with a unique uid, and Initialize other fields appropriately
   *
   * @param name the name of the card
   */
  public KanbanCard(String name) {
    this.name = name;
    this.uid = "" + count++;
    state = "BACKLOG";
    createDate = Calendar.getDate();
    beginDate = "TBD";
    endDate = "TBD";
    notes = " ";
  }
  /**
   * get the UID of the card
   *
   * @return long number corresponding to uid of card
   */
  public String getUid() {
    return uid;
  }
  /**
   * get the name of the task
   *
   * @return String representing name of task
   */
  public String getName() {
    return name;
  }
  /**
   * Is this task done?
   *
   * @return true if task has been completed
   */
  public boolean isDone() {
    checkState = state.equals("DONE");
    return checkState;
  }
  /**
   * Is this task active?
   *
   * @return true if not in backlog, not done or not abandoned
   */
  public boolean isActive() {
    checkState =
        state.equals("DESIGN")
            || state.equals("BUILD")
            || state.equals("TEST")
            || state.equals("RELEASE");
    return checkState;
  }
  /**
   * Is this task abandoned?
   *
   * @return true if task has been abandoned
   */
  public boolean isAbandoned() {
    checkState = state.equals("ABANDONED");
    return checkState;
  }
  /**
   * Create a string representation of the Kanban card
   *
   * <p>Format:
   *
   * <p><code>
   * uid: Name of task Task State
   * state - Create: date (or tbd) Begin: date (or tbd) Completed: date (or TBD)
   * (notes would go here if any)
   * </code>
   *
   * <p>Example:
   *
   * <p><code>
   * 100000000: Demo task Backlog
   * BACKLOG - Create: 20210815 Begin: TBD Completed: TBD
   * </code>
   *
   * @return formatted string
   */
  @Override
  public String toString() {
    return (uid
        + ": "
        + name
        + "\t"
        + state
        + "\n"
        + state
        + " - "
        + "\tCreate: "
        + createDate
        + "\tBegin: "
        + beginDate
        + "\tCompleted: "
        + endDate
        + "\n"
        + notes);
  }
  /** @param newName the new task name */
  public void updateName(String newName) {
    name = newName;
  }
  /**
   * Mark the task as in design if it is in the backlog (no action otherwise) and capture note if
   * non-null
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void start(String note) {
    if (beginDate.equals("TBD") == true) {
      beginDate = Calendar.getDate();
    }
    if (state.equals("BACKLOG")) {
      state = "DESIGN";
      notes += note + "\n";
    }
  }
  /**
   * Mark and timestamp (if beginDate null) the task as in build if it was in design (no action
   * otherwise) and capture note if non-null
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void build(String note) {
    if (state.equals("DESIGN")) {
      state = "BUILD";
      notes += note + "\n";
    }
  }
  /**
   * Mark the task as in test if it was in build (no action otherwise) and capture note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void test(String note) {
    if (state.equals("BUILD")) {
      state = "TEST";
      notes += note + "\n";
    }
  }
  /**
   * Mark the task as ready to release if it was in test (no action otherwise) and capture note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void release(String note) {
    if (state.equals("TEST")) {
      state = "RELEASE";
      notes += note + "\n";
    }
  }
  /**
   * Mark and timestamp the task as complete if it was in release (no action otherwise) and capture
   * note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void complete(String note) {
    if (state.equals("RELEASE")) {
      state = "DONE";
      notes += note + "\n";
    }
  }
  /**
   * Mark the task as abandoned unless it was completed (no action otherwise) and capture note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void abandon(String note) {
    if (!state.equals("DONE")) {
      state = "ABANDONED";
      notes += note + "\n";
    }
  }
  /**
   * Modify the state of the task and capture the note, update the date fields based on present new
   * state
   *
   * @param state the new KCardState for the task
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void move(String state, String note) {
    this.state = state;
    if (note != null) {
      notes += note + "\n";
    } else {
      beginDate = createDate;
      endDate = createDate;
    }
  }

  private void nextStateIfValid(String before, String after, String note) {
    if (state.equals(before)) {
      state = after;
      if (note != null) {
        notes += note + "\n";
      }
    }
  }

  public Field getField(String name) {
    for (Field field : fields) {
      if (field.getName().equals(name)) {
        return field;
      }
    }
    // System.out.println("Field with name does not exist");
    return null;
  }

  public String[] getFieldNames() {
    String[] nameArray = new String[fields.size()];
    for (int i = 0; i < fields.size(); i++) {
      nameArray[i] = (fields.get(i).getName());
    }
    return nameArray;
  }

  public void add(Field field) {
    if (field == null || null != getField(field.getName())) {
      System.out.println("Field already exists.");
    } else {
      fields.add(field);
    }
  }

  public void set(Field field) {
    boolean found = false;
    for (int i = 0; i < fields.size(); i++) {
      if (fields.get(i).getName().equals(field.getName())) {
        found = true;
        fields.set(i, field);
        return;
      }
    }
    System.out.println("Item does not exist");
    throw new RuntimeException("Field does not exist");
  }
}
