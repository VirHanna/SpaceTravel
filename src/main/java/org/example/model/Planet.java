package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "planets")
@Getter
@Setter
@NoArgsConstructor
public class Planet {

    @Id
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String id;
    @Column(length = 500, nullable = false)
    @Size(min = 1, max = 500)
    @NotNull
    private String name;

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
