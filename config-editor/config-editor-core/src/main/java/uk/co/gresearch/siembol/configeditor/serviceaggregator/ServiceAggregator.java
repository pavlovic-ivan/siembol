package uk.co.gresearch.siembol.configeditor.serviceaggregator;

import org.springframework.boot.actuate.health.Health;
import uk.co.gresearch.siembol.configeditor.common.AuthorisationException;
import uk.co.gresearch.siembol.configeditor.model.ConfigEditorService;
import uk.co.gresearch.siembol.configeditor.common.ConfigSchemaService;
import uk.co.gresearch.siembol.configeditor.configstore.ConfigStore;

import java.util.List;

public interface ServiceAggregator {
    ConfigStore getConfigStore(String user, String serviceName) throws AuthorisationException;

    ConfigSchemaService getConfigSchema(String user, String serviceName) throws AuthorisationException;

    List<ConfigStore> getConfigStoreServices();

    List<ConfigSchemaService> getConfigSchemaServices();

    List<ConfigEditorService> getConfigEditorServices(String user);

    Health checkConfigStoreServicesHealth();

    Health checkConfigSchemaServicesHealth();
}
