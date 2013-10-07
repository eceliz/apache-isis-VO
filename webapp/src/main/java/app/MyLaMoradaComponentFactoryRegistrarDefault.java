package app;

import org.apache.isis.viewer.wicket.viewer.registries.components.ComponentFactoryRegistrarDefault;

import com.google.inject.Singleton;


@Singleton
public class MyLaMoradaComponentFactoryRegistrarDefault extends ComponentFactoryRegistrarDefault {
	@Override
	public void addComponentFactories(ComponentFactoryList componentFactories) {
	    componentFactories.add(new ContactVOPagePanelFactory());
	    super.addComponentFactories(componentFactories);
    }
}