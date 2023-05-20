package efs.task.oop;

class Villager implements Fighter {
    private String name;
    private int age;
    private int health;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
        this.health = 100;
    }

    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public int getDamage() {
        return (int) ((100 - age * 0.5) / 10);
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit(getDamage());
    }

    @Override
    public void takeHit(int damage) {
        if(health - damage < 0) {
            health = 0;
        }
        else{
            health -= damage;
        }
    }

}
