package net.ibxnjadev.kruby.core.setup.loader;

import net.ibxnjadev.kruby.core.storage.local.LocalStorage;
import net.ibxnjadev.kruby.core.storage.local.LocalStorageProvider;
import net.ibxnjadev.kruby.core.template.Template;
import net.ibxnjadev.kruby.core.template.TemplateService;

import java.io.File;

public class TemplateLoader implements Loader {

    private final TemplateService templateService;
    private final LocalStorageProvider localStorageProvider;

    public TemplateLoader(TemplateService templateService, LocalStorageProvider localStorageProvider) {
        this.templateService = templateService;
        this.localStorageProvider = localStorageProvider;
    }

    @Override
    public void load() {

        LocalStorage<Template> localStorage = localStorageProvider.registerStorage(Template.class, new File("templates"));

        localStorage
                .values()
                .forEach(templateService::registerTemplate);

    }

}
