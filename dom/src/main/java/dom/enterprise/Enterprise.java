package dom.enterprise;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Audited;
import org.apache.isis.applib.annotation.AutoComplete;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;

import dom.contact.ContactVO;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY)
@javax.jdo.annotations.Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")
@ObjectType("ENTERPRISE")
@AutoComplete(repository=EnterpriseService.class, action="completaEmpresas")
@Audited
public class Enterprise {
		
	/*
	 * Razon Social de la empresa
	 */
	private String name;

	@Title
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Persistent
	private ContactVO contact;
	
	public ContactVO getContact() {
		return contact;
	}
	
	public void setContact(ContactVO contact) {
		this.contact = contact;
	}
	
	private boolean state;
	
	@Hidden
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	private String user;

    @Hidden
    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = user;
    }
	
 // {{ injected: DomainObjectContainer
    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.setContainer(container);
    }

	public DomainObjectContainer getContainer() {
		return container;
	}

	public void setContainer(DomainObjectContainer container) {
		this.container = container;
	}
		
}
