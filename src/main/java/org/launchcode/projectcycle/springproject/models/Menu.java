package org.launchcode.projectcycle.springproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Menu
{
    private Long id;

    private String name;

    private String description;

    private Float price;

    private String pictureUrl;

    private String category;

    private String type;

    private String spiceLevel;
}

