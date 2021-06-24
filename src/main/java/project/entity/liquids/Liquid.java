package project.entity.liquids;

public abstract class Liquid {
    private Integer volume;
    private Integer density;

    public Liquid(Integer volume, Integer density) {
        this.volume = volume;
        this.density = density;
    }

    public Integer getVolume() {
        return volume;
    }

    public Integer getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return "Liquid{" +
                "volume=" + volume +
                ", density=" + density +
                '}';
    }
}