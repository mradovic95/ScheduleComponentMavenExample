package model;

/**
 * Represents work activity(for example finish project)
 *
 * @author comex
 */

public class WorkEvent extends Event {

    private CheckList checkList;
    private Priority priority = Priority.MEDIUM;

    public WorkEvent() {

    }

    public WorkEvent(CheckList checkList, Priority priority) {
        super();
        this.checkList = checkList;
        this.priority = priority;
    }

    public CheckList getCheckList() {
        return checkList;
    }

    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }


}
