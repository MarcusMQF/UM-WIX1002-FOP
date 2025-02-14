import java.util.Random;

// Hero Class
class Hero {
    String name, element;
    double hp, attack;

    // Constructor to initialize hero attributes
    Hero(String name, String element, double hp, double attack) {
        this.name = name;
        this.element = element;
        this.hp = hp;
        this.attack = attack;
    }

    // Calculate damage based on element dominance and runestone multiplier
    double calculateDamage(Villain enemy, int runestoneMultiplier) {
        double dominanceMultiplier = getDominanceMultiplier(this.element, enemy.element); //Argument
        double damage = this.attack * dominanceMultiplier * runestoneMultiplier - enemy.defense;
        return Math.max(damage, 1); // Ensure at least 1 damage is dealt
    }

    // Determine element dominance multiplier
    private double getDominanceMultiplier(String heroElement, String villainElement) { //Parameter
        // Water relationships
        if (heroElement.equals("Water") && villainElement.equals("Fire")) return 1.5; // Water -> Fire
        if (heroElement.equals("Water") && villainElement.equals("Earth")) return 0.5; // Water -> Earth
        
        // Fire relationships
        if (heroElement.equals("Fire") && villainElement.equals("Earth")) return 1.5; // Fire -> Earth
        if (heroElement.equals("Fire") && villainElement.equals("Water")) return 0.5; // Fire -> Water
        
        // Earth relationships
        if (heroElement.equals("Earth") && villainElement.equals("Water")) return 1.5; // Earth -> Water
        if (heroElement.equals("Earth") && villainElement.equals("Fire")) return 0.5; // Earth -> Fire
        
        // Light and Dark relationship
        if (heroElement.equals("Light") && villainElement.equals("Dark")) return 1.5; // Light <-> Dark
        if (heroElement.equals("Dark") && villainElement.equals("Light")) return 1.5; // Dark <-> Light
        
        return 1.0; // No dominance (same element or no relationship)
    }

    // Override toString() to display hero details
    @Override
    public String toString() {
        return "Name: " + name + "\nElement: " + element + "\nHP: " + hp + "\nAttack: " + attack;
    }
}

// Villain Class
class Villain {
    String name, element;
    double maxHp, hp, attack, defense;
    int initialCd, currentCd;

    // Constructor to initialize villain attributes
    Villain(String name, String element, double maxHp, double attack, double defense, int initialCd) {
        this.name = name;
        this.element = element;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.initialCd = initialCd;
        this.currentCd = initialCd;
    }

    // Reduce villain's HP after being attacked
    void getDamaged(double damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    // Reset villain's HP to max HP
    void resetHp() {
        hp = maxHp;
    }

    // Decrease villain's cooldown by 1
    void decreaseCd() {
        if (currentCd > 0) currentCd--;
    }

    // Reset villain's cooldown to initial value
    void resetCd() {
        currentCd = initialCd;
    }

    // Override toString() to display villain details
    @Override
    public String toString() {
        return "Name: " + name + ", Element: " + element + ", HP: " + hp + ", Attack: " + attack + ", Defense: " + defense + ", CD: " + currentCd;
    }
}

// Team Class
class Team {
    Hero[] deck;
    Hero[] heroList;
    double hp;

    // Constructor to initialize team with a deck of heroes
    Team(Hero[] deck) {
        this.deck = deck;
        this.heroList = new Hero[4];
        this.hp = 0;
    }

    // Randomly select 4 heroes from the deck and calculate team's total HP
    void formTeam() {
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = rand.nextInt(deck.length);
            heroList[i] = deck[randomIndex];
            hp += heroList[i].hp;
        }
    }

    // Reduce team's HP after being attacked
    void getDamaged(double damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    // Reset team's HP to the sum of selected heroes' HP
    void resetTeamHp() {
        hp = 0;
        for (Hero hero : heroList) {
            hp += hero.hp;
        }
    }

    // Override toString() to display team details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team's HP: ").append(hp).append("\n");
        for (int i = 0; i < heroList.length; i++) {
            sb.append("\nHero ").append(i + 1).append("\n").append(heroList[i]).append("\n");
        }
        return sb.toString();
    }
}

