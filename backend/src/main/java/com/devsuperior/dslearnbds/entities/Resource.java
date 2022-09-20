package com.devsuperior.dslearnbds.entities;

import com.devsuperior.dslearnbds.entities.enums.ResourceType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private String img_Uri;
    private String description;
    private Integer position;

    private ResourceType type;

    @OneToMany(mappedBy = "resource")
    private List<Section> sections = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public Resource() {
    }

    public Resource(Long id, String title, String img_Uri, String description, Integer position, ResourceType type, List<Section> sections, Offer offer) {
        this.id = id;
        this.title = title;
        this.img_Uri = img_Uri;
        this.description = description;
        this.position = position;
        this.type = type;
        this.sections = sections;
        this.offer = offer;
    }

    public List<Section> getSections() {
        return sections;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_Uri() {
        return img_Uri;
    }

    public void setImg_Uri(String img_Uri) {
        this.img_Uri = img_Uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return id.equals(resource.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
