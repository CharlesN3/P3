/*
 * Author: Charle Newfield <Charlesn@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.charlesn.kanbansys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** */
public class KanbanBoard {

  Map<String, KanbanCard> KB = new HashMap<>();

  private void addCard(KanbanCard card) {

    KB.put(card.getUid(), card);
  }

  private void addAllCards(ArrayList<KanbanCard> Board) { // put into list then pull out here
    int index = 0;

    while (index <= Board.size()) {
      KanbanCard card = Board.get(index);
      String uid = card.getUid();
      KB.put(uid, card);
      index++;
    }
  }

  private List searchState() {
    ArrayList StateList = new ArrayList();

    return StateList;
  }
}