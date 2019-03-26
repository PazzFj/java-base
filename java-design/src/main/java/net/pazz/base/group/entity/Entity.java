package net.pazz.base.group.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Peng Jian
 * @date: 2018/6/6 14:08
 * @description:
 */
public class Entity {

    private int id;
    private String attributeA;
    private String attributeB;
    private String attributeC;
    private int count;

    private List<Entity> entities = new ArrayList<>();

    public Entity() {
    }

    public Entity(int id, String attributeA, String attributeB, String attributeC, int count) {
        this.id = id;
        this.attributeA = attributeA;
        this.attributeB = attributeB;
        this.attributeC = attributeC;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttributeA() {
        return attributeA;
    }

    public void setAttributeA(String attributeA) {
        this.attributeA = attributeA;
    }

    public String getAttributeB() {
        return attributeB;
    }

    public void setAttributeB(String attributeB) {
        this.attributeB = attributeB;
    }

    public String getAttributeC() {
        return attributeC;
    }

    public void setAttributeC(String attributeC) {
        this.attributeC = attributeC;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", attributeA='" + attributeA + '\'' +
                ", attributeB='" + attributeB + '\'' +
                ", attributeC='" + attributeC + '\'' +
                ", count=" + count +
                '}';
    }
}
