package com.nadine.productmanager.enums;

import com.nadine.productmanager.dto.CategoryDTO;
import java.util.ArrayList;
import java.util.List;

public enum ProductCategory {
    FOOD, HOME, GAMES, ELETRONIC, OFFICE;

    public static List<CategoryDTO> forList() {
        List<CategoryDTO> categories = new ArrayList<>();

        for (ProductCategory pc : ProductCategory.values()) {
            categories.add(new CategoryDTO(pc.ordinal(), pc.name()));
        }
        return categories;
    }

    public CategoryDTO categoryDTOConverter() {
        return new CategoryDTO(this.ordinal(), this.name());
    }
}
