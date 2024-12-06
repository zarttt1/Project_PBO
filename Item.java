/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekpbov2;

/**
 *
 * @author ACER
 */
public abstract class Item {
    private String name;
    private int pointValue;

    public Item(String name, int pointValue) {
        this.name = name;
        this.pointValue = pointValue;
    }

    public String getName() {
        return name;
    }

    public int getPointValue() {
        return pointValue;
    }
}
