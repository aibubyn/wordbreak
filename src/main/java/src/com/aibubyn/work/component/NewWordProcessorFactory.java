package src.com.aibubyn.work.component;

public class NewWordProcessorFactory implements INewWordProcessorFactory {
    private static NewWordProcessorFactory instance = new NewWordProcessorFactory();

    public static NewWordProcessorFactory getInstance() {
        return instance;
    }

    private NewWordProcessorFactory() {

    }

    @Override
    public INewWordProcessor getNewWordProcessor() {
        return new NewWordProcessor();
    }
}
