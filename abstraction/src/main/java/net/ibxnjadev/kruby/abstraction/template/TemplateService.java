package net.ibxnjadev.kruby.abstraction.template;

import java.util.Optional;

/**
 * This class manage the template system
 */

public interface TemplateService {

    /**
     * Create the new template based in docker image
     * @param template the object template
     */

    void createTemplate(Template template);

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
     * Delete the template by name
     * @param templateName the template name
     */

    void deleteTemplateByName(String templateName);


    /**
     * Get the template by name
     * @param templateId the id template
     * @return the template
     */

    Template getTemplate(String templateId);

    /**
     * Find a template by name
     * @param templateId the name of the template
     * @return the template
     */

    Optional<Template> findTemplate(String templateId);

    /**
     * Get the template by name
     * @param templateName the template name
     * @return the template, can be null
     */

    Template getTemplateByName(String templateName);

    /**
     * find the template by name
     * @param templateName the template name
     * @return a optional of template
     */

    Optional<Template> findTemplateByName(String templateName);

    /**
     * Check the template exist
     * @param templateId verify if the template exists
     * @return a boolean reply if the template exists
     */

    boolean templateExists(String templateId);

    /**
     * Verified if exists template
     * @param templateName the name template
     */

    boolean templateExistsByName(String templateName);

}
