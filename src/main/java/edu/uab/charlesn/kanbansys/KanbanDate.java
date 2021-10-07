/*
 * Author: Charle Newfield <Charlesn@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.charlesn.kanbansys;

/**
 *
 */
public class KanbanDate implements Comparable {

	private String date;

	public KanbanDate() {
		this("TBD");
	}

	public KanbanDate(String date) {
		this.date = date;
	}

	public KanbanDate(KanbanDate kanban) {
    this(kanban.toString());
	}


	public String getDate() {
		return date;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof KanbanDate)) {
			return false;
		}
		KanbanDate kd = (KanbanDate) obj;
		return getDate().equals(kd.getDate());
	}

	@Override
	public String toString() {
		return date;
	}

	@Override
	public int compareTo(Object obj) {
		String z;
		z = obj.toString();
		return date.compareTo(z);
	}

}

