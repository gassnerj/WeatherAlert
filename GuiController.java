package weatheralert;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GuiController implements Initializable {
    @FXML private TableView<Alert> tableView;
    @FXML private TableColumn<Alert, String> UserId; //TODO update column name
    @FXML private TableColumn<Alert, String> UserName;
    @FXML private TableColumn<Alert, String> Active;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserId.setCellValueFactory(new PropertyValueFactory<Alert, String>("id"));
        UserName.setCellValueFactory(new PropertyValueFactory<Alert, String>("name"));
        Active.setCellValueFactory(new PropertyValueFactory<Alert, String>("active"));

        tableView.getItems().setAll(parseUserList());
    }
    private List<Alert> parseUserList(){
		return null;
        // parse and construct User datamodel list by looping your ResultSet rs
        // and return the list
    }


}
