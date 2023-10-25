public class RgbToHex {

    public static String rgb(int r, int g, int b) {
      return String.format("%02X%02X%02X", round(r), round(g), round(b)); //Rgb To XXXXXX conversion. If hashtag infront is wanted add # before the first %
    }
  
    public static int round(int n) {
      if(n < 0) {
        return 0;
      } 
      if(n > 255) {
        return 255;
      }
      return n;
    }
}
