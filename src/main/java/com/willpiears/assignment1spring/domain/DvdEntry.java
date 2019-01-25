package com.willpiears.assignment1spring.domain;

import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "dvds")
public class DvdEntry
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    public DvdEntry()
    {
    }

    public DvdEntry(String title, String description)
    {
    }

    public DvdEntry(Integer id, String title, String description)
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


    @Override
    public String toString () {
        return "DvdEntry{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
