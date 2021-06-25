package net.ibxnjadev.kruby.abstraction.template;

import java.util.Optional;

/**
 * This class manage the template system
 */

public interface TemplateService {

    /**
     * Register the template in cache and database
     * @param template the template
     */

    void registerTemplate(Template template);

    /**
     * Delete the template
     * @param templateId the template
     */

    void deleteTemplate(String templateId);

    /**
     * Find a template by name
     * @param name the name of the template
     * @return the template
     */

    Optional<Template> findTemplate(String name);

    /**
     * Verified if exists template
     * @param templateName the name template
     */

    boolean templateExists(String templateName);

}
