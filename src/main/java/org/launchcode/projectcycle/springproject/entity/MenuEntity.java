package org.launchcode.projectcycle.springproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "menu")
@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String description;
    private Float price;
    private String pictureUrl;
    private String category;
    private String type;
    private String spiceLevel;
}