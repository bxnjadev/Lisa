package net.ibxnjadev.kruby.core.messenger.interceptor;

import net.ibxnjadev.kruby.core.cloud.CloudService;
import net.ibxnjadev.kruby.core.messenger.message.CreateServerMessage;
import net.ibxnjadev.kruby.core.template.Template;
import net.ibxnjadev.kruby.core.template.TemplateService;
import net.ibxnjadev.vmesseger.universal.Interceptor;

public class CreateServerInterceptor implements Interceptor<CreateServerMessage> {

    private final CloudService cloudService;
    private final TemplateService templateService;

    public CreateServerInterceptor(CloudService cloudService, TemplateService templateService) {
        this.cloudService = cloudService;
        this.templateService = templateService;
    }

    @Override
    public void subscribe(CreateServerMessage createServerMessage) {
        Template template = templateService.getTemplate(createServerMessage.getTemplateName());

        cloudService.createServer(template,
                createServerMessage.getServerName(),
                createServerMessage.getCommandStart(),
                createServerMessage.isStatic(),
                createServerMessage.getVariables());
    }
}
