import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    public TextField textInput;
    public Label messageLabel;
    public Button saveBtn;
    public Button clearBtn;

    @FXML
    void initialize() {
        saveBtn.setOnMouseClicked((event) -> {
            System.out.println("Message for input: " + textInput.getText());
            messageLabel.setText("Data Saved");
            this.setTimeout(() -> messageLabel.setText(""), 3000);
        });

        clearBtn.setOnMouseClicked((event) -> {
            textInput.setText("");
            messageLabel.setText("Message field was cleaned");
            this.setTimeout(() -> messageLabel.setText(""), 2000);
        });
    }

    // helper to avoid code duplication
    private void setTimeout(Runnable callback, int timeout) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(callback);
            }
        }, timeout);
    }
}
