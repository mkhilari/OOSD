import bagel.*;
import java.util.ArrayList;

/**
 * Level1 created and updated by Flappy Bird game ShadowFlap 
 * @author Manish Khilari 
 */
public class Level1 extends Level {

    private final Image steelPipeImage = new Image("res/level-1/steelPipe.png");
    private final Image flameImage = new Image("res/level-1/flame.png");
    private final Image bombImage = new Image("res/level-1/bomb.png");
    private final Image rockImage = new Image("res/level-1/rock.png");

    public static final int BIRD_HEALTH_L1 = 6;

    // Flame frames for better FPS 
    public static final int FLAME_UP_TIME = 3;
    public static final int FLAME_DOWN_TIME = 20;

    public static final int WEAPON_SPAWN_TIME = 50;
    public static final int WEAPON_SPAWN_START = 150;

    public static final Point WEAPON_VELOCITY = new Point(5, 0);

    private ArrayList<Weapon> weapons = new ArrayList<>();

    private int timeSinceWeaponSpawn = 0;

    /**
     * Creates a new Level1 
     * @param endScore The end score to win the level 
     * @param background The background of the level 
     * @param birdWingUp The bird wing up image of the level 
     * @param birdWingDown The bird wing down image of the level 
     */
    public Level1(int endScore, Image background, 
    Image birdWingUp, Image birdWingDown) {

        super(endScore, background, birdWingUp, birdWingDown);

        this.spawnBird(BIRD_HEALTH_L1, birdWingDown);
    }

    /**
     * Returns timeSinceWeaponSpawn 
     * @return timeSinceWeaponSpawn 
     */
    public int getTimeSinceWeaponSpawn() {
        return this.timeSinceWeaponSpawn;
    }

    /**
     * Returns level specific maxHealth 
     * @return level specific maxHealth 
     */
    @Override 
    public int getMaxHealth() {
        return BIRD_HEALTH_L1;
    }

    /**
     * Sets timeSinceWeaponSpawn 
     * @param timeSinceWeaponSpawn The new value 
     */
    public void setTimeSinceWeaponSpawn(int timeSinceWeaponSpawn) {
        this.timeSinceWeaponSpawn = timeSinceWeaponSpawn;
    }

