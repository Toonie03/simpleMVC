import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.ViewTransitionalModel;
import models.miniCalcModel;
import views.MainController;

public class Main extends Application
{

	@Override
	public void start(Stage stage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/MainView.fxml"));
		BorderPane view = loader.load();
		MainController cont = loader.getController();
		miniCalcModel mc = new miniCalcModel();
		ViewTransitionalModel vm = new ViewTransitionalModel(view,mc);
		cont.setModel(mc);
		
		
		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();
		
		

	}

	public static void main(String[] args)
	{
		launch(args);
	}
	
	
}
