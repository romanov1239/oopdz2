package familyTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class fileHandler implements Writable{

   // Метод для сериализации объекта в файл
@Override
   public  void serializeObject(Serializable object, String fileName) {
   try {
   ObjectOutputStream objectOutputStream = new ObjectOutputStream(
   new FileOutputStream(fileName));
   objectOutputStream.writeObject(object);
   objectOutputStream.close();
   } catch (IOException e) {
   e.printStackTrace();
   }
   }
   
   // Метод для десериализации объекта из файла
   @Override
   public  Object deserializeObject(String fileName) {
   try {
   ObjectInputStream objectInputStream = new ObjectInputStream(
   new FileInputStream(fileName));
   Object object = objectInputStream.readObject();
   objectInputStream.close();
   return object;
   } catch (IOException | ClassNotFoundException e) {
   e.printStackTrace();
   return null;
   }
   }

}