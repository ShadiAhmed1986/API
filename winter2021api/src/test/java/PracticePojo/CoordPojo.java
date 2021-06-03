package PracticePojo;

public class CoordPojo {
    private Double lon;
    private Double lat;

    public CoordPojo() {
    }

    public CoordPojo(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "CoordPojo{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