    /**
     * Updates and draws the level 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    @Override 
    public void update(double moveBoost) {

        this.setTimeSinceWeaponSpawn(this.getTimeSinceWeaponSpawn() + 1);

        super.update(moveBoost);

        this.spawnWeapons(moveBoost);

        this.weaponCollision();
    }

    /**
     * Spawns both plastic and steel pipes active in the level 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    @Override 
    public void spawnPipes(double moveBoost) {

        if (this.getTimeSincePipeSpawn() 
        < ((double) PIPE_SPAWN_TIME) / moveBoost) {

            return;
        } 

        this.setTimeSincePipeSpawn(0);

        // Create pipes for L1 

        // Get random pipe type 
        double randPipeType = Math.random();

        // Get random pipe Y 
        double randPipeY = PIPE_MIN_Y + 
        (PIPE_MAX_Y - PIPE_MIN_Y) * Math.random();

        // Get pipe height 
        double pipeHeight;

        if (randPipeType < 1 / ((double) 2)) {

            // Get steel pipe height 
            pipeHeight = steelPipeImage.getHeight();
        } else {

            // Get plastic pipe height 
            pipeHeight = plasticPipeImage.getHeight();
        }

        // Get top pipe position 
        double topPipeX = Window.getWidth();
        double topPipeY = randPipeY 
        - pipeHeight;

        Point topPipePosition = new Point(topPipeX, topPipeY);

        // Get bottom pipe position 
        double bottomPipeX = Window.getWidth();
        double bottomPipeY = randPipeY + 
        PIPE_GAP.getY();

        Point bottomPipePosition = new Point(bottomPipeX, 
        bottomPipeY);

        Pipe newTopPipe;
        Pipe newBottomPipe;

        if (randPipeType < 1 / ((double) 2)) {
            
            // Spawn steel pipes 
            newTopPipe = new SteelPipe(new Point(topPipePosition), 
            new Point(PIPE_VELOCITY), 
            new Point(PIPE_ACCELERATION), 
            1, steelPipeImage, true, flameImage, 
            FLAME_UP_TIME, FLAME_DOWN_TIME);

            newBottomPipe = new SteelPipe(new Point(bottomPipePosition), 
            new Point(PIPE_VELOCITY), 
            new Point(PIPE_ACCELERATION), 
            1, steelPipeImage, false, flameImage, 
            FLAME_UP_TIME, FLAME_DOWN_TIME);
        } else {

            // Spawn plastic pipes 
            newTopPipe = new PlasticPipe(new Point(topPipePosition), 
            new Point(PIPE_VELOCITY), 
            new Point(PIPE_ACCELERATION), 
            1, plasticPipeImage, true);

            newBottomPipe = new PlasticPipe(new Point(bottomPipePosition), 
            new Point(PIPE_VELOCITY), 
            new Point(PIPE_ACCELERATION), 
            1, plasticPipeImage, false);
        }

        // Add new pipes 
        this.topPipes.add(newTopPipe);
        this.bottomPipes.add(newBottomPipe);

        // Set pair pipes 
        newTopPipe.setPairPipe(newBottomPipe);
        newBottomPipe.setPairPipe(newTopPipe);
    }

    /**
     * Spawns weapons active in the level 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    public void spawnWeapons(double moveBoost) {
        
        if (this.getTimeSinceWeaponSpawn() 
        < ((double) WEAPON_SPAWN_TIME) / moveBoost) {

            return;
        } 

        this.setTimeSinceWeaponSpawn(0);

        // Create weapon for L1 

        // Get random weapon type 
        double randWeaponType = Math.random();

        // Get random weapon Y 
        double randWeaponY = PIPE_MIN_Y + 
        (PIPE_MAX_Y - PIPE_MIN_Y) * Math.random();

        // Get weapon position 
        double weaponX = Window.getWidth();
        double weaponY = randWeaponY;

        Point weaponPosition = new Point(weaponX, weaponY);

        Weapon newWeapon;

        if (randWeaponType < 1 / ((double) 2)) {

            // Spawn bomb 
            newWeapon = new Bomb(weaponPosition, 
            new Point(PIPE_VELOCITY), 
            new Point(PIPE_ACCELERATION), 
            1, bombImage);
        } else {

            // Spawn rock 
            newWeapon = new Rock(weaponPosition, 
            new Point(PIPE_VELOCITY), 
            new Point(PIPE_ACCELERATION), 
            1, rockImage);
        }

        // Add new weapon 
        this.weapons.add(newWeapon);
    }

    /**
     * Moves solids active in the level 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    @Override 
    public void moveSolids(double moveBoost) {

        // Move solids with updated velocities 
        super.moveSolids(moveBoost);

        for (Weapon weapon : this.weapons) {

            if (weapon.getVelocity().getX() > 0) {

                // Weapon thrown right 
                weapon.move(1);
            } else {

                // Weapon moving left 
                weapon.move(moveBoost);
            }
        }
    }

    /**
     * Despwans solids no longer active in the level 
     */
    @Override 
    public void despawnSolids() {

        super.despawnSolids();
        
        // Despawn not thrown weapons 
        for (Weapon weapon : this.weapons) {

            if (weapon.getVelocity().getX() > 0) {

                // Weapon thrown 
                continue;
            }

            // Check weapon spawn start time 
            if (this.getLevelTime() 
            < WEAPON_SPAWN_START) {

                weapon.setHealth(0);

                continue;
            }

            // Check if weapon is between pipes 
            for (Pipe topPipe : this.topPipes) {

                if (weapon.overlapX(topPipe)) {

                    weapon.setHealth(0);
                }
            }

            // Check if weapon is out left 
            double weaponX = weapon 
            .getPosition().getX();
            double weaponWidth = weapon 
            .getImage().getWidth();

            if (weaponX + weaponWidth < 0) {

                weapon.setHealth(0);
            }
        }        
    }

