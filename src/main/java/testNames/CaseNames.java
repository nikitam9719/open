package testNames;

/**
 * Created by AnatolyRogov on 18.06.17.
 */
public enum  CaseNames {
    CN_000("Название кейса"),
    CN_001("Название кейса2"),
    CN_002("Cucumber")
    ;

    final private String name;

    CaseNames(final String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
