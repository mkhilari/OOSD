import bagel.*;

/**
 * Level0 created and updated by Flappy Bird game ShadowFlap 
 * @author Manish Khilari 
 */
public class Level0 extends Level {

    public static final int BIRD_HEALTH_L0 = 3;

    /**
     * Creates a new Level0 
     * @param endScore The end score to win the level 
     * @param background The background of the level 
     * @param birdWingUp The bird wing up image of the level 
     * @param birdWingDown The bird wing down image of the level 
     */
    public Level0(int endScore, Image background, 
    Image birdWingUp, Image birdWingDown) {

        super(endScore, background, birdWingUp, birdWingDown);
    }

    /**
     * Returns level specific maxHealth 
     * @return level specific maxHealth 
     */
    @Override 
    public int getMaxHealth() {
        return BIRD_HEALTH_L0;
    }
    
    /**
     * Spawns plastic pipes active in the level 
     * @param moveBoost The movespeed increase determined by timescale 
     */
    @Override 
    public void spawnPipes(double moveBoost) {

        if (this.getTimeSincePipeSpawn() 
        < ((double) PIPE_SPAWN_TIME) / moveBoost) {

            return;
        }

        this.setTimeSincePipeSpawn(0);

        // Create pipes for L0 
        Image pipeImage = plasticPipeImage;

        // Get random numYSteps 
        double randYSteps = Math.random();
        int numYSteps;

        if (randYSteps < 1 / ((double) 3)) {

            numYSteps = 0;
        } else if (randYSteps < 2 / ((double) 3)) {

            numYSteps = 1;
        } else {

            numYSteps = 2;
        }

        // Create top pipe 
        double topPipeX = Window.getWidth();
        double topPipeY = PIPE_MIN_Y 
        + PIPE_STEP_Y * numYSteps 
        - pipeImage.getHeight();

        Point topPipePosition = new Point(topPipeX, topPipeY);

        // Add to top pipes 
        Pipe newTopPipe = new PlasticPipe(topPipePosition, 
        new Point(PIPE_VELOCITY), 
        new Point(PIPE_ACCELERATION), 
        1, pipeImage, true);

        this.topPipes.add(newTopPipe);

        // Create bottom pipe 
        double bottomPipeX = Window.getWidth();
        double bottomPipeY = PIPE_MIN_Y 
        + PIPE_STEP_Y * numYSteps 
        + PIPE_GAP.getY();

        Point bottomPipePosition = new Point(bottomPipeX, 
        bottomPipeY);

        // Add to bottom pipes 
        Pipe newBottomPipe = new PlasticPipe(bottomPipePosition, 
        new Point(PIPE_VELOCITY), 
        new Point(PIPE_ACCELERATION), 
        1, pipeImage, false);

        this.bottomPipes.add(newBottomPipe);

        // Set pair pipes 
        newTopPipe.setPairPipe(newBottomPipe);
        newBottomPipe.setPairPipe(newTopPipe);
    }
}
