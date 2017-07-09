package listeners;

import org.testng.*;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.TestCaseResult;
import testNames.TestNames;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;
import static utils.Screenshot.takeScreenshotFullPage;

/**
 * Created by AnatolyRogov on 17.06.17.
 */
public class TestListeners implements ITestListener, IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if(iInvokedMethod.isTestMethod()){
            try {
                if (hasWebDriverStarted())
                    takeScreenshotFullPage("Last step screenshot");
            } finally {
                if(hasWebDriverStarted()) {
                    getWebDriver().close();
                    getWebDriver().quit();
                }
            }
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        onTestFinish(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        onTestFinish(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        onTestFinish(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    public void onTestFinish(ITestResult result){
        if(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestNames.class) != null){
            TestNames names = result
                    .getMethod()
                    .getConstructorOrMethod()
                    .getMethod()
                    .getAnnotation(TestNames.class);

            if(names != null && names.value() != null){
                Allure.LIFECYCLE.fire(new TestCaseEvent() {
                    @Override
                    public void process(TestCaseResult testCaseResult){
                        testCaseResult.setTitle(names.value().toString());
                    }
                });
            }
        }
    }
}
