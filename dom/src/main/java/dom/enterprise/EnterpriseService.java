package dom.enterprise;

import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;

import dom.contact.ContactVO;

@Named("Enterprise")
public class EnterpriseService extends AbstractFactoryAndRepository{
	
    @Named("New")
    @MemberOrder(sequence = "1")
    public Enterprise nuevaEmpresa(
            @RegEx(validation = "\\w[@&:\\-\\,\\.\\+ \\w]*") // words, spaces and selected punctuation
            @Named("Name") String name, 
            @Optional
            @Named("Address") String address,
            @Optional
            @Named("Telephone") String telephone,
            @Optional
            @Named("Email") String email
            ) {
    	final ContactVO contact = new ContactVO(address,telephone,email);
    	final String knowUser = knowUser();
    	
    	Enterprise enterprise = newTransientInstance(Enterprise.class);
    	
    	enterprise.setName(name);
    	enterprise.setContact(contact);
    	enterprise.setUser(knowUser);
    	
    	persistIfNotAlready(enterprise);
    	
        return enterprise; 
    }
    
    @Named("Show List")
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "2")
    public List<Enterprise> listEnterprise() {
    	
        final List<Enterprise> listEnterprise = allMatches(Enterprise.class, 
        	new Filter<Enterprise>() {
   			@Override
       			public boolean accept(final Enterprise enterprise) {
       				return Objects.equal(enterprise.getUser(), knowUser())&&Objects.equal(enterprise.isState(), true);
       			}
        	}
        );   
        return listEnterprise;
    }    
    
    @Hidden
    public List<Enterprise> completeEnterprise(final String filter) {
        return allMatches(Enterprise.class, new Filter<Enterprise>() {
        	@Override
            public boolean accept(final Enterprise e) {
                return createBy(e) && e.getName().contains(filter) && e.isState();
            }
        });
    }
    
    protected boolean createBy(final Enterprise e) {
        return Objects.equal(e.getUser(), knowUser());
    }
    protected String knowUser() {
        return getContainer().getUser().getName();
    }
	
}
