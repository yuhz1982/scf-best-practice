package org.mydotey.scf.bp.component;

import org.mydotey.scf.ConfigurationManager;
import org.mydotey.scf.ConfigurationManagerConfig;
import org.mydotey.scf.ConfigurationSource;
import org.mydotey.scf.facade.ConfigurationManagers;
import org.mydotey.scf.facade.StringProperties;
import org.mydotey.scf.facade.StringPropertySources;
import org.mydotey.scf.source.stringproperty.propertiesfile.PropertiesFileConfigurationSourceConfig;

/**
 * @author koqizhao
 *
 * Jul 19, 2018
 * 
 * The component defines how the properties are configured!
 */
public class OwnManagerComponent {

    private StringProperties _properties;

    public OwnManagerComponent() {
        initConfig();
    }

    /**
     * use the following methods to get your properties / property values
     *      getProperties().getSomeProperty
     *      getProperties().getSomePropertyValue
     *      getProperties().getManager()
     */
    protected StringProperties getProperties() {
        return _properties;
    }

    private void initConfig() {
        // create a non-dynamic K/V (String/String) configuration source
        PropertiesFileConfigurationSourceConfig sourceConfig = StringPropertySources
                .newPropertiesFileSourceConfigBuilder().setName("properties-file")
                .setFileName("my-component.properties").build();
        ConfigurationSource source1 = StringPropertySources.newPropertiesFileSource(sourceConfig);

        // create other dynamic or non-dynamic sources
        // ...

        // create a configuration manager with single source
        ConfigurationManagerConfig managerConfig = ConfigurationManagers.newConfigBuilder().setName("my-component")
                .addSource(1, source1)
                // add other sources
                .build();
        ConfigurationManager manager = ConfigurationManagers.newManager(managerConfig);

        // create a StringProperties facade tool
        _properties = new StringProperties(manager);
    }

    public void yourComponentApi() {

    }

}
