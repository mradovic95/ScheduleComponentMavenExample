package model;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents the list of tasks for WorkEvent
 *
 * @author comex
 */


public class CheckList {

    private String title;
    private String description;
    private List<CheckItem> items = new ArrayList<CheckItem>();

    public CheckList() {

    }

    public CheckList(String title, String description, List<CheckItem> items) {
        super();
        this.title = title;
        this.description = description;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CheckItem> getItems() {
        return items;
    }

    public void setItems(List<CheckItem> items) {
        this.items = items;
    }

}
