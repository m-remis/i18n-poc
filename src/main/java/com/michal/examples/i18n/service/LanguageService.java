package com.michal.examples.i18n.service;

import com.michal.examples.i18n.dto.LanguageResourceDto;
import com.michal.examples.i18n.util.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.michal.examples.i18n.repository.I18NMessagesRepository;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class LanguageService {

    private final I18NMessagesRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageService.class);

    public LanguageService(I18NMessagesRepository repository) {
        this.repository = repository;
    }

    public List<LanguageResourceDto> getAll(String customerId) {
        if (LOGGER.isDebugEnabled()) logIfOverrides(customerId);
        return Converter.transformToList(repository.findI18NMessagesWithOverrides(customerId));
    }

    public List<LanguageResourceDto> getAllForModule(String module,
                                                     String customerId) {
        if (LOGGER.isDebugEnabled()) logIfOverrides(customerId);
        var resources = repository.findI18NMessagesForCustomerAndModuleWithOverrides(
                customerId,
                module
        );
        return Converter.transformToList(resources);
    }

    public List<LanguageResourceDto> getAllForModuleAndLanguage(String module,
                                                                String languageCode,
                                                                String customerId) {
        if (LOGGER.isDebugEnabled()) logIfOverrides(customerId);
        var resources = repository.findI18NMessagesForCustomerAndModuleAndLanguageCodeWithOverrides(
                customerId,
                module,
                languageCode
        );
        return Converter.transformToList(resources);
    }

    public List<LanguageResourceDto> getAllForLanguage(String customerId,
                                                       String language) {
        if (LOGGER.isDebugEnabled()) logIfOverrides(customerId);
        var resources = repository.findI18NMessagesForCustomerAndLanguageCodeWithOverrides(
                customerId,
                language
        );
        return Converter.transformToList(resources);
    }

    private void logIfOverrides(String customerId) {
        Optional.ofNullable(customerId).ifPresentOrElse(
                id -> LOGGER.debug("Searching resources with overrides for customer with id [{}]", id),
                () -> LOGGER.debug("Searching default resources")
        );
    }
}