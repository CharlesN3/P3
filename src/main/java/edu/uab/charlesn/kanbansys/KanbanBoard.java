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
  ArrayList<KanbanCard> KL = new ArrayList<KanbanCard>();

  private void addCard(KanbanCard card) {

    KB.put(card.getUid(), card);
  }

  private void addAllCards(ArrayList<KanbanCard> Board) { // put into list then pull out here
    int index = 0;

    while (index <= Board.size()) {
      KanbanCard card = Board.get(index);
      String uid = card.getUid();
      KB.put(uid, card);
      KL.add(card);
      index++;
    }
  }

  private List searchState(String stateSearch) {
    ArrayList StateList = new ArrayList();

    int index = 0;
    KanbanCard card = KL.get(index);
    String state = card.getState();

    while (index <= KL.size()) {
      if (state.equalsIgnoreCase(stateSearch) == true) {
        StateList.add(card);
      }
      index++;
    }
    return StateList;
  }
}