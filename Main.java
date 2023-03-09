package seminar3;
import seminar3.comparator.HumanComparatorByAge;

public class Main{
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human alex = new Human("Александр", "муж.", 35);

        Human anne = new Human("Аннет", "жен.", 18);
        Human mary = new Human("Мария", "жен.", 17);
        Human kate = new Human("Кейт", "жен.", 15);
        alex.addChild(mary);
        alex.addChild(anne);
        alex.addChild(kate);
        System.out.println(alex);               
        
        
        Human siri = new Human("Сири", "жен.", 29);
        Human alice = new Human("Алиса", "жен.", 17);
        siri.addChild(alice);

        System.out.println(siri);
        System.out.println(alice);

        alice.setAge(27);
        Human mika = new Human("Мика", "жен.", 5);
        alice.addChild(mika);
        System.out.println(alice);

        IO save = new IO();     
        alex.saveObj(save);     
        save.load("TreeFamily.data"); 

        
        System.out.println(familyTree);

        System.out.println("\nСортировка по имени=>");
        FamilyTree.getFamilyTree().sort(null);
        for (Human human : FamilyTree.getFamilyTree()) 
        {
             System.out.println(human); 
        }
        
        System.out.println("\nСортировка по возрасту=>");
        FamilyTree.getFamilyTree().sort(new HumanComparatorByAge());

        for (Human human : FamilyTree.getFamilyTree()) 
        {
             System.out.println(human);
        }
       
    }
}