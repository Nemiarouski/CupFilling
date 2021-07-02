package project.entity.liquids;

public class Liquid {
    private Integer volume;
    private Integer density;
    private String type;

    public Liquid() {
    }
    public Liquid(Integer volume, LiquidType liquidType) {
        this.volume = volume;
        this.density = liquidType.getDensity();
        this.type = liquidType.getType();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" + type + "]:" +
                " [Volume]: " + volume +
                " cm\u00B3 [Density]: " + density + " кг/m\u00B3";
    }
}