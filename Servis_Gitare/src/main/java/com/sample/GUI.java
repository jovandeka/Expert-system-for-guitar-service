package com.sample;
import com.sample.Gitara;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class GUI {

	public Gitara gitara;
	public JFrame frame;
	public KieSession kSession;
	public JPanel panel = new JPanel();
	public String resi = "";
	
	public JLabel lblAkcija = new JLabel("Problem sa akcijom?");
	public String[] akcija = {"ne", "preniska i zice zuje", "previsoka i krivi vrat"};
	final JComboBox akcijaBox = new JComboBox(akcija);
	
	public JLabel lblZica = new JLabel("Problem sa zicom?");
	public String[] zica = {"ne", "pokidana", "zardjala"};
	final JComboBox zicaBox = new JComboBox(zica);
	
	public JLabel lblMost = new JLabel("Problem sa mostom gitare?");
	public String[] most = {"ne", "klimav", "hrapav (cesto pucaju zice)"};
	final JComboBox mostBox = new JComboBox(most);
	
	public JLabel lblIntonacija = new JLabel("Problem sa intonacijom?");
	public String[] intonacija = {"ne", "da"};
	final JComboBox intonacijaBox = new JComboBox(intonacija);
	
	public JLabel lblPotenciometar = new JLabel("Problem sa potenciometrom?");
	public String[] potenciometar = {"ne", "polomljen", "krci kada se okrece"};
	final JComboBox potenciometarBox = new JComboBox(potenciometar);
	
	public JLabel lblPrag = new JLabel("Problem sa pragom?");
	public String[] prag = {"ne", "ostecen > 30%", "ostecen < 30%"};
	final JComboBox pragBox = new JComboBox(prag);
	
	public JLabel lblVrat = new JLabel("Problem sa vratom?");
	public String[] vrat = {"ne", "kriv", "polomljen", "prljav", "suv i ostecen"};
	final JComboBox vratBox = new JComboBox(vrat);
	
	public JLabel lblCivija = new JLabel("Problem sa civijom?");
	public String[] civija = {"ne", "klimava", "pokvarena (ne namotava zicu)"};
	final JComboBox civijaBox = new JComboBox(civija);
	
	public JLabel lblMagnet = new JLabel("Problem sa magnetom?");
	public String[] magnet = {"ne", "necujan", "zuji", "tih", "glasan", "pokvaren"};
	final JComboBox magnetBox = new JComboBox(magnet);
	
	public JLabel lblNut = new JLabel("Problem sa nutom?");
	public String[] nut = {"ne", "polomljen", "suv (pucketanje zica)"};
	final JComboBox nutBox = new JComboBox(nut);
	
	public JLabel lblUlaz = new JLabel("Problem sa ulazom?");
	public String[] ulaz = {"ne", "klimav", "pokvaren"};
	final JComboBox ulazBox = new JComboBox(ulaz);
	
	public JLabel lblSvic = new JLabel("Problem sa svicem?");
	public String[] svic = {"ne", "polomljen", "pokvaren (ne menja magnet)"};
	final JComboBox svicBox = new JComboBox(svic);
	
	public JLabel lblDugme = new JLabel("Problem sa dugmetom?");
	public String[] dugme = {"ne", "klimavo", "fali (otpalo)"};
	final JComboBox dugmeBox = new JComboBox(dugme);
	
	public JButton resenje = new JButton("Prikazi resenje");
	public JButton obrisi = new JButton("Obrisi sve");
	public JTextArea textArea = new JTextArea();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GUI() {
		this.gitara = new Gitara();
		initialize();
	}
	public void Ks(Gitara gitara) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");
			FactHandle fh1;
			
			fh1 = kSession.insert(gitara);
			kSession.fireAllRules();
			
		}
		catch(Throwable t) {
			t.printStackTrace();
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Servis gitare");
		frame.setBounds(400, 10, 540, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblAkcija.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAkcija.setBounds(20, 20, 300, 20);
		panel.add(lblAkcija);
		akcijaBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		akcijaBox.setBounds(300, 20, 200, 20);
		panel.add(akcijaBox);
		
		lblZica.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblZica.setBounds(20, 50, 300, 20);
		panel.add(lblZica);
		zicaBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		zicaBox.setBounds(300, 50, 200, 20);
		panel.add(zicaBox);
		
		lblMost.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMost.setBounds(20, 80, 300, 20);
		panel.add(lblMost);
		mostBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mostBox.setBounds(300, 80, 200, 20);
		panel.add(mostBox);
		
		lblIntonacija.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIntonacija.setBounds(20, 110, 300, 20);
		panel.add(lblIntonacija);
		intonacijaBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		intonacijaBox.setBounds(300, 110, 200, 20);
		panel.add(intonacijaBox);
		
		lblPotenciometar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPotenciometar.setBounds(20, 140, 300, 20);
		panel.add(lblPotenciometar);
		potenciometarBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		potenciometarBox.setBounds(300, 140, 200, 20);
		panel.add(potenciometarBox);
		
		lblPrag.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrag.setBounds(20, 170, 300, 20);
		panel.add(lblPrag);
		pragBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pragBox.setBounds(300, 170, 200, 20);
		panel.add(pragBox);
		
		lblVrat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVrat.setBounds(20, 200, 300, 20);
		panel.add(lblVrat);
		vratBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vratBox.setBounds(300, 200, 200, 20);
		panel.add(vratBox);
		
		lblCivija.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCivija.setBounds(20, 230, 300, 20);
		panel.add(lblCivija);
		civijaBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		civijaBox.setBounds(300, 230, 200, 20);
		panel.add(civijaBox);
		
		lblMagnet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMagnet.setBounds(20, 260, 300, 20);
		panel.add(lblMagnet);
		magnetBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		magnetBox.setBounds(300, 260, 200, 20);
		panel.add(magnetBox);
		
		lblNut.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNut.setBounds(20, 290, 300, 20);
		panel.add(lblNut);
		nutBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nutBox.setBounds(300, 290, 200, 20);
		panel.add(nutBox);
		
		lblUlaz.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUlaz.setBounds(20, 320, 300, 20);
		panel.add(lblUlaz);
		ulazBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ulazBox.setBounds(300, 320, 200, 20);
		panel.add(ulazBox);
		
		lblSvic.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSvic.setBounds(20, 350, 300, 20);
		panel.add(lblSvic);
		svicBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		svicBox.setBounds(300, 350, 200, 20);
		panel.add(svicBox);
		
		lblDugme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDugme.setBounds(20, 380, 300, 20);
		panel.add(lblDugme);
		dugmeBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dugmeBox.setBounds(300, 380, 200, 20);
		panel.add(dugmeBox);
		
		textArea.setEditable(false);
		textArea.setBounds(20, 480, 480, 210);
		panel.add(textArea);
		
		resenje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				resi = "";
					// akcija
				if(akcijaBox.getSelectedItem().toString() == "ne" ) {
					gitara.setAkcija("dobra");
				}
				if(akcijaBox.getSelectedItem().toString() == "preniska i zice zuje") {
					gitara.setAkcija("preniska");
					gitara.setZica("zuji");
					Ks(gitara);
					resi += gitara.getAkcija_akcija1()+"\n";
				}
				if(akcijaBox.getSelectedItem().toString() == "previsoka i krivi vrat") {
					gitara.setAkcija("previsoka");
					Ks(gitara);
					resi += gitara.getAkcija_akcija2()+"\n";
				}
					// zica
				if(zicaBox.getSelectedItem().toString() == "ne") {
					gitara.setZica("dobra");
				}
				if(zicaBox.getSelectedItem().toString() == "pokidana") {
					gitara.setZica("pokidana");
					Ks(gitara);
					resi += gitara.getZica_akcija1()+"\n";
				}
				if(zicaBox.getSelectedItem().toString() == "zardjala") {
					gitara.setZica("zardjala");
					Ks(gitara);
					resi += gitara.getZica_akcija1()+"\n";
				}
					//most
				if(mostBox.getSelectedItem().toString() == "ne") {
					gitara.setMost("dobar");
				}
				if(mostBox.getSelectedItem().toString() == "klimav") {
					gitara.setMost("klimav");
					Ks(gitara);
					resi += gitara.getMost_akcija1()+"\n";
				}
				if(mostBox.getSelectedItem().toString() == "hrapav (cesto pucaju zice)") {
					gitara.setMost("hrapav");
					Ks(gitara);
					resi += gitara.getMost_akcija2()+"\n";
				}
					//intonacija
				if(intonacijaBox.getSelectedItem().toString() == "ne") {
					gitara.setIntonacija("dobra");
				}
				if(intonacijaBox.getSelectedItem().toString() == "da") {
					gitara.setIntonacija("losa");
					Ks(gitara);
					resi += gitara.getIntonacija_akcija1()+"\n";
				}
					//potenciometar
				if(potenciometarBox.getSelectedItem().toString() == "ne") {
					gitara.setPotenciometar("dobar");
				}
				if(potenciometarBox.getSelectedItem().toString() == "polomljen") {
					gitara.setPotenciometar("polomljen");
					Ks(gitara);
					resi += gitara.getPotenciometar_akcija1()+"\n";
				}
				if(potenciometarBox.getSelectedItem().toString() == "krci kada se okrece") {
					gitara.setPotenciometar("krci");
					Ks(gitara);
					resi += gitara.getPotenciometar_akcija2()+"\n";
				}
					//prag
				if(pragBox.getSelectedItem().toString() == "ne") {
					gitara.setPrag("dobar");
				}
				if(pragBox.getSelectedItem().toString() == "ostecen > 30%") {
					gitara.setPrag("ostecen>30%");
					Ks(gitara);
					resi += gitara.getPrag_akcija1()+"\n";
				}
				if(pragBox.getSelectedItem().toString() == "ostecen < 30%") {
					gitara.setPrag("ostecen<30%");
					Ks(gitara);
					resi += gitara.getPrag_akcija2()+"\n";
				}
					//vrat
				if(vratBox.getSelectedItem().toString() == "ne") {
					gitara.setVrat("dobar");
				}
				if(vratBox.getSelectedItem().toString() == "kriv") {
					gitara.setVrat("kriv");
					gitara.setAkcija("previsoka");
					Ks(gitara);
					resi += gitara.getVrat_akcija1()+"\n";
				}
				if(vratBox.getSelectedItem().toString() == "polomljen") {
					gitara.setVrat("polomljen");
					Ks(gitara);
					resi += gitara.getVrat_akcija2()+"\n";
				}
				if(vratBox.getSelectedItem().toString() == "prljav") {
					gitara.setVrat("prljav");
					Ks(gitara);
					resi += gitara.getVrat_akcija3()+"\n";
				}
				if(vratBox.getSelectedItem().toString() == "suv i ostecen") {
					gitara.setVrat("suv");
					Ks(gitara);
					resi += gitara.getVrat_akcija4()+"\n";
				}
					//civija
				if(civijaBox.getSelectedItem().toString() == "ne") {
					gitara.setCivija("dobra");
				}
				if(civijaBox.getSelectedItem().toString() == "klimava") {
					gitara.setCivija("klimava");
					Ks(gitara);
					resi += gitara.getCivija_akcija1()+"\n";
				}
				if(civijaBox.getSelectedItem().toString() == "pokvarena (ne namotava zicu)") {
					gitara.setCivija("pokvarena");
					Ks(gitara);
					resi += gitara.getCivija_akcija2()+"\n";
				}
					//magnet
				if(magnetBox.getSelectedItem().toString() == "ne") {
					gitara.setMagnet("dobar");
				}
				if(magnetBox.getSelectedItem().toString() == "necujan") {
					gitara.setMagnet("necujan");
					Ks(gitara);
					resi += gitara.getMagnet_akcija1()+"\n";
				}
				if(magnetBox.getSelectedItem().toString() == "zuji") {
					gitara.setMagnet("zuji");
					Ks(gitara);
					resi += gitara.getMagnet_akcija2()+"\n";
				}
				if(magnetBox.getSelectedItem().toString() == "tih") {
					gitara.setMagnet("tih");
					Ks(gitara);
					resi += gitara.getMagnet_akcija3()+"\n";
				}
				if(magnetBox.getSelectedItem().toString() == "glasan") {
					gitara.setMagnet("glasan");
					Ks(gitara);
					resi += gitara.getMagnet_akcija4()+"\n";
				}
				if(magnetBox.getSelectedItem().toString() == "pokvaren") {
					gitara.setMagnet("pokvaren");
					Ks(gitara);
					resi += gitara.getMagnet_akcija5()+"\n";
				}
					//nut
				if(nutBox.getSelectedItem().toString() == "ne") {
					gitara.setNut("dobar");
				}
				if(nutBox.getSelectedItem().toString() == "polomljen") {
					gitara.setNut("polomljen");
					Ks(gitara);
					resi += gitara.getNut_akcija2()+"\n";
				}
				if(nutBox.getSelectedItem().toString() == "suv (pucketanje zica)") {
					gitara.setNut("suv");
					Ks(gitara);
					resi += gitara.getNut_akcija1()+"\n";
				}
					//ulaz
				if(ulazBox.getSelectedItem().toString() == "ne") {
					gitara.setUlaz("dobar");
				}
				if(ulazBox.getSelectedItem().toString() == "klimav") {
					gitara.setUlaz("klimav");
					Ks(gitara);
					resi += gitara.getUlaz_akcija1()+"\n";
				}
				if(ulazBox.getSelectedItem().toString() == "pokvaren") {
					gitara.setMagnet("necujan");
					gitara.setUlaz("pokvaren");
					Ks(gitara);
					resi += gitara.getUlaz_akcija2()+"\n";
				}
					//svic
				if(svicBox.getSelectedItem().toString() == "ne") {
					gitara.setSvic("dobar");
				}
				if(svicBox.getSelectedItem().toString() == "polomljen") {
					gitara.setSvic("polomljen");
					Ks(gitara);
					resi += gitara.getSvic_akcija1()+"\n";
				}
				if(svicBox.getSelectedItem().toString() == "pokvaren (ne menja magnet)") {
					gitara.setSvic("pokvaren");
					Ks(gitara);
					resi += gitara.getSvic_akcija2()+"\n";
				}
					//dugme
				if(dugmeBox.getSelectedItem().toString() == "ne") {
					gitara.setDugme("dobro");
				}
				if(dugmeBox.getSelectedItem().toString() == "klimavo") {
					gitara.setDugme("klimavo");
					Ks(gitara);
					resi += gitara.getDugme_akcija1()+"\n";
				}
				if(dugmeBox.getSelectedItem().toString() == "fali (otpalo)") {
					gitara.setDugme("fali");
					Ks(gitara);
					resi += gitara.getDugme_akcija2()+"\n";
				}
				
				textArea.setText(resi);
			}
		});
		resenje.setBounds(300, 420, 200, 40);
		panel.add(resenje);
		
		obrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textArea.setText(null);
				resi = "";
				akcijaBox.setSelectedItem("ne");
				zicaBox.setSelectedItem("ne");
				mostBox.setSelectedItem("ne");
				intonacijaBox.setSelectedItem("ne");
				potenciometarBox.setSelectedItem("ne");
				pragBox.setSelectedItem("ne");
				vratBox.setSelectedItem("ne");
				civijaBox.setSelectedItem("ne");
				magnetBox.setSelectedItem("ne");
				nutBox.setSelectedItem("ne");
				ulazBox.setSelectedItem("ne");
				svicBox.setSelectedItem("ne");
				dugmeBox.setSelectedItem("ne");
			
		}});
		obrisi.setBounds(20, 420, 200, 40);
		panel.add(obrisi);
		
}
}