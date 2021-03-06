package cz.quantumleap.demo;

import cz.quantumleap.admin.dashboard.DashboardWidget;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class DashboardWidgetExample implements DashboardWidget {

    @Override
    public Position getPosition() {
        return Position.TOP;
    }

    @Override
    public String getThymeleafFragmentExpression() {
        return "demo/dashboard-widget-example::card";
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        List<Integer> model = new Random().ints(14, 5_000, 35_000).boxed().collect(Collectors.toList());
        return Collections.singletonMap("dashboardWidgetExample", model);
    }
}
