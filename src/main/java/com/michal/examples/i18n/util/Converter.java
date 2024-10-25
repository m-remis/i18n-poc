package com.michal.examples.i18n.util;


import com.michal.examples.i18n.dto.LanguageResourceDto;
import com.michal.examples.i18n.entity.I18NMessageEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Michal Remis
 */
public class Converter {

    private Converter() {
    }

    public static List<LanguageResourceDto> transformToList(List<I18NMessageEntity> entities) {
        Map<String, LanguageResourceDto> resources = new HashMap<>();
        for (I18NMessageEntity entity : entities) {
            String key = entity.getLocale() + "." + entity.getModule();
            LanguageResourceDto r = resources.computeIfAbsent(key, k -> new LanguageResourceDto(entity.getLocale(), entity.getModule(), new HashMap<>()));
            r.messages().put(entity.getKey(), entity.getMessage());
        }
        return List.copyOf(resources.values());
    }
}
