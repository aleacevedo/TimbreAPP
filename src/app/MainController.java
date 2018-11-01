package app;

import app.Horarios.MisHorarios;
import app.Timbres.MisTimbres;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController{

    @FXML
    private ListView horariosUsuariosView;
    @FXML
    private ListView horariosTimbreView;
    @FXML
    private ComboBox misTimbresView;

    private MisTimbres misTimbres = new MisTimbres();
    private MisHorarios misHorarios = new MisHorarios();

    public MainController(Stage primaryStage)throws IOException {
        this.loadView(primaryStage);
        this.horariosUsuariosView.setItems(this.misHorarios.getView());
        this.horariosTimbreView.setItems(this.misTimbres.getMisHorarios().getView());
        this.misTimbresView.setItems(this.misTimbres.getView());
    }

    public void mostrarAgregarHorariosView(ActionEvent actionEvent) throws IOException{
        new AgregarHorariosController(this.misHorarios);
    }

    public void mostragarModificarTimbresView(ActionEvent actionEvent) throws  IOException{
        new ModificarTimbresController(this.misTimbres);
    }

    private void loadView(Stage stage)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("Controlador de Timbres");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }


}
