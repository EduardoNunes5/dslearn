package com.devsuperior.dslearnbds.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private String img_Uri;
    private String description;
    private Integer position;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
    @ManyToOne
    @JoinColumn(name = "prerequisite_id")
    private Section prerequisite;

    public Section() {
    }

    public Section(Long id, String title, String img_Uri, String description, Integer position, Resource resource, Section prerequisite) {
        this.id = id;
        this.title = title;
        this.img_Uri = img_Uri;
        this.description = description;
        this.position = position;
        this.resource = resource;
        this.prerequisite = prerequisite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg_Uri() {
        return img_Uri;
    }

    public void setImg_Uri(String img_Uri) {
        this.img_Uri = img_Uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Section getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Section prerequisite) {
        this.prerequisite = prerequisite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return id.equals(section.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
