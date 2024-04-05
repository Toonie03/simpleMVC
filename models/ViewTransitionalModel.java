package models;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import views.MainController;
public class ViewTransitionalModel implements ViewTransitionalModelInterface
{

	BorderPane mainview;
	miniCalcModel model;
	
	public ViewTransitionalModel(BorderPane view, miniCalcModel newModel)
	{
		mainview = view;
		model = newModel;
	}
	
	@Override
	@FXML
	public void showResult()
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("../views/MainView.fxml"));
		try
		{
			Pane view = loader.load();
			mainview.setCenter(view);
			MainController cont = loader.getController();
			cont.setModel(model);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