    /**
     * Clears all solids other than the bird in the level 
     */
    @Override 
    public void clearSolids() {

        super.clearSolids();

        // Clear all weapons 
        for (Weapon weapon : this.weapons) {
            weapon.setHealth(0);
        }
    }

    /**
     * Draws solids active in the level 
     */
    @Override 
    public void drawSolids() {

        super.drawSolids();

        for (Weapon weapon : this.weapons) {
            
            if (weapon instanceof Rock) {

                // Draw rock 
                Rock rock = (Rock) weapon;
                
                rock.draw();
            }

            if (weapon instanceof Bomb) {

                // Draw bomb 
                Bomb bomb = (Bomb) weapon;

                bomb.draw();
            }
        }
    }

    /**
     * Detects collision between bird and both pipes and flames 
     * for damage, and weapons for pickup 
     */
    @Override 
    public void detectCollision() {

        super.detectCollision();

        // CHeck if bird has weapon 
        if (this.bird.getWeapon() != null) {

            return;
        }

        // Detect weapon pickup 
        // Iterate list backwards for element removal 
        for (int i = this.weapons.size() - 1; i >= 0; i--) {

            if (this.weapons.get(i).getVelocity().getX() > 0) {

                // Weapon thrown 
                continue;
            }

            if (this.bird.collision(this.weapons.get(i))) {

                // Pick up weapon 
                this.bird.setWeapon(this.weapons.get(i));
                this.weapons.remove(i);
            }
        }
    }

    /**
     * Throws weapon held by bird, if a weapon is held 
     */
    public void throwWeapon() {

        if (this.bird.getWeapon() == null) {
            return;
        }

        // Update weapon velocity 
        this.bird.getWeapon().getVelocity()
        .setX(WEAPON_VELOCITY.getX());

        // Give thrown weapon to ShadowFlap 
        Weapon thrownWeapon = null;

        if (this.bird.getWeapon() instanceof Bomb) {

            // Throw bomb 
            thrownWeapon = (Bomb) this.bird.getWeapon();
        }

        if (this.bird.getWeapon() instanceof Rock) {

            // Throw rock 
            thrownWeapon = (Rock) this.bird.getWeapon();
        }

        this.weapons.add(thrownWeapon);
        this.bird.setWeapon(null);
    }

    /**
     * Detects collision between thrown weapon and pipes, 
     * adding to level score if pipes destroyed 
     */
    public void weaponCollision() {

        // Destroying pipes adds to score 

        for (Weapon weapon : this.weapons) {

            if (weapon.getVelocity().getX() <= 0) {

                // Weapon not thrown 
                continue;
            }

            for (Pipe topPipe : this.topPipes) {

                if (weapon.collision(topPipe)) {

                    // Check if pipe survives 
                    if (weapon instanceof Bomb 
                    || (weapon instanceof Rock 
                    && topPipe instanceof PlasticPipe)) {

                        // Pipe pair destroyed 
                        topPipe.getPairPipe().takeDamage(1);
                        topPipe.takeDamage(1);
                        this.setLevelScore(this.getLevelScore() + 1);
                    }

                    weapon.takeDamage(1);
                }
            }

            for (Pipe bottomPipe : this.bottomPipes) {

                if (weapon.collision(bottomPipe)) {

                    // Check if pipe survives 
                    if (weapon instanceof Bomb 
                    || (weapon instanceof Rock 
                    && bottomPipe instanceof PlasticPipe)) {

                        // Pipe pair destroyed 
                        bottomPipe.getPairPipe().takeDamage(1);
                        bottomPipe.takeDamage(1);
                        this.setLevelScore(this.getLevelScore() + 1);
                    }

                    weapon.takeDamage(1);
                }
            }
        }
    }
}
