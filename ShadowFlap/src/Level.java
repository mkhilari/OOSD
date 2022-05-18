import bagel.*;
import java.util.ArrayList;

/**
 * Level created and updated by Flappy Bird game ShadowFlap 
 * @author Manish Khilari 
 */
public abstract class Level {

    private final Image fullLife = new Image("res/level/fullLife.png");
    private final Image noLife = new Image("res/level/noLife.png");

    protected final Image plasticPipeImage = new Image("res/level/plasticPipe.png");

    public static final Point BIRD_INITIAL_POSITION = new Point(200, 350);
    public static final Point BIRD_INITIAL_VELOCITY = new Point(0, -6);
    public static final Point BIRD_ACCELERATION = new Point(0, 0.4);

    public static final Point BIRD_MAX_VELOCITY = new Point(0, 10);
    public static final Point BIRD_JUMP_VELOCITY = new Point(0, -6);

    public static final int PIPE_SPAWN_TIME = 100;
    public static final int PIPE_MIN_Y = 100;
    public static final int PIPE_MAX_Y = 500;
    public static final int PIPE_STEP_Y = 100;

    public static final Point PIPE_GAP = new Point(0, 168);
    public static final Point PIPE_VELOCITY = new Point(-5, 0);
    public static final Point PIPE_ACCELERATION = new Point(0, 0);

    private static final Point LIFE_BAR_POSITION = new Point(100, 15);
    private static final Point LIFE_BAR_GAP = new Point(50, 0);
    
    protected Bird bird;
    protected ArrayList<Pipe> topPipes = new ArrayList<>();
    protected ArrayList<Pipe> bottomPipes = new ArrayList<>();

    private int levelTime = 0;
    private int levelScore = 0;
    private int endScore;

    private int timeSincePipeSpawn = 0;

    private Image background;
    private Image birdWingUp;
    private Image birdWingDown;

    /**
     * Creates a new Level 
     * @param endScore The end score to win the level 
     * @param background The background of the level 
     * @param birdWingUp The bird wing up image of the level 
     * @param birdWingDown The bird wing down image of the level 
     */
    public Level(int endScore, Image background, 
    Image birdWingUp, Image birdWingDown) {

        this.endScore = endScore;
        this.background = background;
        this.birdWingUp = birdWingUp;
        this.birdWingDown = birdWingDown;

        this.spawnBird(this.getMaxHealth(), birdWingDown);
    }

    /**
     * Returns bird active in level 
     * @return bird active in level 
     */
    public Bird getBird() {
        return this.bird;
    }

    /**
     * Returns levelTime 
     * @return levelTime 
     */
    public int getLevelTime() {
        return this.levelTime;
    }

    /**
     * Returns levelScore 
     * @return levelScore 
     */
    public int getLevelScore() {
        return this.levelScore;
    }

    /**
     * Returns endScore 
     * @return endScore 
     */
    public int getEndScore() {
        return this.endScore;
    }

    /**
     * Returns timeSincePipeSpawn 
     * @return timeSincePipeSpawn 
     */
    public int getTimeSincePipeSpawn() {
        return this.timeSincePipeSpawn;
    }

    /**
     * Returns level specific maxHealth 
     * @return level specific maxHealth 
     */
    public abstract int getMaxHealth();

    /**
     * Sets levelTime 
     * @param levelTime The new value 
     */
    public void setLevelTime(int levelTime) {
        this.levelTime = levelTime;
    }

    /**
     * Sets levelScore 
     * @param levelScore The new value 
     */
    public void setLevelScore(int levelScore) {
        this.levelScore = levelScore;
    }

    /**
     * Sets timeSincePipeSpawn 
     * @param timeSincePipeSpawn The new value 
     */
    public void setTimeSincePipeSpawn(int timeSincePipeSpawn) {
        this.timeSincePipeSpawn = timeSincePipeSpawn;
    }

    /**
     * Updates and draws the level 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    public void update(double moveBoost) {

        this.setLevelTime(this.getLevelTime() + 1);
        this.setTimeSincePipeSpawn(this.getTimeSincePipeSpawn() + 1);

        this.moveSolids(moveBoost);
        this.despawnSolids();

        this.drawBackground();
        
        this.bird.flapWings(birdWingUp, birdWingDown);

        this.spawnPipes(moveBoost);

        this.drawSolids();
        this.drawLifeBar(fullLife, noLife);

        if (this.bird.isOutOfBounds()) {

            this.respawnBird();
        }

        this.detectCollision();

        this.updateScore();
    }

    /**
     * Creates the bird active in the level 
     * @param health The initial health of the bird 
     * @param image The initial image of the bird 
     */
    public void spawnBird(int health, Image image) {
        
        // Create bird 
        this.bird = new Bird(new Point(BIRD_INITIAL_POSITION), 
        new Point(BIRD_INITIAL_VELOCITY), 
        new Point(BIRD_ACCELERATION), 
        health, image, new Point(BIRD_MAX_VELOCITY), 
        new Point(BIRD_JUMP_VELOCITY));
    }

    /**
     * Respawns the bird at its default position 
     */
    public void respawnBird() {

        // Respawn bird at initial position 
        this.bird.setPosition(new Point(BIRD_INITIAL_POSITION));

        // Respawn bird with jump velocity 
        this.bird.setVelocity(new Point(BIRD_INITIAL_VELOCITY));

        this.bird.takeDamage(1);
    }

