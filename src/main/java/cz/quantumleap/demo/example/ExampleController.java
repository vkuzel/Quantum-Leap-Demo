package cz.quantumleap.demo.example;

import cz.quantumleap.admin.AdminController;
import cz.quantumleap.admin.menu.AdminMenuItemActive;
import cz.quantumleap.admin.menu.AdminMenuItemDefinition;
import cz.quantumleap.admin.menu.AdminMenuManager;
import cz.quantumleap.admin.notification.NotificationService;
import cz.quantumleap.admin.person.PersonService;
import cz.quantumleap.core.database.domain.FetchParams;
import cz.quantumleap.core.security.WebSecurityExpressionEvaluator;
import cz.quantumleap.core.view.DefaultDetailController;
import cz.quantumleap.core.view.DefaultListController;
import cz.quantumleap.core.view.DetailController;
import cz.quantumleap.core.view.ListController;
import cz.quantumleap.demo.example.domain.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class ExampleController extends AdminController {

    private static final String DETAIL_URL = "/example";
    private static final String DETAIL_VIEW = "demo/example";

    private static final String LIST_URL = "/examples";
    private static final String LIST_VIEW = "demo/examples";
    private static final String AJAX_LIST_VIEW = "admin/components/slice";

    private final DetailController<Example> detailController;
    private final ListController listController;

    public ExampleController(AdminMenuManager adminMenuManager, PersonService personService, NotificationService notificationService, WebSecurityExpressionEvaluator webSecurityExpressionEvaluator, ExampleService exampleService) {
        super(adminMenuManager, personService, notificationService, webSecurityExpressionEvaluator);
        this.detailController = new DefaultDetailController<>(Example.class, exampleService, DETAIL_URL, DETAIL_VIEW);
        this.listController = new DefaultListController(exampleService, LIST_VIEW, AJAX_LIST_VIEW, DETAIL_URL);
    }

    @AdminMenuItemActive("admin.menu.examples")
    @GetMapping(path = {DETAIL_URL, DETAIL_URL + "/{id}"})
    public String showExample(@PathVariable(required = false) Long id, Model model) {
        return detailController.show(id, model);
    }

    @PostMapping(params = "save", path = {DETAIL_URL, DETAIL_URL + "/{id}"})
    public String saveExample(@Valid Example example, Errors errors, Model model, RedirectAttributes redirectAttributes) {
        return detailController.save(example, errors, model, redirectAttributes);
    }

    @AdminMenuItemDefinition(title = "admin.menu.examples", fontAwesomeIcon = "fas fa-list")
    @GetMapping(LIST_URL)
    public String showExamples(FetchParams fetchParams, Model model, HttpServletRequest request) {
        return listController.list(fetchParams, model, request);
    }
}
