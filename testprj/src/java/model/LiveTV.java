/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
public class LiveTV {
      int id;
    String title;
    String image;
    String des;
    String link;

    public LiveTV() {
    }

    public LiveTV(int id, String title, String image, String des, String link) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.des = des;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "LiveTV{" + "id=" + id + ", title=" + title + ", image=" + image + ", des=" + des + ", link=" + link + '}';
    }

    
    
    
}
