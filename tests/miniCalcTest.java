package view;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import models.ViewTransitionalModel;
import views.MainController;
import models.miniCalcModel;


@ExtendWith(ApplicationExtension.class)
public class miniCalcTest
{
	@Start //Before
	private void start(Stage stage)
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ViewTransitionalModel.class.getResource("../views/MainView.fxml"));
		try
		{
			Pane view = loader.load();
			MainController cont = loader.getController();
			cont.setModel(new miniCalcModel());
			
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void enterAmt(FxRobot robot, String numOne, String numTwo)
	{
		robot.clickOn("#numOneTextBox");
		robot.write(numOne);
		robot.clickOn("#numTwoTextBox");
		robot.write(numTwo);
		
		
	}
	
	private void checkResult(FxRobot robot, String Result)
	{
		try
		{
			Thread.sleep(10);
			Assertions.assertThat(robot.lookup("#resultLabelBox")
					.queryAs(Label.class)).hasText(Result);
			Thread.sleep(10);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void checkAdd(FxRobot robot,String before, String numOne,String numTwo, String after)
	{
		checkResult(robot,before);
		enterAmt(robot, numOne, numTwo);
		robot.clickOn("#addButton");
		checkResult(robot, after);
	}
	
	private void checkSubtract(FxRobot robot,String before, String numOne,String numTwo, String after)
	{
		checkResult(robot,before);
		enterAmt(robot, numOne, numTwo);
		robot.clickOn("#subtractButton");
		checkResult(robot, after);
	}
	
	private void checkMultiply(FxRobot robot,String before, String numOne,String numTwo, String after)
	{
		checkResult(robot,before);
		enterAmt(robot, numOne, numTwo);
		robot.clickOn("#multiplyButton");
		checkResult(robot, after);
	}
	
	private void checkDivide(FxRobot robot,String before, String numOne,String numTwo, String after)
	{
		checkResult(robot,before);
		enterAmt(robot, numOne, numTwo);
		robot.clickOn("#divideButton");
		checkResult(robot, after);
	}
	public void testAdd(FxRobot robot)
	{
		checkAdd(robot, "0", "12","15", "27");
		checkAdd(robot, "27", "23","42", "65");
		checkAdd(robot, "65", "50","-25", "25");
		
	}
	public void testSubtract(FxRobot robot)
	{
		checkSubtract(robot, "25", "50","25", "25");
		checkSubtract(robot, "25", "20","25", "-5");
		checkSubtract(robot, "-5", "12", "3.5","8.5");
		
	}
	
	public void testMultiply(FxRobot robot)
	{
		checkMultiply(robot, "8.5", "5","2", "10");
		checkMultiply(robot, "10", "20","4", "80");
		checkMultiply(robot, "80", "12", ".25","3");
		
	}
	
	public void testDivide(FxRobot robot)
	{
		checkDivide(robot, "3", "20","5", "4");
		checkDivide(robot, "4", "60","3", "20");
		checkDivide(robot, "20", "4", ".25","16");
		
	}
	
	@Test
	public void testInterWeave(FxRobot robot)
	{
		testAdd(robot);
		testSubtract(robot);
		testMultiply(robot);
		testDivide(robot);
	}
	
	
	
}
