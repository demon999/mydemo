package com.xxx.boot.jarslink1;

import com.alipay.jarslink.api.Action;
import com.alipay.jarslink.api.ModuleConfig;

public class HelloWorldAction implements Action<ModuleConfig, ModuleConfig> {

    @Override
    public ModuleConfig execute(ModuleConfig actionRequest) {
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName(actionRequest.getName());
        moduleConfig.setEnabled(actionRequest.getEnabled());
        moduleConfig.setVersion(actionRequest.getVersion());
        moduleConfig.setModuleUrl(actionRequest.getModuleUrl());
        moduleConfig.setProperties(actionRequest.getProperties());
        moduleConfig.setOverridePackages(actionRequest.getOverridePackages());
        return moduleConfig;
    }

    @Override
    public String getActionName() {
        return "helloworld";
    }

}
