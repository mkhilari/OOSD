import bagel.*;
import java.util.ArrayList;

/**
 * SWEN20003 Project 2, Semester 2, 2021 
 * Flappy Bird game extending from Bagel's AbstractGame 
 * @author Manish Khilari 
 */
public class ShadowFlap extends AbstractGame {

    private final Image backgroundL0 = new Image("res/level-0/background.png");
    private final Image birdWingUpL0 = new Image("res/level-0/birdWingUp.png");
    private final Image birdWingDownL0 = new Image("res/level-0/birdWingDown.png");

    private final Image backgroundL1 = new Image("res/level-1/background.png");
    private final Image birdWingUpL1 = new Image("res/level-1/birdWingUp.png");
    private final Image birdWingDownL1 = new Image("res/level-1/birdWingDown.png");
    
    private final Font messageFont = new Font("res/font/slkscr.ttf", 48);

    public static final int L0_END_SCORE = 10;
    public static final int MID_LEVEL_FRAMES = 150;
    public static final int L1_END_SCORE = 30;

    public static final double MOVE_BOOST_START = 0.5;
    public static final double MOVE_BOOST_STEP = 0.5;
    public static final int TIME_SCALE_MIN = 1;
    public static final int TIME_SCALE_MAX = 5;

    public static final Point SCORE_BL = new Point(100, 100);
    public static final Point MESSAGE_GAP = new Point(0, 75);

    private int timeScale = 1;
    private int stage = 0;
    private int stageTime = 0;
    private Level level;
    private int finalScore = 0;
    private boolean gameLost = false;

    /**
     * Creates a new Flappy Bird game 
     */
    public ShadowFlap() {
    }

    /**
     * The entry point for the program. 
     */
    public static void main(String[] args) {
        ShadowFlap game = new ShadowFlap();
        game.run();
    }

    /**
     * Performs a state update. 
     * allows the game to exit when the escape key is pressed. 
     * @param input User input for next update 
     */
    @Override 
    public void update(Input input) {

        if (input.wasPressed(Keys.ESCAPE)) {

            // Exit game 
            Window.close();
        }

        if (input.wasPressed(Keys.L)) {

            if (this.timeScale < TIME_SCALE_MAX) {

                // Increase timeScale 
                this.timeScale += 1;
            }
        }

        if (input.wasPressed(Keys.K)) {

            if (this.timeScale > TIME_SCALE_MIN) {

                // Decrease timeScale 
                this.timeScale += -1;
            }
        }

        if (this.gameLost) {

            // Draw game over 
            if (this.stage < 4) {

                // Draw L0 background 
                this.backgroundL0.drawFromTopLeft(0, 0);
            } else {

                // Draw L1 background 
                this.backgroundL1.drawFromTopLeft(0, 0);
            }

            this.drawDoubleMessage("GAME OVER", 
            "FINAL SCORE: " + this.finalScore);

            return;
        }

        // Get level 
        if (stage == 1 && this.level == null) {

            // Create Level0 
            this.level = new Level0(L0_END_SCORE, this.backgroundL0, 
            this.birdWingUpL0, this.birdWingDownL0);
        }

        if (stage == 4 && this.level == null) {

            // Create Level1 
            this.level = new Level1(L1_END_SCORE, this.backgroundL1, 
            this.birdWingUpL1, this.birdWingDownL1);
        }

        // Get moveBoost from timescale 
        double moveBoost = MOVE_BOOST_START 
        + MOVE_BOOST_STEP * this.timeScale;

        // Update level 
        if (this.level != null) {
            
            this.level.update(moveBoost);
        }

        this.stageTime += 1;

        if (this.stage == 0) {

            // Draw start screen 
            this.backgroundL0.drawFromTopLeft(0, 0);

            this.drawMessageFromCenter("PRESS SPACE TO START", 
            Window.getWidth() / 2, Window.getHeight() / 2);
        }

        if (this.level != null) {

            // Check levelScore 
            if (this.level.getLevelScore() 
            == this.level.getEndScore()) {

                this.level.clearSolids();
                this.goNextStage();

                return;
            }

            this.drawScore();

            // Get bird health 
            if (this.level.getBird().getHealth() == 0) {

                this.gameOver();

                return;
            }
        }

        if (this.stage == 2) {

            // Check mid level frames 
            if (this.stageTime == MID_LEVEL_FRAMES) {

                this.goNextStage();

                return;
            }

            // Draw level up screen 
            this.backgroundL0.drawFromTopLeft(0, 0);

            this.drawDoubleMessage("LEVEL UP!", 
            "FINAL SCORE: " + this.finalScore);

            return;
        }

        if (this.stage == 3) {

            // Draw shoot screen 
            this.backgroundL1.drawFromTopLeft(0, 0);

            this.drawDoubleMessage("PRESS SPACE TO START", 
            "PRESS 'S' TO SHOOT");
        }

        if (this.stage == 5) {

            // Draw win screen 
            this.backgroundL1.drawFromTopLeft(0, 0);

            this.drawDoubleMessage("CONGRATULATIONS!", 
            "FINAL SCORE: " + this.finalScore);
        }

        if (input.wasPressed(Keys.SPACE)) {

            if (this.stage == 0 || this.stage == 3) {

                this.goNextStage();
            }

            if (this.level != null) {

                this.level.getBird().jump();
            }
        }

        if (input.wasPressed(Keys.S)) {

            if (this.level instanceof Level1) {

                Level1 level1 = (Level1) this.level;
                level1.throwWeapon();
            }
        }
    }

    /**
     * Moves to the next stage, and resets stage time and score 
     */
    public void goNextStage() {
        
        // Move to next stage 
        this.timeScale = 1;
        this.stage += 1;
        this.stageTime = 0;

        // Get level end score 
        if (this.level != null) {

            this.finalScore = this.level.getLevelScore();
        }

        this.level = null;
    }

    /**
     * Ends the game on a loss 
     */
    public void gameOver() {

        // End game 
        this.gameLost = true;

        if (this.level != null) {

            this.finalScore = this.level.getLevelScore();
        }

        this.level = null;
    }

    /**
     * Draws the given message with center at (x, y) 
     * @param message The message to draw 
     * @param x The x value 
     * @param y The y value 
     */
    public void drawMessageFromCenter(String message, 
    double x, double y) {

        // Get message width 
        double messageWidth = this.messageFont
        .getWidth(message);

        // Center message 
        double messageX = x - messageWidth / 2;

        this.messageFont.drawString(message, 
        messageX, y); 
    }

    /**
     * Draws the score at the default location during gameplay 
     */
    public void drawScore() {

        if (this.level == null) {
            return;
        }

        // Draw score from bottom left 
        double scoreX = SCORE_BL.getX();
        double scoreY = SCORE_BL.getY();

        this.messageFont.drawString("SCORE: " 
        + this.level.getLevelScore(), scoreX, scoreY);
    }

    /**
     * Draws the given messages one per line at the center of the window 
     * @param messageA The first message to draw 
     * @param messageB The second message to draw 
     */
    public void drawDoubleMessage(String messageA, 
    String messageB) {

        // Draw messageA and messageB at window center 
        double messageAX = Window.getWidth() / 2;
        double messageAY = Window.getHeight() / 2 
        - MESSAGE_GAP.getY() / 2; 

        this.drawMessageFromCenter(messageA, 
        messageAX, messageAY);

        double messageBX = Window.getWidth() / 2;
        double messageBY = Window.getHeight() / 2 
        + MESSAGE_GAP.getY() / 2; 

        this.drawMessageFromCenter(messageB, 
        messageBX, messageBY);
    }

}
