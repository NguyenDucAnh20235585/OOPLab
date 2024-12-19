package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class CartScreenController {

    private Cart cart;
    private ControllerScreen controllerScreen;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Label totalCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label playingMedia;

    @FXML
    private Button btnStop;

    @FXML
    private Button btnOrder;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private TextField tfFilter;

    public CartScreenController(Cart cart, ControllerScreen controllerScreen) {
        this.cart = cart;
        this.controllerScreen = controllerScreen;
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void showFilterMedia(String searchString) {
        FilteredList<Media> filteredList;
        if (radioBtnFilterId.isSelected()) {
            filteredList = new FilteredList<>(this.cart.getItemsOrdered(), item -> item.getId() == Integer.parseInt(searchString));
        } else {
            filteredList = new FilteredList<>(this.cart.getItemsOrdered(), item -> item.getTitle().contains(searchString));
        }
        tblMedia.setItems(filteredList);
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        tblMedia.setItems(this.cart.getItemsOrdered());
        totalCost.setText(this.cart.totalCost() + "$");
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        playingMedia.setVisible(false);
        btnStop.setVisible(false);

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilterMedia(newValue));
        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updateButtonBar(newValue);
                totalCost.setText(cart.totalCost() + "$");
            }
        });
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            totalCost.setText(cart.totalCost() + "$");
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            playingMedia.setText("Playing " + media.getTitle() + "....");
            playingMedia.setVisible(true);
            btnStop.setVisible(true);
        }
    }

    @FXML
    void btnStopPressed(ActionEvent event) {
        playingMedia.setVisible(false);
        btnStop.setVisible(false);
    }

    @FXML
    void btnOrderPressed(ActionEvent event) {
        cart.getItemsOrdered().clear();
        totalCost.setText("0.0$");
        btnOrder.setText("Success!!!");
        btnOrder.setDisable(true);

        PauseTransition pt = new PauseTransition(Duration.seconds(1));
        pt.setOnFinished(e -> {
            btnOrder.setDisable(false);
            btnOrder.setText("Order");
        });
        pt.playFromStart();
    }

    @FXML
    void changeToStoreScreen(ActionEvent event) {
        controllerScreen.showStoreScreen();
    }

    @FXML
    void changeToAddBookScreen(ActionEvent event) {
        controllerScreen.showAddBookScreen();
    }

    @FXML
    void changeToAddCDScreen(ActionEvent event) {
        controllerScreen.showAddCDCreen();
    }

    @FXML
    void changeToAddDVDScreen(ActionEvent event) {
        controllerScreen.showAddDVDScreen();
    }

    @FXML
    void changeToCartScreen(ActionEvent event) {
        controllerScreen.showCartScreen();
    }

    @FXML
    void updateFilter(InputMethodEvent event) {
        System.out.println(event.toString());
    }
}
