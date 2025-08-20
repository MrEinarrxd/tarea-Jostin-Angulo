package business.GuiControllers;

import business.ListController;
import business.UsersController;
import presentation.MainBottunGui;

public class GuiController {
    private UsersController userController = new UsersController();
    private MainBottunGui view;
    private AddController addController;
    private ListController listController;
    private FindController findController;

    public GuiController() {
        this.view = new MainBottunGui();
        this.addController = new AddController(userController);
        this.findController = new FindController(userController);
        this.listController = new ListController(userController);
    }

    @SuppressWarnings("unused")
    public void start() {
        view.getBtnAddUser().addActionListener(e -> {
            addController.showMenu();
        });
        view.getBtnUserList().addActionListener(e -> {
            listController.showMenu();
        });
        view.getBtnUserFind().addActionListener(e -> {
            findController.chooseMenuOption();
        });
        view.init();
    }
}


