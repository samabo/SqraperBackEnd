package com.qien.sqraper.api;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.Document;
import javax.ws.rs.Path;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import com.qien.sqraper.domain.Vacature;
import com.qien.sqraper.persistence.SqraperService;
import com.qien.sqraper.persistence.VacatureRepository;

@Path ("scr")
public class SqraperEndpoint {

	@Autowired
	private SqraperService sqraperService;
	
	// ==========================================================================	
	//	SCRAPER GEDEELTE	
	
	VacatureRepository vacatureRepository;
	
	public Iterable<Vacature> findAll() {
		System.out.println("in service");
		Document doc;
		ArrayList<Vacature> vacatures = new ArrayList<>();
		
		try {
			doc = (Document) Jsoup
					.connect(
							"https://www.monsterboard.nl/vacatures/zoeken/?q=java&cy=nl&rad=20&intcid=swoop_HeroSearch")
					.get();
			Elements elements = ((Element) doc).select("#SearchResults");
			if (elements.size()!=1) {
				return vacatures;
			}
			
			
	        for (Element result : ((Element) doc).select("h2.title a")){

	            final String title = result.text();
//	            final String url = result.attr("href");

	            System.out.println("Titel = " + title);
	            
//	            System.out.println(title + " -> " + url);
	           
		////////////////////////////	
			
//			
//			Elements children = elements.get(0).children();
//			for (Element element : children) {
//				System.out.println(element.html());
//				
//				Elements url = element.select("a[href]");		// geeft nog steeds niet de link alleen
//				String link = url.toString();
//				
//				element = element.getElementsContainingOwnText("java").first(); 
//				
				Vacature vacature = new Vacature();
//				vacature.setTitel(title);
//				vacature.setPlaats(element.location);
//				vacature.setBedrijf(element.company);
				
				
				////////////////////////////	

				
				
				vacatures.add(vacature);
			}
			
			System.out.println("in service na vacatures.add(vacature)");
		} catch (IOException e) {

			e.printStackTrace();
		}
		return vacatures;
	}

	public void deleteById(Long id) { // voor delete
		if (vacatureRepository.findById(id).isPresent()) {
			vacatureRepository.deleteById(id);
		}

	}
	
	
}
