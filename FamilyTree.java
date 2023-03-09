package seminar3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import seminar3.comparator.HumanIterator;

public class FamilyTree implements Serializable,Iterable<Human>{
    private List<Human> familyTree;
    
    public FamilyTree() 
    {
        familyTree = new ArrayList<>();
    }
    
    public void addFamilyTree(Human human)
    {
        if (!familyTree.contains(human))
        {
            familyTree.add(human);
            if (human.getMother() != null)
            {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null)
            {
                human.getFather().addChild(human);
            }
        }
    }   

    @Override
    public String toString() 
    {
        String res = "В семье " + familyTree.size() + " человек:\n";
        for (int i = 0; i < familyTree.size(); i++) 
        {
            res += (i+1) + ") " + familyTree.get(i).toString() + "\n";
        }
        return res;
    }

    public Human getByName(String nameHuman)
    {
        for (Human human: familyTree)
        {
            if (human.getName().equalsIgnoreCase(nameHuman))
            {
                return human;
            }
        }
        return null;
    }

    public List<Human> getFamilyFree() 
    {
        return familyTree;
    }

    @Override
    public Iterator<Human> iterator() 
    {
        return new HumanIterator(familyTree);
    }
}

   

    
    
    
    
    
    
    
    
    
    

    

