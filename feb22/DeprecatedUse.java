package feb22;
class LegacyAPI {
    // when we call this function it given waring also
    // like when we use the old feature of Node .js

    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. It should not be used anymore.");
    }
    
   
    public void newFeature() {
        System.out.println("This is the new feature. Please use this instead.");
    }
}



public class DeprecatedUse {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        
        // Calling the deprecated method (should show a warning)
        api.oldFeature();
        
        // Calling the new method
        api.newFeature();
    }
}
