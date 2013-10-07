package dom.contact;

import java.io.Serializable;

public final class ContactVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public ContactVO(final String address, final String telephone, final String email) {
		this.address = address;
		this.email = email;
		this.telephone = telephone;
	}
	
	private String address;

	public String getAddress() {
		return address;
	}	

	private String telephone;
	
	public String getTelephone() {
		return telephone;
	}
	
	private String email;

	public String getEmail() {
		return email;
	}
}