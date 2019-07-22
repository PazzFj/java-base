package net.pazz.design.prototype;

public abstract class Shape implements Cloneable {

    private String id;
    protected String type;

    public abstract void draw();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
