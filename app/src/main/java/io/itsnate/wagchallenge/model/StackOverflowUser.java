package io.itsnate.wagchallenge.model;

public class StackOverflowUser {
    BadgeCounts badgeCounts;
    String displayName;
    String gravatarUrl;

    public StackOverflowUser(BadgeCounts badgeCounts, String displayName, String gravatarUrl) {
        this.badgeCounts = badgeCounts;
        this.displayName = displayName;
        this.gravatarUrl = gravatarUrl;
    }

    public BadgeCounts getBadgeCounts() {
        return badgeCounts;
    }

    public void setBadgeCounts(BadgeCounts badgeCounts) {
        this.badgeCounts = badgeCounts;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGravatarUrl() {
        return gravatarUrl;
    }

    public void setGravatarUrl(String gravatarUrl) {
        this.gravatarUrl = gravatarUrl;
    }

    public static class BadgeCounts {
        Integer bronze;
        Integer silver;
        Integer gold;

        public BadgeCounts(Integer bronze, Integer silver, Integer gold) {
            this.bronze = bronze;
            this.silver = silver;
            this.gold = gold;
        }

        public Integer getBronze() {
            return bronze;
        }

        public void setBronze(Integer bronze) {
            this.bronze = bronze;
        }

        public Integer getSilver() {
            return silver;
        }

        public void setSilver(Integer silver) {
            this.silver = silver;
        }

        public Integer getGold() {
            return gold;
        }

        public void setGold(Integer gold) {
            this.gold = gold;
        }
    }
}
