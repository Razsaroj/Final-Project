package Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.cloud.translate.*;
import com.google.cloud.translate.Translation;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import Model.CrawlMyLine;
import Model.Graffiti;
import Model.Person;

@Service
public class PersonService {

	
	Hashtable<String, Person> hash = new Hashtable<String , Person>();
	List<Person> list = new ArrayList<Person>(); 
	PersonService()
	{
		
		Person p =new Person();
		p.setId(1);
		p.setAge(12);
		p.setName("Teper");
		p.setOccupation("fishing");
		
		Person p1 =new Person();
		p1.setId(2);
		p1.setAge(24);
		p1.setName("ankho");
		p1.setOccupation("alpta");
		
		Person p2 =new Person();
		p2.setId(3);
		p2.setAge(56);
		p2.setName("masom");
		p2.setOccupation("dekte");
		
		hash.put("1", p1);
		hash.put("2", p2);
		hash.put("3", p);
		
		list.add(p2);
		list.add(p1);
		list.add(p);
	
	}
	
	public Person getPerson(String s) 
	{
		if(hash.containsKey(s))
			return hash.get(s);
		else
			return null;
	}
	
	public List<Person> getAll()
	{
		return list;
	}
	
	
	public List<CrawlMyLine>  readMeJson() 
	{
		List<CrawlMyLine> CrawlList = new ArrayList<CrawlMyLine>();
		 File file = new File("D:\\Monaco.json");
		 try {
			String content = FileUtils.readFileToString(file, "utf-8");
			
			JSONArray jArray = new JSONArray(content);
			
			
			
			  for (int i = 0; i < jArray.length(); i++) 
			  {
				  JSONObject jb  = jArray.getJSONObject(i);
				  
//				  Translate translate = TranslateOptions.getDefaultInstance().getService();
				  
				  
				  CrawlMyLine crawl = new CrawlMyLine();
				 String strBody = jb.getString("Body");
				String strEmail	=	jb.getString("Email");
			String strName=	jb.getString("Name");
				 
		/*	Translation trastrBody = translate.translate(strBody,Translate.TranslateOption.sourceLanguage("la"),
				    Translate.TranslateOption.targetLanguage("en-gb"));
				 
			Translation trastrEmail = translate.translate(strEmail,Translate.TranslateOption.sourceLanguage("la"),
				    Translate.TranslateOption.targetLanguage("en-gb"));
			
			Translation trastrName = translate.translate(strName,Translate.TranslateOption.sourceLanguage("la"),
				    Translate.TranslateOption.targetLanguage("en-gb"));*/
				 
				  crawl.setBody(strBody);
				  crawl.setEmail(strEmail);
				  crawl.setId( Integer.parseInt(jb.getString("Id")) );
				  crawl.setName(strName);
				  crawl.setPostID(Integer.parseInt(jb.getString("PostID")));
				  CrawlList.add(crawl);
				  
				 
			  }
			
			
			
			
			
			
			
		} 
		 catch (Exception e){e.printStackTrace();}
		
		return CrawlList;
	}
	
	
	
	public Collection<SolrInputDocument> CVSThorHammer() 
	{
		 String csvFile = "D:\\Assignment\\Transformer.csv";
		 String csvFiletransformer1 = "D:\\Assignment\\Transformer1.csv";
		 String csvFiletransformer2 = "D:\\Assignment\\Transformer2.csv";

		 
		 List<String> fileList = new ArrayList<String>();
		 fileList.add(csvFile);
		 fileList.add(csvFiletransformer1);
		 fileList.add(csvFiletransformer2);
		 
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        List<Graffiti> lst = new ArrayList();
	        String[] aa=null;
	        List<String[]> allData=null ;
	        
	        List<Map<String,String>> mapLst = new ArrayList<Map<String,String>>();
	        
	        
	        
	        ////////////////  Solr //////////////////////////////////////////////////////
	        String urlString = "http://localhost:8983/solr/newCollFlim";
	        String UML =    "http://localhost:8983/solr/fruitSeller";
	        HttpSolrClient solr = new HttpSolrClient.Builder(UML).build();
	        solr.setParser(new XMLResponseParser());
	        Collection<SolrInputDocument> doc = new ArrayList<SolrInputDocument>();
	        
	        
	        
	        
	        for(int arr=0; arr<fileList.size();arr++)
	        {
	        	int i=1;
	        	int k = 0;
	        try {
	        
	        	
	        	br  = new BufferedReader(new FileReader(fileList.get(arr).toString()) );
	        	
	        	String[] Header = null,Value;
	        	
	        	while((line = br.readLine())!=null) 
	        	{
	        		SolrInputDocument document1 = new SolrInputDocument();
	        		Map<String,String> map = new HashMap<String,String>();
	        		if(i==1) 
	        		{
	        			i++;
	        			Header = line.split(",");
	        			continue;
	        	
	        		}
	        		else 
	        		{
	        			
	        			Value = line.split(",");
	        		
	        			System.out.println("Header value ============================" + Header);
	        			System.out.println("value ============================" + Value);
	        			for(int j=0; j<Header.length;j++) 
	        			{
	        				if(j < Value.length) {
	        				map.put(Header[j], Value[j]);
	        				document1.addField(Header[j].toString(),Value[j].toString());
	        				}
	        				else
	        				{map.put(Header[j],"");
	        				document1.addField(Header[j].toString(),"");
	        				}

	        			}
	        		}
	        		
	        	
	        		doc.add(document1);
	        		mapLst.add(map);
	        		if(k==100)
	        			break;

	        		k++;
	        	}
	        	
	        	
	        	
	        	
	        }catch(Exception e) 
	        {
	        	e.printStackTrace();
	        }
	        
	        
	        
	        
	        ////////////////////////////// Sending Whole data to Server //////////////////////////////////////////////
	        
	        try {
	        	System.out.println("Value of k" + k);
	        	
				solr.add(doc);
				solr.commit();
			} catch (SolrServerException e) {
							e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			}
	        	
	    
	       
	        }
	        
	 return doc;
	}	
	
	
}
