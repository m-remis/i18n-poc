package com.michal.examples.i18n.service;

import com.michal.examples.i18n.dto.LanguageResourceDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.michal.examples.i18n.repository.I18NMessagesRepository;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class LanguageService {

    private final I18NMessagesRepository repository;

    public LanguageService(I18NMessagesRepository repository) {
        this.repository = repository;
    }

    public List<LanguageResourceDto> getAll(String customerId) {
        return ConvertService.transformToList(repository.findI18NMessagesWithOverrides(customerId));
    }

    public List<LanguageResourceDto> getAllForModule(String module,
                                                     String customerId) {
        var resources = repository.findI18NMessagesForCustomerAndModuleWithOverrides(
                customerId,
                module
        );
        return ConvertService.transformToList(resources);
    }

    public List<LanguageResourceDto> getAllForModuleAndLanguage(String module,
                                                          String languageCode,
                                                          String customerId) {
        var resources = repository.findI18NMessagesForCustomerAndModuleAndLanguageCodeWithOverrides(
                customerId,
                module,
                languageCode
        );
        return ConvertService.transformToList(resources);
    }

    public List<LanguageResourceDto> getAllForLanguage(String customerId,
                                                       String language) {
        var resources = repository.findI18NMessagesForCustomerAndLanguageCodeWithOverrides(
                customerId,
                language
        );
        return ConvertService.transformToList(resources);
    }
}