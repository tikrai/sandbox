// "src/main/resources/migrations/test/dogs.sql"

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CmdExec {

  public static void main(String argv[]) {

    String s;
    StringBuilder sb = new StringBuilder();
    FileReader fr = null;
    try {
      fr = new FileReader(new File("src/main/resources/migrations/test/dogs.sql"));

      BufferedReader br = new BufferedReader(fr);

      while((s = br.readLine()) != null)
      {
        sb.append(s);
      }
      br.close();

      System.out.println(sb);

      // here is our splitter ! We use ";" as a delimiter for each request
      // then we are sure to have well formed statements
      String[] inst = sb.toString().split(";");

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    // be sure to not have line starting with "--" or "/*" or any other non aplhabetical character



  }
}