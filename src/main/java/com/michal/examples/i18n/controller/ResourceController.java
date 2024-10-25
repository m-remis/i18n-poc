package com.michal.examples.i18n.controller;

import com.michal.examples.i18n.dto.LanguageResourceDto;
import com.michal.examples.i18n.service.LanguageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Michal Remis
 */
@RestController
@Tag(name = "Resource")
@RequestMapping(ResourceController.CONTROLLER_PREFIX)
public class ResourceController {

    public static final String CONTROLLER_PREFIX = "/resources";

    public static final String I18N_MESSAGES_FOR_MODULE_AND_LANGUAGE = "/i18n/module/{module}/language/{language}";
    public static final String I18N_MESSAGES_FOR_LANGUAGE = "/i18n/language/{language}";
    public static final String I18N_MESSAGES_FOR_MODULE = "/i18n/module/{module}";
    public static final String I18N_MESSAGES = "/i18n";

    private final LanguageService languageService;

    public ResourceController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping(I18N_MESSAGES)
    @Operation(summary = "Returns list of all available resources")
    public ResponseEntity<List<LanguageResourceDto>> getAllResources(@RequestParam(value = "customer_id", required = false) String customerId) {
        return ResponseEntity.ok(languageService.getAll(customerId));
    }

    @GetMapping(I18N_MESSAGES_FOR_MODULE)
    @Operation(summary = "Returns list of all available resources for a specific module")
    public ResponseEntity<List<LanguageResourceDto>> getAllResourcesForModule(@PathVariable("module") String module,
                                                                              @RequestParam(value = "customer_id", required = false) String customerId) {
        return ResponseEntity.ok(languageService.getAllForModule(module, customerId));
    }

    @GetMapping(I18N_MESSAGES_FOR_MODULE_AND_LANGUAGE)
    @Operation(summary = "Returns all resources for a specific module and language")
    public ResponseEntity<List<LanguageResourceDto>> getAllResourcesForModuleAndLanguage(@PathVariable("module") String module,
                                                                                         @PathVariable("language") String languageCode,
                                                                                         @RequestParam(value = "customer_id", required = false) String customerId) {
        return ResponseEntity.ok(languageService.getAllForModuleAndLanguage(module, languageCode, customerId));
    }

    @GetMapping(I18N_MESSAGES_FOR_LANGUAGE)
    @Operation(summary = "Returns all language resources for a chosen language")
    public ResponseEntity<List<LanguageResourceDto>> getAllResourcesForLanguage(@RequestParam(value = "customer_id", required = false) String customerId,
                                                                                @PathVariable("language") String language) {
        return ResponseEntity.ok(languageService.getAllForLanguage(customerId, language));
    }
}