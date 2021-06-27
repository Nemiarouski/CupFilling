package project.entity.liquids;

import java.io.Serializable;

public class Liquid implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer volume;
    private Integer density;

    public Liquid() {
    }
    public Liquid(Integer volume, Integer density) {
        this.volume = volume;
        this.density = density;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getDensity() {
        return density;
    }

    public void setDensity(Integer density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return "[Liquid]:" +
                " [Volume]: " + volume +
                " cm\u00B3 [Density]: " + density + " кг/m\u00B3";
    }
}