 package is.L42.connected.withHtml;

import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import org.junit.After;
import org.junit.Test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import repl.HtmlFx;

public class TestWebEngine {
  @After
  public void tearDown() throws InterruptedException {
     Thread.sleep(10000);
  }
  @Test
  public void test() throws InvocationTargetException, InterruptedException,FileNotFoundException {
    //@SuppressWarnings("resource")
    //String content = new Scanner(new File("htmlTests/tutorial.xhtml")).useDelimiter("\\Z").next();
    new JFXPanel();
    Platform.runLater(()->new TestFXClass().start(new Stage()));
  }

  public static class TestFXClass extends Application {

    @Override
    public void start(Stage stage) {
      HtmlFx h=new HtmlFx(new Pane());
      URL url = getClass().getResource("tutorial.xhtml");
      h.createHtmlContent(new CountDownLatch(1), wv->wv.load(url.toExternalForm()));

      Scene scene = new Scene(h, 500, 500);
      stage.setTitle("myTitle!");
      stage.setScene(scene);
      stage.show();
    }
  }

}


