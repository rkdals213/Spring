package heros.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Heroes {
	private IronMan im;
	private HulkBuster hb;
	
	@Autowired
	public Heroes(@Qualifier("ironMan")	IronMan im) {
		this.im = im;
	}
	
	@Autowired
	public void setHulkBuster(HulkBuster hb) {
		this.hb = hb;
	}
}
