/*
    Copyright 2014-2017 DISCO Open Source (https://discoos.org/)

    This file is part of Ozi circle.
*/
/**
 *
 * @author Sven-Ove Bjerkan
 */
public class MissingCategory {
    private int r25;
    private int r50;
    private int r75;
    private int r95;
    private int n;
    private String desc;
    
    public MissingCategory(String desc, int n, int r25, int r50, int r75, int r95) {
        this.desc = desc;
        this.n = n;
        this.r25 = r25;
        this.r50 = r50;
        this.r75 = r75;
        this.r95 = r95;
    }    

    /**
     * @return the r25
     */
    public int getR25() {
        return r25;
    }

    /**
     * @return the r50
     */
    public int getR50() {
        return r50;
    }

    /**
     * @return the r75
     */
    public int getR75() {
        return r75;
    }

    /**
     * @return the r95
     */
    public int getR95() {
        return r95;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }
}
