package com.example.app1;

public class match_stats {

    //fields
    private int stat_id;

    //constructors
    public match_stats(int id) {
        this.stat_id = id;
    }

    //properties
    public void setStat_id(int id){
        this.stat_id = id;
    }

    public int getStat_id() {
        return stat_id;
    }

    public class attempts_stat {

        //fields
        private int stat_ft_attempted;
        private int stat_ft_made;
        private float stat_ft_per;
        private int stat_2pts_attempted;
        private int stat_2pts_made;
        private float stat_2pts_per;
        private int stat_3pts_attempted;
        private int stat_3pts_made;
        private float stat_3pts_per;

        //constructors
        public  attempts_stat(int ft_attempted, int ft_made, float ft_per, int twopts_attempted, int twopts_made, float twopts_per, int threepts_attempted, int threepts_made, float threepts_per){
            this.stat_2pts_attempted = twopts_attempted;
            this.stat_2pts_made = twopts_made;
            this.stat_3pts_attempted = threepts_attempted;
            this.stat_ft_attempted = ft_attempted;
            this.stat_ft_made = ft_made;
            this.stat_ft_per = ft_per;
            this.stat_2pts_per = twopts_per;
            this.stat_3pts_made = threepts_made;
            this.stat_3pts_per = threepts_per;
        }

        //properties
        public void setStat_ft_attempted(int ft_attempted){
            this.stat_ft_attempted = ft_attempted;
        }

        public int getStat_ft_attempted(){
            return stat_ft_attempted;
        }

        public void setStat_ft_made(int ft_made) {
            this.stat_ft_made = ft_made;
        }

        public int getStat_ft_made() {
            return stat_ft_made;
        }

        public void setStat_ft_per(float ft_per) {
            this.stat_ft_per = ft_per;
        }

        public float getStat_ft_per() {
            return stat_ft_per;
        }

        public void setStat_2pts_attempted(int twopts_attempted) {
            this.stat_2pts_attempted = twopts_attempted;
        }

        public int getStat_2pts_attempted() {
            return stat_2pts_attempted;
        }

        public void setStat_2pts_made(int twopts_made) {
            this.stat_2pts_made = twopts_made;
        }

        public int getStat_2pts_made() {
            return stat_2pts_made;
        }

        public void setStat_2pts_per(float twopts_per){
            this.stat_2pts_per = twopts_per;
        }

        public float getStat_2pts_per() {
            return stat_2pts_per;
        }

        public void setStat_3pts_attempted(int threepts_attempted) {
            this.stat_3pts_attempted = threepts_attempted;
        }

        public int getStat_3pts_attempted() {
            return stat_3pts_attempted;
        }

        public void setStat_3pts_made(int threepts_made) {
            this.stat_3pts_made = threepts_made;
        }

        public int getStat_3pts_made() {
            return stat_3pts_made;
        }

        public void setStat_3pts_per(float threepts_per){
            this.stat_3pts_per = threepts_per;
        }

        public float getStat_3pts_per() {
            return stat_3pts_per;
        }
    }
    public class num_stat {

        //fields
        private int stat_reb_off;
        private int stat_reb_def;
        private int stat_steals;
        private int stat_assists;
        private int stat_to;
        private int stat_blocks;
        private int stat_foul;
        private int stat_min;

        //constructors
        public  num_stat(int reb_off, int reb_def, int steals, int assists, int to, int blocks, int foul, int min){
            this.stat_reb_off = reb_off;
            this.stat_reb_def = reb_def;
            this.stat_steals = steals;
            this.stat_assists = assists;
            this.stat_to = to;
            this.stat_blocks = blocks;
            this.stat_foul = foul;
            this.stat_min = min;
        }

        //properties
        public void setStat_reb_off(int reb_off) {
            this.stat_reb_off = reb_off;
        }

        public int getStat_reb_off() {
            return stat_reb_off;
        }

        public void setStat_reb_def(int reb_def) {
            this.stat_reb_def = reb_def;
        }

        public int getStat_reb_def() {
            return stat_reb_def;
        }

        public void setStat_steals(int steals) {
            this.stat_steals = steals;
        }

        public int getStat_steals() {
            return  stat_steals;
        }

        public void  setStat_assists(int assists){
            this.stat_assists = assists;
        }

        public int getStat_assists() {
            return stat_assists;
        }

        public void setStat_to(int to) {
            this.stat_to = to;
        }

        public int getStat_to(){
            return stat_to;
        }

        public void setStat_blocks(int blocks) {
            this.stat_blocks = blocks;
        }

        public int getStat_blocks() {
            return stat_blocks;
        }

        public void setStat_foul(int foul) {
            this.stat_foul = foul;
        }

        public int getStat_foul() {
            return stat_foul;
        }

        public void setStat_min(int min) {
            this.stat_min = min;
        }

        public int getStat_min() {
            return stat_min;
        }
    }
}
