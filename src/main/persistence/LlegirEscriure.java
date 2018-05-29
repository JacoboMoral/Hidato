package main.persistence;

public class LlegirEscriure {

    private static LlegirEscriure llegirEscriure;
    
    public static LlegirEscriure getInstance() {
        if (llegirEscriure == null)
            llegirEscriure = new LlegirEscriure();
        return llegirEscriure;
    }
    
    
}
