/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marbles.model;

import java.math.BigDecimal;

/**
 *
 * @author Hp
 */
public class Marble {

    private MarbleColor color;
    private String name;
    private BigDecimal weight;

    public enum MarbleColor {
        red, orange, yellow, green, blue, indigo, violet;
    }

    public Marble(MarbleColor color, String name, BigDecimal weight) {
        this.color = color;
        this.name = name;
        this.weight = weight;
    }

    public MarbleColor getColor() {
        return color;
    }

    public void setColor(MarbleColor color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Name:" + getName() + " Color:" + getColor() + " Weight:" + getWeight();
    }

}
