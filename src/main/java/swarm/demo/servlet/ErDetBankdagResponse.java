package swarm.demo.servlet;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErDetBankdagResponse {
	private boolean erDetBankDag;

	public boolean isErDetBankDag() {
		return erDetBankDag;
	}

	public void setErDetBankDag(boolean erDetBankDag) {
		this.erDetBankDag = erDetBankDag;
	}
}
