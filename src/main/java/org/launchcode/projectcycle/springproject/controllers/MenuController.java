package org.launchcode.projectcycle.springproject.controllers;

import org.launchcode.projectcycle.springproject.entity.MenuEntity;
import org.launchcode.projectcycle.springproject.models.Menu;
import org.launchcode.projectcycle.springproject.repository.MenuRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("items")
@Transactional
public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository)
    {
        this.menuRepository = menuRepository;
    }

    @CrossOrigin(origins = {"https://restaurant-menu-ui.herokuapp.com", "http://localhost:3000"})
    @GetMapping("get")
    public List<Menu> getMenu()
    {
        return menuRepository.getMenu().stream().map(this::toMenu).collect(Collectors.toList());
    }

    @CrossOrigin(origins = {"https://restaurant-menu-ui.herokuapp.com", "http://localhost:3000"})
    @PostMapping
    public Menu createMenu(@RequestBody Menu menu)
    {
    System.out.println(menu.getName());
        return toMenu(menuRepository.createMenu(toMenuEntity(menu)));
    }

    @CrossOrigin(origins = {"https://restaurant-menu-ui.herokuapp.com", "http://localhost:3000"})
    @PutMapping("{id}")
    public Menu updateMenu(@PathVariable("id") Long id, @RequestBody Menu menu)
    {
        MenuEntity updatedMenu =
                menuRepository
                        .findById(id)
                        .map(
                                toUpdate ->
                                        toUpdate
                                                .toBuilder()
                        .name(menu.getName())
                        .price(menu.getPrice())
                        .description(menu.getDescription())
                        .pictureUrl(menu.getPictureUrl())
                        .category(menu.getCategory())
                        .type(menu.getType())
                        .spiceLevel(menu.getSpiceLevel())
                        .build())
                        .orElseThrow(() -> new RuntimeException("Menu not found to update"));
        return toMenu(menuRepository.updateMenu(updatedMenu));
    }

    private Menu toMenu(MenuEntity menuEntity)
    {
        return Menu.builder()
                .id(menuEntity.getId())
                .name(menuEntity.getName())
                .description(menuEntity.getDescription())
                .pictureUrl(menuEntity.getPictureUrl())
                .price(menuEntity.getPrice())
                .category(menuEntity.getCategory())
                .type(menuEntity.getType())
                .spiceLevel(menuEntity.getSpiceLevel())
                .build();
    }

    private MenuEntity toMenuEntity(Menu menu)
    {
        return MenuEntity.builder()
                .id(menu.getId())
                .name(menu.getName())
                .description(menu.getDescription())
                .pictureUrl(menu.getPictureUrl())
                .price(menu.getPrice())
                .category(menu.getCategory())
                .type(menu.getType())
                .spiceLevel(menu.getSpiceLevel())
                .build();
    }
}
