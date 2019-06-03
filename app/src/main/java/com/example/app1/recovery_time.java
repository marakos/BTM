package com.example.app1;

import java.io.Serializable;

public class recovery_time implements Serializable {

    private int recovery_id;
    private float recovery_best_case;
    private float recovery_worst_case;

    public recovery_time(int recovery_id, float recovery_best_case, float recovery_worst_case) {
        this.recovery_id = recovery_id;
        this.recovery_best_case = recovery_best_case;
        this.recovery_worst_case = recovery_worst_case;
    }

    public int getRecovery_id() {
        return recovery_id;
    }

    public void setRecovery_id(int recovery_id) {
        this.recovery_id = recovery_id;
    }

    public float getRecovery_best_case() {
        return recovery_best_case;
    }

    public void setRecovery_best_case(float recovery_best_case) {
        this.recovery_best_case = recovery_best_case;
    }

    public float getRecovery_worst_case() {
        return recovery_worst_case;
    }

    public void setRecovery_worst_case(float recovery_worst_case) {
        this.recovery_worst_case = recovery_worst_case;
    }
}
