package familyTree;

import familyTree.familyTree.FamilyTree;
import familyTree.human.Gender;
import familyTree.human.Human;
import familyTree.fileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;


public class Main  {
public static void main(String[] args) {

FamilyTree tree = testTree();
System.out.println(tree);
fileHandler f1=new fileHandler();

// Сериализация объекта в файл

f1.serializeObject(tree, "person.out");

// Десериализация объекта из файла
FamilyTree treeRestored = (FamilyTree) f1.deserializeObject("person.out");
System.out.println(treeRestored);

}
static FamilyTree testTree() {
    FamilyTree tree = new FamilyTree();
    Human Sasha = new Human("Александр", Gender.Male, LocalDate.of(1976, 9, 19));
    Human Lena = new Human("Елена", Gender.Female, LocalDate.of(1987, 3, 1));
    tree.add(Sasha);
    tree.add(Lena);
    tree.setWedding(Sasha.getId(), Lena.getId());

    Human Nadya = new Human("Надежда", Gender.Female, LocalDate.of(2023, 12, 10), Sasha, Lena);
    Human Gena = new Human("Геннадий", Gender.Male, LocalDate.of(2022, 1, 14), Sasha, Lena);
    tree.add(Nadya);
    tree.add(Gena);

    Human Nina = new Human("Нина", Gender.Female, LocalDate.of(1942, 7, 8));
    tree.add(Nina);
    return tree;
}
    
}






