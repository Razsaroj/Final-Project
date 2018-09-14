package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Model.CrawlMyLine;
import Model.Graffiti;
import Model.Person;
import Service.PersonService;

@RequestMapping("/persons")
@RestController
public class PersonController {
	
	@Autowired
	PersonService ps;
	
	@RequestMapping(value="/all" , produces= {"application/xml", "application/json" })
	public List<Person> getAll()
	{
		return ps.getAll();
	}

	@RequestMapping(value="user", method = RequestMethod.GET)
	public String getPerson(@RequestParam("param1") String param1Value,@RequestParam("param2") String param2Value ) 
	{
		return param1Value+" "+param2Value;
	}
	
	@RequestMapping(value="/ConnectSolr")
	public void solo() 
	{
		List<CrawlMyLine> lst = ps.readMeJson();
		
		String urlString = "http://localhost:8983/solr/newCollFlim";
    	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
    	solr.setParser(new XMLResponseParser());
    	
    	Collection<Person> pst = ps.getAll();
    	
    	try {
			solr.addBeans(lst);
			solr.commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
	}
	
	@RequestMapping(value="/CrawlWithMe")
	public List<CrawlMyLine>  crawl()
	{
		return ps.readMeJson();
	}
	
	

	@RequestMapping(value="/grapa", produces= {"application/xml", "application/json" })
	public List<String> GetBlog(@RequestParam("name") String param1Value,@RequestParam("value") String param2Value) 
	{
		String urlString = "http://localhost:8983/solr/fruitSeller";
    	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
    	List<String> lst = new ArrayList<String>();
    	//getting query response..
    	QueryResponse response;
    	
    	
    	
    	//Querying Solr...
    	SolrQuery query = new SolrQuery();
    	String name=param1Value;
    	String value=param2Value;
    	query.add("q", name+":"+value);
    	
    	/*//Name of fields
    	String[] fields= {"Country","Exchange"};
    	query.setFields(fields);
    	*/
    	
    	
    	
		try 
		{
			response = solr.query(query);
			
			//Get result response...
			SolrDocumentList doclist = response.getResults();
			
			//Iterate over incoming document...
			for(SolrDocument doct :doclist ) 
			{
				lst.add(doct.toString());
			}
			
		}
    	catch(SolrServerException  e) 
		{
    		e.printStackTrace();
    		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	
	@RequestMapping(value="/panini")
	public Collection<SolrInputDocument> facetFeild() 
	{
	
    	return ps.CVSThorHammer();
    }
	
	@RequestMapping(value="/delAll")
	public String del(@RequestParam("id") String id) 
	{
	
		 String urlString = "http://localhost:8983/solr/newCollFlim";
	        String UML =    "http://localhost:8983/solr/fruitSeller";
	        HttpSolrClient solr = new HttpSolrClient.Builder(UML).build();
	        solr.setParser(new XMLResponseParser());
	        
	        try {
				solr.deleteById(id);
				solr.commit(); 
				
			} catch (SolrServerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        return "Document Deleted";
    }
	
	
	
	@RequestMapping(value="/updateDoc")
	public void update() 
	{
		String UML =    "http://localhost:8983/solr/fruitSeller";
        HttpSolrClient solr = new HttpSolrClient.Builder(UML).build();
        
        SolrInputDocument sdoc = new SolrInputDocument();
        sdoc.addField("id", "78d70bc9-ef90-4744-b0ed-98e62a8d41b0");
        Map<String, Object> fieldMod = new HashMap<String, Object>(1);
        fieldMod.put("set","MorningStar");
        sdoc.addField("Contract_name", fieldMod);
        
        try {
			solr.add(sdoc);
			solr.commit();
			solr.close();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
	}
	

	@RequestMapping(value="/del")
	public String delAll() 
	{
	
		 String urlString = "http://localhost:8983/solr/newCollFlim";
	        String UML =    "http://localhost:8983/solr/fruitSeller";
	        HttpSolrClient solr = new HttpSolrClient.Builder(UML).build();
	        solr.setParser(new XMLResponseParser());
	        
	        try {
				solr.deleteByQuery("*:*");
				solr.commit(); 
				
			} catch (SolrServerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        return "All Documents Deleted";
    }
	
	
}