    /**
     * Spawns pipes specific to the level 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    public abstract void spawnPipes(double moveBoost);
    
    /**
     * Moves solids active in the level 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    public void moveSolids(double moveBoost) {

        // Move solids with updated velocities 
        this.bird.move(moveBoost);

        for (Pipe topPipe : this.topPipes) {
            topPipe.move(moveBoost);
        }

        for (Pipe bottomPipe : this.bottomPipes) {
            bottomPipe.move(moveBoost);
        }
    }

    /**
     * Despwans solids no longer active in the level 
     */
    public void despawnSolids() {

        // Despawn pipes 
        for (Pipe topPipe : this.topPipes) {

            // Check if pipe is out left 
            double pipeX = topPipe 
            .getPosition().getX();
            double pipeWidth = topPipe 
            .getImage().getWidth();

            if (pipeX + pipeWidth < 0) {

                // Despawn top and bottom pipe 
                topPipe.setHealth(0);
            }
        }

        for (Pipe bottomPipe : this.bottomPipes) {

            // Check if pipe is out left 
            double pipeX = bottomPipe 
            .getPosition().getX();
            double pipeWidth = bottomPipe
            .getImage().getWidth();

            if (pipeX + pipeWidth < 0) {

                // Despawn top and bottom pipe 
                bottomPipe.setHealth(0);
            }
        }
    }

    /**
     * Clears all solids other than the bird in the level 
     */
    public void clearSolids() {

        // Clear all pipes 
        for (Pipe topPipe : this.topPipes) {
            topPipe.setHealth(0);
        }

        for (Pipe bottomPipe : this.bottomPipes) {
            bottomPipe.setHealth(0);
        }
    }

    /**
     * Draws the background of the level 
     */
    public void drawBackground() {

        this.background.drawFromTopLeft(0, 0);
    }

    /**
     * Draws solids active in the level 
     */
    public void drawSolids() {

        this.bird.draw();
        
        for (Pipe topPipe : this.topPipes) {

            if (topPipe instanceof SteelPipe) {

                // Draw steel pipe with flames 
                SteelPipe steelTopPipe 
                = (SteelPipe) topPipe;

                steelTopPipe.draw();
            } else {

                topPipe.draw();
            }
        }

        for (Pipe bottomPipe : this.bottomPipes) {
            
            if (bottomPipe instanceof SteelPipe) {

                // Draw steel pipe with flames 
                SteelPipe steelBottomPipe 
                = (SteelPipe) bottomPipe;

                steelBottomPipe.draw();
            } else {

                bottomPipe.draw();
            }
        }
    }

    /**
     * Draws bird life bar with given images and maxHealth 
     * @param fullLife The image of a full life 
     * @param noLife The image of an empty life 
     */
    public void drawLifeBar(Image fullLife, Image noLife) {

        // Draw life bar from top left 
        Point currPosition = new Point(LIFE_BAR_POSITION);
        Image currHeart;

        for (int i = 0; i < this.getMaxHealth(); i++) {

            if (i < this.bird.getHealth()) {

                // Get full heart 
                currHeart = fullLife;
            } else {

                // Get empty heart 
                currHeart = noLife;
            }

            // Draw heart from top left 
            double heartX = currPosition.getX();
            double heartY = currPosition.getY();

            currHeart.drawFromTopLeft(heartX, heartY);
            
            // Move to next heart 
            currPosition.add(1, LIFE_BAR_GAP);
        }
    }

    /**
     * Updates the score when bird successfully passes a pipe 
     */
    public void updateScore() {

        for (Pipe topPipe : this.topPipes) {

            if (topPipe.getHealth() == 0) {

                // Pipe dead 
                continue;
            }

            if (topPipe.getIsPassed()) {

                // Pipe already passed 
                continue;
            }

            // Update score if bird center passes pipe right 
            double birdX = this.bird.getPosition().getX();
            double birdWidth = this.bird.getImage().getWidth();

            double pipeX = topPipe.getPosition().getX();
            double pipeWidth = topPipe.getImage().getWidth();

            if (birdX + birdWidth / 2 > pipeX + pipeWidth) {

                // Pipes passed 
                this.setLevelScore(this.getLevelScore() + 1);

                topPipe.setIsPassed(true);
            }
        }
    }

    /**
     * Detects collision between bird and pipes 
     */
    public void detectCollision() {

        for (Pipe topPipe : this.topPipes) {

            if (this.bird.collision(topPipe)) {

                // Collision with top pipe 
                this.bird.takeDamage(1);

                // Pipe pair destroyed 
                topPipe.getPairPipe().takeDamage(1);
                topPipe.takeDamage(1);
            }

            if (topPipe instanceof SteelPipe) {

                // Get flame 
                SteelPipe steelPipe 
                = (SteelPipe) topPipe;

                Flame flame = steelPipe.getFlame();

                if (this.bird.collision(flame)) {

                    // Collision with top flame 
                    this.bird.takeDamage(1);
                    flame.takeDamage(1);
                    flame.setFlameHit(true);
                }
            }
        }

        for (Pipe bottomPipe : this.bottomPipes) {

            if (this.bird.collision(bottomPipe)) {

                // Collision with bottom pipe 
                this.bird.takeDamage(1);

                // Pipe pair destroyed 
                bottomPipe.getPairPipe().takeDamage(1);
                bottomPipe.takeDamage(1);
            }

            if (bottomPipe instanceof SteelPipe) {

                // Get flame 
                SteelPipe steelPipe 
                = (SteelPipe) bottomPipe;

                Flame flame = steelPipe.getFlame();

                if (this.bird.collision(flame)) {

                    // Collision with bottom flame 
                    this.bird.takeDamage(1);
                    flame.takeDamage(1);
                    flame.setFlameHit(true);
                }
            }
        }
    }
}
