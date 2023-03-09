package seminar3;

import java.io.Serializable;
import java.util.List;

public class Human implements Serializable, Comparable<Human>{
    private String name;
    private String gender;
    private int age;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, String gender, int age) {
        this(name, gender, age, null, null);
    }

    public Human(String name, String gender, int age, Human father, Human mother) {
        this.name  = name;
        this.gender = gender;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }


    public void addChild(Human child)
    {
        this.children.add(child);
        if(this.gender == "муж.")
        {
            child.father = this;
        }
        else child.mother = this;
    }

    public String printChildren() 
    {
        String res = " Дети: ";     
        if (!this.children.isEmpty())
        {
            for (int i = 0; i < children.size(); i++) 
            {
                res += children.get(i).name + ",";
            }
        }
        else res += " нет";
        return res;
    }
    
    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age) 
    {
        this.age = age;
    }

    public Human getFather(){
        return father;
    }
    public Human getMother(){
        return mother;
    }
    public List<Human> getChildren(){ 
        return children; 
    }
    public String getGender(){ 
        return gender; 
    }
    
    
    

    

    @Override
    public String toString() {
        String result = "Имя: " + name +  "," + "Возраст: " + age;
        if (this.father != null){
            result += "," + "Отец: " + father;
        } else {
            result += "," + "Отец: неизвестен";
        }
        if (this.mother != null){
            result += "," + "Мать: " + mother;
        } else {
            result += "," + "Мать: неизвестна";
        }
        result += printChildren();
        
        return result;
        
    }

    public void saveObj(IO save)
    {
        save.save("FreeFamily.data", this);
    }

    @Override
    public int compareTo(Human o) 
    {
        return name.compareToIgnoreCase(o.name);
    }

   
}