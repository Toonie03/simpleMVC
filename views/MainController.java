package views;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import models.ViewTransitionalModel;
import models.ViewTransitionalModelInterface;
import models.miniCalcModel;
import javafx.util.converter.*;
public class MainController
{
    	@FXML
    	private TextField numOneTextField;

    	@FXML
    	private TextField numTwoTextField;
    	
    	@FXML
    	private Label resultTextField;
		miniCalcModel model;
		public void setModel(miniCalcModel newModel)
		{
			model = newModel;
			StringConverter<Number> fmt = new NumberStringConverter();
			Bindings.bindBidirectional(numOneTextField.textProperty(), 
					model.getNumOne(), fmt);
			Bindings.bindBidirectional(numTwoTextField.textProperty(), 
					model.getNumTwo(), fmt);
			Bindings.bindBidirectional(resultTextField.textProperty(),
					model.getResult(), fmt);
	    	numOneTextField.textProperty().set("");
	    	numTwoTextField.textProperty().set("");
		}
	
	    @FXML
	    void onClickAdd(ActionEvent event) 
	    {
	    	model.add();
	    	numOneTextField.textProperty().set("");
	    	numTwoTextField.textProperty().set("");
	    }

	    @FXML
	    void onClickSubtract(ActionEvent event) 
	    {
	    	model.subtract();
	    	numOneTextField.textProperty().set("");
	    	numTwoTextField.textProperty().set("");
	    }
	    
	    @FXML
	    void onClickMultiply(ActionEvent event) 
	    {
	    	model.multiply();
	    	numOneTextField.textProperty().set("");
	    	numTwoTextField.textProperty().set("");
	    }
	    
	    @FXML
	    void onClickDivide(ActionEvent event) 
	    {
	    	model.divide();
	    	numOneTextField.textProperty().set("");
	    	numTwoTextField.textProperty().set("");
	    }
	    

}
