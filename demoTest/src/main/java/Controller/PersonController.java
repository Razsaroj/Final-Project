package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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

	@RequestMapping("{id}")
	public Person getPerson(@PathVariable("id") String id ) 
	{
		return ps.getPerson(id);
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
	public List<String> GetBlog() 
	{
		String urlString = "http://localhost:8983/solr/newCollFlim";
    	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
    	
    	//Querying Solr...
    	SolrQuery query = new SolrQuery();
    	query.add("q", "*:*");
    	
    	List<String> lst = new ArrayList<String>();
    	
    	//getting query response..
    	QueryResponse response;
    	
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
	public void del() 
	{
	
		 String urlString = "http://localhost:8983/solr/newCollFlim";
	        String UML =    "http://localhost:8983/solr/fruitSeller";
	        HttpSolrClient solr = new HttpSolrClient.Builder(UML).build();
	        solr.setParser(new XMLResponseParser());
	        
	        try {
				solr.deleteByQuery("*");
				solr.commit(); 
				
			} catch (SolrServerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    }
	
	

	
	
}
