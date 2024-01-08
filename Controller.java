import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener {

    private Model model;

    public Controller(Viewer view) {
        model = new Model(view);
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        model.doAction(command);
    }
}
