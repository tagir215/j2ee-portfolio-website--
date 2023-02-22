package com.tiger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(HomePage.class);
	int topicNumber=0;
	int skillnumber = 0;
	final int MARGIN_LEFT = -255;
	public boolean userOnPage=true;
	ArrayList<ArrayList<String>> buttonIds = new ArrayList<ArrayList<String>>(); 
	
	
	
	public HomePage(final PageParameters parameters) {
		super(parameters);	
	
		//add(new MouseoverBehavior("mouseover",this));
		//add(new MouseoverBehavior("mouseleave",this));
		
		Tabs tabs = new Tabs("bar-tabs");
		add(tabs);
		
		add( new Image("front-img","title2.png") );
		add( new Image("arrow","wingarrow.png") );
	
		RepeatingView abouts = new RepeatingView("about");
		add(abouts);
		
		String aboutP = "Hei, tässä on portfolio koodaus projekteistani. Olen "
				+"pyrkinyt valitsemaan sekä itseä motivoivia, että kehittäviä "
				+ "töitä. Motivoidun parhaiten "
				+ "haastavista ja uniikeista projekteista, joten olen pyrkinyt valitsemaan "
				+ "projekteja sen perusteella. Olen oppinut paljon tämän vuoden "
				+ "aikana, mutta huomannut myös että on vielä paljon opittavaa. "
				+ "Olen toistaiseksi keskittynyt suurimmaksi osaksi back end koodaukseen, mutta aion "
				+ "opetella myös front end taitoja, jotta saisi enemmän ammattimaisen "
				+ "ulkomuodon projekteille.";
		abouts.add(new About("about","Portfolio 2023",aboutP));
		
		String experienceA= "Olen oppinut lähinnä projekteja tehdessä ja katsomalla opetusvideoita. "
				+ "Katson opetusvideot yleensä Kotlinilla ja muutan koodit Java kielelle. "
				+ "Tein kesällä myös n. kuukauden työharjoittelun, "
				+ "jossa tein kolme erilaista "
				+ "harjoitus projektia. Minulla oli mentori joka tarkisteli koodejani joten opin "
				+ "oleellisia asioita koodin muotoilusta ja sain lisäksi materiaalia sekä lukuvinkkejä. Olen opiskellut myös ammattikorkeakoulussa "
				+ "konetekniikkaa. Siellä opin matematiikkaa, elektroniikkaa, fysiikkaa sekä erilaisia cadeja. Kävin siellä myös "
				+ "kuukuden javascript kurssin. "
				+ "";
		abouts.add(new About("about3","Opiskelut",experienceA));
		
		
		
		
		RepeatingView skillGraphs = new RepeatingView("skill-div");
		add(skillGraphs);
		
		
		String[] skills = new String[] {"Java","Kotlin","C#","Javascript","CSS","SQL","Google Cloud","Heroku","Openshift","MySQL","Android","IntelliJ IDEA","Eclipse","Visual Studio","Unity","Apache Wicket"};
		int[] measures = new int[] {7,5,3,3,3,2,4,2,1,2,7,5,5,4,3,3};
		skillGraphs.add(new SkillGraph("skill-div1",skills,measures,"Taidot"));
		
		
		RepeatingView topics = new RepeatingView("topic");
		add(topics);
		
		
		String[] starImages = new String[] {
				"starchat0.jpg","starchat6.jpg","starchat2.jpg","starchat3.jpg","starchat7.jpg"
		};
		String i0 = "Java, Firebase, OpenGL, Xml";
		String[] p0 = new String[] {
				"STAR CHAT on whatsapp klooni, jossa kaikki kirjoittaminen tapahtuu Star Wars alkuteksteistä "
				+ "insipiroituun tyyliin. Projektissa oli tarkoitus opetella Firebase ja OpenGl "
				+ "teknologioita saman aikaisesti. Sovelluksessa on melkein kaikki samat ominaisuudet mitä "
				+ "whatsapissakin on, paitsi muutamia asioita kuten viestien salaus.  "
		};
		String[] ul0 = new String[] {
				"Kaikille käyttäjille ja ryhmille on generoitu uniiki id jotka on tallennettu firebaseen",
				"Käyttäjä solmuihin on tallennettu yleisiä käyttäjätietoja ja ryhmille on lisäksi tallennettu "
				+ "myös ryhmien jäsenet ja erilaisia aikamääreitä kuten milloin kukin henkilö on viimeksi nähty ryhmässä tai "
				+ "viestien päivämäärät, jotta uusien viestien lukumäärät voitaisiin laskea",
				"Tekstit on renderöity käyttäen openGL:ää mikä oli aika hankalaa",
				"Jokaiselle tekstin kirjaimelle piti määritellä erillinen quad objektin jonka päälle tuli tekstuuri",
				"Jokaiselle quad objetille piti määritellä sen leveys, korkeus, offsetit x ja y suunnille kirjoitus viivaan nähden, "
				+ "tekstuuri koordinaatit, tekstuuri atlas koordinaatit, koordinaatit tekstin sisällä ja muokkautuvat koordinaatit eri kokoisille "
				+ "teksteille kuten otsikoille. Lisäksi kaikille vektorieille tuli tehdä neljä matriisilaskua, jotka muuttivat kirjaimet kolmiulotteisiksi",
				"Kaikki tekstit on piirretty yhdelle objektille jotta prosessorin tarvitsi tehdä vain yksi piirtokutsu. Ja samasta syystä tuli käyttää tekstuuri atlasta",
				"Kirjaimet piti myös lajitella sanoiksi jotta uudet rivit eivät alkaisi sanan keskeltä tai toisaalta jos sanan pituus oli yli tekstin laatikon leveyden "
				+ "niin ottaa myös ne tilanteet huomioon. Lisäksi Star Wars alkutekstit on aseteltu niin että kaikki rivit "
				+ "ovat yhtä pitkät, joten kirjainten välinen etäisyys muokkautuu kunkin rivin tekstin leveyden perusteella",
				"Tein kaikki tarvittavat järjestely algoritmit ja matriisi kertomat itse harjoituksen vuoksi",
				"Tämä projeti oli ehkä vähän suoraviivaisempi kuin nuo edelliset projektit (OpenGL:ää lukuunottamatta), joten siinä meni lopulta vain noin "
				+"kolme viikkoa. Tein tällä kertaa UI:n heti ensimmäisenä, koska en ilmeisesti jotenkin projektin lopussa enää jaksa "
				+ "keskittyä visuaaleihin"
		};
		
		String[] golfImages = new String[] {
				"golfpicture13.png","golfpicture14.png","golfpicture15.png",
				"golfpicture16.png"
		};
		String i1 = "C#, Unity, Xml, Google Cloud";
		String[] p1 = new String[] { 
				"GPS GOLF on AR peli kännykälle, joka käyttää "
				+ "GPS paikannusta pääpelimekaniikkanaan. Tarkoitus on golfata pallot lipputankoihin "
				+ "jotka päivittyvät satunnaisesti joka päivä. Kartalle on merkitty tähän mennessä "
				+ "kaikki Suomen tiet, jotka on tallennettu Xml tiedostoille Google Cloudiin. "
				+ "Tiedot on kerätty OpenStreetMap sivustolta. Pelimoottorina on Unity. " 
				};
		String[] ul1 = new String[] {
				"Tein pelille erillisen OSM xml datan muokkaus ohjelman Visual Studiota käyttäen, koska en löytänyt netistä vastinetta. Ohjelma "
				+ "käytti trie data struktuuria yhdistämään ja suodattamaan n. 900 miljoonaa Suomen teiden koordinaatteja sopivampaan "
				+ "muotoon (OSM datan tie merkinnöissä oli vain viittaukset varsinasiin koordinaatteihin). Sekä lajitteli n.5 neliökilometrin "
				+ "kokoisia alueita koordinaattien perusteella nimettyihin kansioihin. Jotka sitten lopulta latasin Google Cloudiin",
				"Tiet on piirretty 3D pallon muotoiselle objektille, koska 2D alustalla koordinaatit vääristyivät hieman. 3D koordinaatit on laskettu mapallon säteen mukaan.",
				"Tiet on piirretty Unityn kolmioiden piirto työkaluilla tehden mahdollisimman yhtenäisiä objekteja, "
				+ "jotta suorituskyky ei kärsisi.",
				"Peli objektien koot muokkautuvat kameran etäisyyden perusteella",
				"Tämä oli ensimmäinen koodaus projektini joten siinä meni noin 2 kuukautta. Opin yllättävän paljon data "
				+ "struktuureista ja järjestely algoritmeista sekä myös Google Cloudin käyttöä"
				
		};
		
		
		
		
		String[] mapImages = new String[] {
				"mappicture1.jpg","mappicture2.jpg","mappicture4.jpg","mindmapCCDA.jpg","mindmapWW.jpg"
		};
		String i2 = "Java, Android Studio, Xml, Json";
		String[] p2 = new String[] {
				"YourMindMap on ajatuskarttojen luontiin tarkoitettu sovellus. "
				+ "Sovelluksesta löytyy lukuisia asetuksia joissa käyttäjää on huomioitu "
				+ "antamalla hänelle mahdollisimman vapaat kädet. "
				+ "Kuitenkin pitämällä työkalut intuitiivisina ja helppokäyttöisinä. "
				+ "Sovelluksessa on rajoitettu erilaisten asetusikkunoiden navigointia "
				+ "pitämällä kaikki tiiviisti yhdessä paikassa."
				};
		String[] ul2 = new String[] {
				"Ajatuskartan automaattinen tilan sommittelu. Kokeilin useita versioita, mutta päädyin laskemaan "
				+ "kaikki koordinaatit täysin matemaattisesti ja piirtämään kaiken canvakselle.",
				"Canvas ei piirrä karttaa joka ruudunpäivityksen jälkeen, vaan vain kun käyttäjä päästää irti "
				+ "esimerkiksi liikutettuuan karttaa. Bitmap itse siirtyy sormen mukana, mutta siirtyy takaisin "
				+ "paikoilleen sormen noustessa, jonka jälkeen piirtää kartan uudelleen, mutta ottaen siirretyn "
				+ "matkan huomioon",
				"Ajatuskartalla voi tehdä huonommallakin kännykällä yli 5 tuhannen solun karttoja ilman huomattavaa "
				+ "suorituskyvyn laskua.",
				"Suorakulmio valinta, ja monen solun muokkaaminen kerralla",
				"Viivan, laatikon, reuonojen muotojen, värien, ja viiva tyyppien editointi työkalut",
				"Tekstien värien, fonttien, asettelu ja koon editointi työkalut, sekä kartan automaattinen sopeutuminen eri fontti- "
				+ "ja teksti-koko asetuksille",
				"Tallennus, undo ja redo komennot sekä useiden karttojen tallennus mahdollisuus",
				"Vienti mahdollisuuksia pdf, jpg tai png",
				"Zoom",
				"Haarakkeiden pakkaus työkalu",
				"Kopionti ja liittämistyökalut",
				"Keskittämis työkalu",
				"Kuvien lisäys mahdollisuus",
				"Tämän ohjelman tekoon minulla meni yli 4 kuukautta. Opin paljon Android "
				+ "Frameworkin työkaluja sekä Javan- ja olio-ohjelmoinnin perusteita. Aloitin projektin useaan kertaan alusta "
				+ "koska minulle tuli ongelmia suoristuskyvyn ja koodin sekavuuden kanssa. "
		};
		
		
		
		
		String[] metronomeImages = new String[] {
				"picmetr1.jpg","picmetr2.jpg","picmetr3.jpg",
		};
		String i3 = "Java, Android Studio, OpenGL, Fast Fourier Transform, Autocorrelation";
		String[] p3= new String[] { 
				"Visual Metronome on musiikin harjoitteluun tarkoitettu "
				+ "apuohjelma. Joillakin muusikoilla rytmitaju saattaa heikentyä "
				+ "soittaessa monimutkaisempia kuvioita, "
				+ "jolloin aivot priorisoi rytmin pitämisen sijaan muita soittamiseen "
				+ "tarvittavia keskittymis alueita. Tässä ongelmana on myös se, että "
				+ "itse soittaja ei välttämättä edes kuule omia rytmi ongelmiaan. "
				+	"Visual Metronome pyrkii ratkaisemaan nämä ongelmat "
				+ "antamalla reaali aikaista selkeää feedbackiä, jolloin soittaja "
				+ "näkee virheet heti niiden tapahduttua."
				};
		String[] ul3 = new String[] {
				"Kokeilin erilaisia tapoja rytmien tunnistamiseen, kuten Fast Fourier transformia ja autokorrelaatiota, "
				+ "mutta päädyin lopulta vain laskemaan ääni aaltojen nollakohtien määrät nopeuden vuoksi, sekä ottamaan huomioon myös amplitudin muutokset ylöspäin. "
				+ "Jos nollakohtien määrä muuttuu edelliseen nuottiin verrattuna, tai "
				+ "jos amplitudi nousee ylöspäin yllättäen. niin se on todennäköisesti uusi nuotti ",
				"Ääniallot ja rytmi kuviot on mallinnettu käyttäen OpenGL:ää",
				"Rytmi kuviot muodostuvat y suunnassa suurempina nollakohtien perusteella "
				+ "sekä taas keltaisena tai läpinäkyvän punaisena äänen amplitudin mukaan",
				"Sovelluksessa on mahdollisuus myös äänittää soittoa sekä toistaa soitto äänten hiljennettyä automaattisesti "
				+ "valitun viiveen jälkeen. Tällöin soittajan ei tarvitse jatkuvasti painella 'record' ja 'play' nappeja",
				"Äänityksen ollessa päällä, sovellus tallentaa nauhoitusta AudioBufferiin, josta se karsii n. sekunnin vanhat osiot pois, "
				+ "jotta äänitystä toistaessa nauhoitus alkaisi sopivasta kohdasta ",
				"Ylesiä asetuksia esim. playback odotusajalle ja temmolle, sekä tahtilajin muutoksille ",
				"Ohjelma toimii hyvin kitaran kanssa, mutta toistaiseksi vielä puutteellisesti esimerkiksi pianon kanssa, joten "
				+ "joitakin parannuksia pitää vielä tehdä",
				"Tämän projektin tekemisessä suurin osa ajasta meni oikeastaan matematiikkaa opiskellessa. Tein tätä noin kuukauden. "
		};
		topics.add(new Topic("topic10",starImages,"Star Chat",i0,p0,ul0,"https://github.com/tagir215/Star-Chat/tree/master/main/java/com/android/starchat"));		
		topics.add(new Topic("topic13",metronomeImages,"Visual Metronme",i3,p3,ul3,"https://github.com/tagir215/VisualMetronome/tree/master/main/java/com/example/artmetronome"));
		topics.add(new Topic("topic12",mapImages,"Your Mind Map",i2,p2,ul2,"https://github.com/tagir215/YourMindMap/tree/master/myapplication"));
		topics.add(new Topic("topic11",golfImages,"GPS GOLF",i1,p1,ul1,"https://github.com/tagir215/GPSGolf"));
		
		
		
		
	}
	
	 
	
	@Override
	public void renderHead(IHeaderResponse response)
	{
		
	    super.renderHead(response);
	    StringBuilder stringBuilder1 = new StringBuilder();
	    stringBuilder1.append("window.onload = function(){");
	    List<String>initialButtons = new ArrayList<String>();
	    for(int i=0; i<buttonIds.size(); i++) {
	    	initialButtons.add(buttonIds.get(i).get(0));
	    }
	    for(int i=0; i<initialButtons.size(); i++) {
	    	stringBuilder1.append(getHighlightSelectedJs(initialButtons.get(i),"topic"+i));
	    }
	    
	    stringBuilder1.append("}");
	 	response.render(JavaScriptHeaderItem.forScript(stringBuilder1.toString()	,"ok"));
	   
	}
	
	private class SkillGraph extends WebMarkupContainer{

		public SkillGraph(String id, String[] skills, int[] measures, String title) {
			super(id);
			add(new Label("skillTitle",title));
			
			RepeatingView skillRow = new RepeatingView("skill");
			add(skillRow);
			for(int i=0; i<skills.length; i++) {
				Skill skill = new Skill("skill"+i+skillnumber,skills[i],measures[i]);
				skillRow.add(skill);
			}
			skillnumber++;
		}
		
	}
	private class Skill extends WebMarkupContainer{

		public Skill(String id,String skill,int measure) {
			super(id);
			
			RepeatingView repeatingView = new RepeatingView("skill-square");
			add(repeatingView);
			for(int i=0; i<10; i++) {
				WebMarkupContainer square = new WebMarkupContainer("square"+skillnumber+i);
				if(measure>i)
					square.add(AttributeModifier.append("class", "square-yes"));
				else
					square.add(AttributeModifier.append("class", "square-no"));
				repeatingView.add(square);
			}
			
			Label label = new Label("skill-label",skill);
			add(label);
		}
		
	}
	private class About extends WebMarkupContainer{

		public About(String id,String title,String p) {
			super(id);
			
			add(new Label("about-title",title));
			add(new Label("about-p",p));
		}
		
	}
	

	private class Topic extends WebMarkupContainer{
		
		String selectedButtonId;
		String imageContainerId;
		ImagePickerButton previousButton;
		ImagePickerButton firstButton;
		ImagePickerButton currentButton;
		int waitTime = 0;
		String topicId;
		public Topic(String id , String[] images, String title, String italy, String[] p, String[] ul,String url) {
			super(id);
			topicId = "topic"+topicNumber;
			this.setOutputMarkupId(true);
			this.setMarkupId(topicId);
			add(new Label("work-title",title));
			add(new Label("italic-section",italy));
			add(new GitLink("gitlink",url));
			
			
			WebMarkupContainer background = new WebMarkupContainer("background");
			background.add(new Image("random","sale.jpg"));
			background.add(new AttributeModifier("class","background"+topicNumber));
			add(background);
			
			
			
			
			RepeatingView paragraphs = new RepeatingView("work-p");
			add(paragraphs);
			for(int i=0; i<p.length; i++) {
				paragraphs.add(new Label("p"+topicNumber + i,p[i]));
			}
			RepeatingView list = new RepeatingView("work-li");
			add(list);
			for(int i=0; i<ul.length; i++) {
				list.add(new Label("li"+topicNumber+i,ul[i]));
			}
		
			WebMarkupContainer containerPlus = new WebMarkupContainer("container-plus");
			add(containerPlus);
			Image imagePhone = new Image("imgPhone","phone20.9.png");
			imagePhone.setOutputMarkupId(true);
			containerPlus.add(imagePhone);
			
			WebMarkupContainer containerSlide = new WebMarkupContainer("slide-container");
			containerPlus.add(containerSlide);
			containerSlide.setOutputMarkupId(true);
			
			
			WebMarkupContainer containerImages = new WebMarkupContainer("images-container");
			containerSlide.add(containerImages);
			String markupId = "image-container"+String.valueOf(topicNumber);
			imageContainerId = markupId;
			containerImages.setMarkupId(markupId);
			
			Form form = new Form("button-form");
			containerPlus.add(form);
			
			form.add(new IntervalMover2(Duration.ofMillis(4000),this));
			
			RepeatingView rvSpan = new RepeatingView("span-image");
			containerSlide.add(rvSpan);
			RepeatingView rvShow = new RepeatingView("imgSlideShow");
			containerImages.add(rvShow);
			RepeatingView rvButton = new RepeatingView("button");
			form.add(rvButton);
			
			buttonIds.add(new ArrayList<String>());
			
			
			for(int i=0; i<images.length; i++) {
				rvShow.add(new Image("imgSlideShow"+i,images[i]));
				rvSpan.add(new Label("span-image"+i));
				String buttonId = "button"+String.valueOf(i)+String.valueOf(topicNumber);
				
				buttonIds.get(topicNumber).add(buttonId);
				
				final int e = i * MARGIN_LEFT;
				ImagePickerButton button = new ImagePickerButton("button"+i,buttonId,this,e);
				button.setMarkupId(buttonId);
				button.setOutputMarkupId(true);
				rvButton.add(button);
				
				if(i==0) {
					selectedButtonId = buttonId;
					firstButton = button;
					currentButton = firstButton;
				}
				
				if(previousButton != null) {
					previousButton.nextButton = button;
					if(i==images.length-1)
						button.nextButton = firstButton;
				}
				previousButton = button;
			}
			
			
			topicNumber++;
		}
		
		
	}
	
	private class GitLink extends Link {

		public GitLink(String id, String url) {
			super(id);
			// TODO Auto-generated constructor stub
			add(new AttributeModifier("href",url));
		}
		@Override
		public MarkupContainer setDefaultModel(IModel arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void onClick() {
			// TODO Auto-generated method stub
		}
		
	}
	
	
	
	private class ImagePickerButton extends AjaxButton {
	
		Topic topic;
		ImagePickerButton nextButton;
		String buttonId;
		int e;
		public ImagePickerButton(String id,String markupId, Topic topic, int e) {
			super(id);
			this.topic = topic;
			this.buttonId = markupId;
			this.e = e;
		}
		
		@Override
		protected String getOnClickScript() {
			return getAnimateMovementJs(topic.imageContainerId,e,buttonId,topic.topicId);
		}
		
		@Override
		protected void onSubmit(AjaxRequestTarget target) {
			super.onSubmit(target);
			topic.currentButton = this; 
			topic.waitTime = 5;
		}
		
		
	}
	
	private class IntervalMover2 extends AbstractAjaxTimerBehavior {
		Topic topic;
		long startTime = 0;
		public IntervalMover2(Duration updateInterval, Topic topic) {
			super(updateInterval);
			this.topic = topic;
		}

		protected void onTimer(AjaxRequestTarget target) {
			
			if(topic.waitTime<=0 && userOnPage) {
				topic.selectedButtonId = topic.currentButton.buttonId;
				target.appendJavaScript(getAnimateMovementJs(topic.imageContainerId,topic.currentButton.e,topic.selectedButtonId,topic.topicId));
				topic.currentButton = topic.currentButton.nextButton;
			} else {
				topic.waitTime --;
			}
			
		}
		
	}
	

	
	private String getHighlightSelectedJs(String selectedButtonId, String topicId) {
			
		return "$('#"+topicId+"').find('.selectedButton').removeClass('selectedButton').addClass('button');"
				+"$('#"+selectedButtonId+"').removeClass('button').addClass('selectedButton');";
	}
	
	
	private String getAnimateMovementJs(String id,int e, String selectedButtonId,String topicId) {
		return "$('#"+id+"').stop().animate({marginLeft:'"+e+"'},600);"
				+ getHighlightSelectedJs(selectedButtonId,topicId);
				
	}
	
	
	

}
