package swarm.demo.servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
 
  
@WebServlet("/")
public class HelloServlet extends HttpServlet {
	private final static String URI_BOOK = "http://erdetbankdag-erdetbankdag.52.178.134.24.nip.io/rest/day";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ResteasyClient client = new ResteasyClientBuilder().build();
        Response response = client.target(URI_BOOK).request().get();
        ErDetBankdagResponse erDetBankDag = response.readEntity(ErDetBankdagResponse.class);
        
        resp.getWriter().write("<html>"
        		             + "  <head>"
        		             + "    <title>Er det bankdag?</title>"
        		             + "  </head>"
        		             + "  <body>"
        		             + "    <h1>" + (erDetBankDag.isErDetBankDag()? "JA": "NEJ") + "</h1>"
                             + "  </body>"
                             + "</html>");
    }
}
