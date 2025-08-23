package business.GuiControllers;

import business.ListController;
import business.UsersController;
import presentation.MainBottunGui;

public class GuiController {
    private UsersController userController = new UsersController();
    private MainBottunGui view;
    private AddController addController;
    private ListController listController;
    private FilterController fillterController;

    public GuiController() {
        this.view = new MainBottunGui();
        this.addController = new AddController(userController);
        this.fillterController = new FilterController(userController);
        this.listController = new ListController(userController);
    }
     @SuppressWarnings("unused")
    public void start() {
        view.getBtnContinue().addActionListener(e -> {
            int selected = view.getComboBox().getSelectedIndex();
            switch (selected) {
                case 0:
                    addController.showMenu();
                    break;
                case 1:
                    listController.showMenu();
                    break;
                case 2:
                    fillterController.showMenu();
                    break;
                default:
                    break;
            }
        });
        view.init();
    }
}


