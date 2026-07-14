package br.com.supermercado.tests.report.listener;

import br.com.supermercado.tests.report.ReportManager;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;

public class ReportExecutionListener implements TestExecutionListener {


    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {

        System.out.println(
                "Gerando relatório final..."
        );

        ReportManager.gerarHTML();
    }
}