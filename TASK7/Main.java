package TASK7;

import TASK7.logger.Decorator;
import TASK7.logger.LoggerTerminal;
import TASK7.controllers.UserController;
import TASK7.model.FileOperation;
import TASK7.model.FileOperationImpl;
import TASK7.model.Repository;
import TASK7.model.RepositoryFile;
import TASK7.utils.Validate;
import TASK7.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("TASK7/users.txt");
        // Repository repository = new RepositoryFile(fileOperation);
        Repository repository = new Decorator(new RepositoryFile(fileOperation), new LoggerTerminal());
        Validate validate = new Validate();
        UserController controller = new UserController(repository, validate);
        ViewUser view = new ViewUser(controller, validate);

        view.run();
    }
}