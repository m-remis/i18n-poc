package com.michal.examples.i18n.dto;

import java.util.Map;

/**
 * @author Michal Remis
 */
public record LanguageResourceDto(String locale, String module, Map<String, String> messages) {
}
