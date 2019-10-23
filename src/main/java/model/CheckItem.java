package model;


/**
 * @author comex
 */


public class CheckItem {


    private String name;

    private boolean value;

    public CheckItem() {

    }

    public CheckItem(String name, boolean value) {
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

}
