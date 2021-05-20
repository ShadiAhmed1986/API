package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoursePojo {
    private TitlePojo title;
    private ShortDescriptionPojo shortDescription;
    private LongDescriptionPojo longDescription;
    private String image;
    private String slug;

    public CoursePojo() {
    }

    public CoursePojo(TitlePojo title, ShortDescriptionPojo shortDescription, LongDescriptionPojo longDescription, String image, String slug) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.image = image;
        this.slug = slug;
    }

    public TitlePojo getTitle() {
        return title;
    }

    public void setTitle(TitlePojo title) {
        this.title = title;
    }

    public ShortDescriptionPojo getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(ShortDescriptionPojo shortDescription) {
        this.shortDescription = shortDescription;
    }

    public LongDescriptionPojo getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(LongDescriptionPojo longDescription) {
        this.longDescription = longDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "CoursePojo{" +
                "title=" + title +
                ", shortDescription=" + shortDescription +
                ", longDescription=" + longDescription +
                ", image='" + image + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }
}