// Game Class
class Game {
    private Random rand = new Random();
    private String[] elements = {"Water", "Fire", "Earth", "Light", "Dark"};

    // Manage the battle between the team and the villain
    void battle(Team team, Villain enemy) {
        team.resetTeamHp();
        enemy.resetHp();
        enemy.resetCd();

        int round = 1;
        while (team.hp > 0 && enemy.hp > 0) {
            System.out.println("\nRound " + round); // Blank line before each round
            System.out.println("Enemy's current CD: " + enemy.currentCd);

            // Dissolve 3 runestones
            String[] runestones = new String[3];
            for (int i = 0; i < 3; i++) {
                runestones[i] = elements[rand.nextInt(elements.length)];
            }
            System.out.println("Runestones dissolved:");
            for (String runestone : runestones) {
                System.out.println("- " + runestone);
            }

            // Heroes attack based on runestones
            for (Hero hero : team.heroList) {
                int runestoneMultiplier = 0;
                for (String runestone : runestones) {
                    if (hero.element.equals(runestone)) {
                        runestoneMultiplier++;
                    }
                }
                if (runestoneMultiplier > 0) {
                    double damage = hero.calculateDamage(enemy, runestoneMultiplier);
                    enemy.getDamaged(damage);
                    System.out.println(hero.name + " dealt " + damage + " damage to " + enemy.name);
                }
            }

            // Villain attacks if cooldown is 1
            if (enemy.currentCd == 1 && enemy.hp > 0) {
                team.getDamaged(enemy.attack);
                System.out.println(enemy.name + " dealt " + enemy.attack + " damage to the team");
                enemy.resetCd();
            } else {
                enemy.decreaseCd();
            }

            // Display remaining HP and cooldown
            System.out.println("\nTeam's remaining HP: " + team.hp); // Blank line before HP
            System.out.println("Enemy's remaining HP: " + enemy.hp);

            round++;
        }

        // Determine the winner
        if (enemy.hp <= 0) {
            System.out.println("\nThe team won!");
        } else {
            System.out.println("\nThe team lose.");
        }
    }
}

// Test Program
public class viva3Q6 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Initialize heroes
        Hero molly = new Hero("Molly", "Water", 45, 20);
        Hero sean = new Hero("Sean", "Fire", 36, 24);
        Hero duncan = new Hero("Duncan", "Earth", 53, 16);
        Hero nathaniel = new Hero("Nathaniel", "Light", 37, 24);
        Hero endor = new Hero("Endor", "Dark", 43, 21);
        Hero urd = new Hero("Urd", "Water", 65, 17);
        Hero skuld = new Hero("Skuld", "Fire", 66, 16);
        Hero verthandi = new Hero("Verthandi", "Earth", 74, 13);
        Hero idun = new Hero("Idun", "Light", 59, 19);
        Hero valkyrie = new Hero("Valkyrie", "Dark", 61, 18);
        Hero poseidon = new Hero("Poseidon", "Water", 58, 19);
        Hero hephaestus = new Hero("Hephaestus", "Fire", 51, 22);
        Hero athena = new Hero("Athena", "Earth", 61, 18);
        Hero apollo = new Hero("Apollo", "Light", 55, 16);
        Hero artemis = new Hero("Artemis", "Dark", 50, 23);

        // Create array of all heroes
        Hero[] heroes = {molly, sean, duncan, nathaniel, endor, urd, skuld, 
                        verthandi, idun, valkyrie, poseidon, hephaestus, 
                        athena, apollo, artemis};

        // Initialize villains
        Villain giemsa = new Villain("Giemsa", "Water", 100, 150, 15, 2);
        Villain diablo = new Villain("Diablo", "Fire", 120, 163, 13, 3);
        Villain nidhogg = new Villain("Nidhogg", "Earth", 130, 189, 11, 4);
        Villain lucifer = new Villain("Lucifer", "Light", 110, 207, 17, 3);
        Villain odin = new Villain("Odin", "Dark", 135, 196, 14, 5);

        // Create team and game
        Team team = new Team(heroes);
        Game game = new Game();

        // Form team and display team info
        team.formTeam();
        System.out.println(team);

        // Start battle with Giemsa
        game.battle(team, giemsa);
    }
}