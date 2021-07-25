package it.uniroma3.galleria.model;

import javax.persistence.*;


@Entity
public class Image {
    @Id
    private Long imageID;
    private byte[] image;

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


}
