package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TitlePojo {
    private String en;
    private String tr;

    public TitlePojo() {
    }

    public TitlePojo(String en, String tr) {
        this.en = en;
        this.tr = tr;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    @Override
    public String toString() {
        return "TitlePojo{" +
                "en='" + en + '\'' +
                ", tr='" + tr + '\'' +
                '}';
    }
}
