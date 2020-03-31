package it.polito.tdp.spellchecker;
import java.awt.Label;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;


public class FXMLController {
	Dictionary diz;
	List<RichWord> l =new LinkedList<>();
	
	private ObservableList<String> list=FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> txtChoice;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtParole;

    @FXML
    private TextArea txtParolesb;

    @FXML
    private Label lblRisultato;

    @FXML
    private Label lblTempo;

    @FXML
    private Button btnClear;
    @FXML
    void doClearText(ActionEvent event) {
    	
    
        txtParole.clear();
        txtParolesb.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
   
    	long inizio = System.nanoTime();
    	String s =" ";
    	
    	String testo = txtParole.getText ();
    	if(txtChoice.getValue().equals("English"))
    		this.diz.loadDictionary("src/main/resources/English.txt" );
    	else
    		this.diz.loadDictionary("src/main/resources/Italian.txt" );
    	l.addAll(this.diz.spellCheckText(testo));
    	for(RichWord rw:l) {
			if (rw.isParolag()==false) {
				if (rw.equals(" "))
					s=rw.getParola();
				else
					s+="\n"+rw.getParola();
			}
		}
    	if (l.size()==0)
    		lblRisultato.setText( " Il testo non contiene errori " );
    	else{
    		txtParolesb.appendText(s);
    		lblRisultato.setText( " Il testo contiene "  + l.size () +  " errori " );
    	}
    	long finito =System.nanoTime ();
    	lblTempo.setText( " " + (finito-inizio));
    }

    

    @FXML
    void initialize() {
    	  assert txtChoice != null : "fx:id=\"txtChoice\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtParolesb != null : "fx:id=\"txtParolesb\" was not injected: check your FXML file 'Scene.fxml'.";
          assert lblRisultato != null : "fx:id=\"lblRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
          assert lblTempo != null : "fx:id=\"lblTempo\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
     // list.addAll("English","Italian");
        txtChoice.setItems(list);
        txtChoice.setValue("Italian");
        txtChoice.setValue("English");
        diz=new Dictionary();
    }
}


