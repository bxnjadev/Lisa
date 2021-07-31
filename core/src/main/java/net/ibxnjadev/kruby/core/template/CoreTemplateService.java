package net.ibxnjadev.kruby.core.template;

import net.ibxnjadev.kruby.abstraction.template.Template;
import net.ibxnjadev.kruby.abstraction.template.TemplateService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CoreTemplateService implements TemplateService {

    private final Map<String, Template> templates = new HashMap<>();
    private final Map<String, String> templateIds = new HashMap<>();

    @Override
    public void createTemplate(Template template) {

    }

    @Override
    public void registerTemplate(Template template) {

    }

    @Override
    public void deleteTemplate(String templateId) {
        findTemplate(templateId)
                .ifPresent(template -> {

                    templateIds.remove(template.getName());
                    templates.remove(templateId);
                });
    }

    @Override
    public void deleteTemplateByName(String templateName) {
        String templateId = templateIds.get(templateName);
        if (templateId != null) {
            deleteTemplate(templateId);
        }
    }

    @Override
    public Template getTemplate(String templateId) {
        return templates.get(templateId);
    }

    @Override
    public Optional<Template> findTemplate(String templateId) {
        return Optional.ofNullable(getTemplate(templateId));
    }

    @Override
    public Template getTemplateByName(String templateName) {
        String templateId = templateIds.get(templateName);
        if (templateId != null) {
            return getTemplate(templateId);
        }
        return null;
    }

    @Override
    public Optional<Template> findTemplateByName(String templateName) {
        return Optional.ofNullable(getTemplateByName(templateName));
    }

    @Override
    public boolean templateExists(String templateId) {
        return templates.containsKey(templateId);
    }

    @Override
    public boolean templateExistsByName(String templateName) {
        String templateId = templateIds.get(templateName);
        if (templateId != null) {
            return templateExists(templateId);
        }
        return false;
    }
}
