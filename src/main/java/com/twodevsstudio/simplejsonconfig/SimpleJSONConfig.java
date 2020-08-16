package com.twodevsstudio.simplejsonconfig;


import com.twodevsstudio.simplejsonconfig.api.AnnotationProcessor;
import com.twodevsstudio.simplejsonconfig.exceptions.InstanceOverrideException;
import com.twodevsstudio.simplejsonconfig.exceptions.PluginNotFoundException;
import org.spongepowered.api.plugin.PluginContainer;


public enum SimpleJSONConfig {
  INSTANCE;

  private PluginContainer instance;

  /**
   * Before you start using this library you're supposed to register your plugin instance
   * To point for which plugin you'll create configurations
   *
   * @param plugin Plugin which uses this library
   *
   * @throws InstanceOverrideException when you try to call register method more than once
   * @apiNote All of the configuration files will be stored in human readable .json format
   * inside the "YourPluginBaseFolder/configuration/" folder
   */
  public void register(PluginContainer plugin) {

    if(instance != null) throw new InstanceOverrideException();
    this.instance = plugin;
    AnnotationProcessor.processAnnotations(this.instance);
  }

  /**
   * Get back instance of your plugin
   *
   * @return instance of registered plugin
   *
   * @throws PluginNotFoundException when you didn't registered any plugin for this library
   */
  public PluginContainer getInstance() {

    if(instance == null) throw new PluginNotFoundException();
    return instance;
  }
}
