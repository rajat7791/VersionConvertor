package versionconvertor;

/**
 *
 * @author rajat
 */
public class VersionConvertor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //calling versionToLong method
        versionToLong("1.4.4");
        
        //calling longValueToVersion method
        longValueToVersion(66307);
        
    }

    public static long versionToLong(String version) {
        /**
         * Version must be '1.2.3' format means 2 dot exactly
         */
        long result = 0;
        String[] versionArr = version.split("\\.");
        if (versionArr.length != 3) {
            throw new NumberFormatException("Version should be of format x.y.z");
        }
        for (int i = 2; i >= 0; i--) {
            long versionNum = Long.parseLong(versionArr[2 - i]);
            //left shifting 16,8,0 and bitwise OR
            //1. 1 << 16
            //2. 2   << 8
            //3. 3   << 0
            result |= versionNum << (i * 8);
        }
        System.out.println("Version: " + version + " | LongValue: " + result);
        return result;
    }
    
    public static String longValueToVersion(long versionNum) {
        String result = ((versionNum >> 16) & 0xFF) + "."
                + ((versionNum >> 8) & 0xFF) + "."
                + (versionNum & 0xFF);

        System.out.println("LongValue: " + versionNum + " | Version: " + result);
        return result;
    }

}
