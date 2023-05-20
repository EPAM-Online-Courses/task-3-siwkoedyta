package efs.task.oop;
import java.util.Random;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
       Villager[] villArr = {
               new Villager("Kashya", 30),
               new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER),
               new Villager("Gheed", 50),
               new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY),
               new Villager("Warriv", 35),
               new Villager("Flawia", 25)
       };

       System.out.println();
       printVillagers(villArr);
       System.out.println();

       Object objectAkara = villArr[1];
       Object objectDeckardCain = villArr[3];


       int villager = 0;
       Monster attackingMonster;


       while (Monsters.monstersHealth > 0) {
           villager = chooseVillager(villArr);
           attackingMonster = chooseMonster();


           System.out.println("Aktualnie walczacy osadnik to " + villArr[villager].getName());
           villArr[villager].attack(attackingMonster);


           attackingMonster.attack(villArr[villager]);
           System.out.println(villArr[villager].getName() + " ma jeszcze: " + villArr[villager].getHealth() + " punktow zycia");
           System.out.println("Potwory posiadaja jeszcze " + Monsters.monstersHealth + " punktow zycia");
           System.out.println();
       }
       System.out.println("Obozowisko ocalone!\nPrzetrwali: ");
       for (Villager v : villArr) {
           if (v.getHealth() > 0)
               System.out.println(v.getName() + " ma " + v.getHealth() + " punktow zycia");
       }
       villArr[1] = (ExtraordinaryVillager) objectAkara;
       villArr[3] = (ExtraordinaryVillager) objectDeckardCain;

   }


   public static void printVillagers(Villager[] villArr) {
       for (Villager villager : villArr) {
           villager.sayHello();
       }
   }


   public static int chooseVillager(Villager[] villArr) {
       Random random = new Random();
       int villager = random.nextInt(villArr.length);

       if (checkIfAllDead(villArr)) {
           System.out.println("Wszyscy osadnicy sa martwi");
           System.exit(0);
       }
       while (villArr[villager].getHealth() == 0) {
           villager = random.nextInt(villArr.length);
       }
       return villager;
   }

   public static Monster chooseMonster() {
       Random random = new Random();
       int monster = random.nextInt(2);
       if (monster == 0) {
           if(Monsters.andariel.getHealth() == 0) {
               return Monsters.blacksmith;
           }
           return Monsters.andariel;
       } else {
           if(Monsters.blacksmith.getHealth() == 0) {
               return Monsters.andariel;
           }
           return Monsters.blacksmith;
       }
   }
   public static boolean checkIfAllDead(Villager[] villArr) {
       return Stream.of(villArr).allMatch(villager -> villager.getHealth() == 0);

    }

}
