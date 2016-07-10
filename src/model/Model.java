package model;

public class Model {
    private int secretNumber;
    private int minValue;
    private int maxValue;
    private int RAND_MAX;

    // Constructor
    public Model(){
    	// TODO: attempts' history
    }

    /**
     * Generate random number in the range 0 - 100
     * @return random integer number
     */
    public int rand(){
        RAND_MAX = minValue + (int)(Math.random()*(maxValue - minValue + 1)); // generate maximum value of the range from 1 - 99
        return (int)(Math.random()*(RAND_MAX + 1));
    }

    /**
     * Generate random value in range from minimum to maximum values entered by user
     * @param min minimum value of the range
     * @param max maximum value of the range
     * @return random integer number
     */
    public int rand(int min, int max){
        return min + (int)(Math.random()*((max - min) + 1));
    }

    /**
     * Compare number on equals
     * @param userNumber number entered by user
     * @return true in case numbers are equals, else return false
     */
    public boolean isEquals(int userNumber){
        if (userNumber < secretNumber) {
            minValue = userNumber;
            return false;
        }else if (userNumber > secretNumber){
            maxValue = userNumber;
            return false;
        }
        return true;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getRAND_MAX() {
        return RAND_MAX;
    }
    
    public int getSecretNumber(){
    	return secretNumber;
    }
}