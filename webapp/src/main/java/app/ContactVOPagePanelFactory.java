package app;

import org.apache.isis.viewer.wicket.model.models.ScalarModel;
import org.apache.isis.viewer.wicket.ui.ComponentFactoryAbstract;
import org.apache.isis.viewer.wicket.ui.ComponentType;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import dom.contact.ContactVO;

public class ContactVOPagePanelFactory extends ComponentFactoryAbstract {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactVOPagePanelFactory() {
        super(ComponentType.SCALAR_NAME_AND_VALUE);
    }
	
    @Override
    public ApplicationAdvice appliesTo(final IModel<?> model) {
    	if (!(model instanceof ScalarModel)) {
            return ApplicationAdvice.DOES_NOT_APPLY;
        }    	
    	
    	final ScalarModel scalarModel = (ScalarModel) model;
    	return appliesIf(ContactVO.class.isAssignableFrom(scalarModel.getTypeOfSpecification().getCorrespondingClass()));
    }

    @Override
    public Component createComponent(final String id, final IModel<?> model) {
        final ScalarModel scalarModel = (ScalarModel) model;
        return new ContactVOPagePanel(id, scalarModel);
    }

}
