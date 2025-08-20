package business.GuiControllers;

import business.UsersController;
import presentation.MainBottunGui;

public class GuiController {
    private UsersController userController = new UsersController();
    private MainBottunGui view;
    private AddController addController;
    private ListController listController;
    private FilterController findController;

    public GuiController() {
        this.view = new MainBottunGui();
        this.addController = new AddController(userController);
        this.findController = new FilterController(userController);
        this.listController = new ListController(userController);
    }
     @SuppressWarnings("unused")
    public void start() {
        view.getBtnContinue().addActionListener(e -> {
            int selected = view.getComboBox().getSelectedIndex();
            switch (selected) {
                case 0: addController.showMenu(); break;
                case 1: listController.showMenu(); break;
                case 2: findController.chooseMenuOption(); break;
            }
        });
        view.init();
    }
}


